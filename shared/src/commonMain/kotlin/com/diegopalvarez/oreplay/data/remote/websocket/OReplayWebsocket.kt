package com.diegopalvarez.oreplay.data.remote.websocket

import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.domain.repository.util.handleNetworkError
import com.diegopalvarez.oreplay.data.remote.api.OReplayAPI
import com.diegopalvarez.oreplay.data.remote.dto.liveResults.RemoteLiveResult
import com.diegopalvarez.oreplay.data.remote.dto.liveResults.RemoteLiveResultsResponse
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteResult
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteResultsResponse
import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.websocket.close
import io.ktor.client.plugins.websocket.webSocketSession
import io.ktor.client.request.url
import io.ktor.websocket.Frame
import io.ktor.websocket.WebSocketSession
import io.ktor.websocket.readText
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.isActive
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.coroutines.cancellation.CancellationException
import kotlin.math.pow
import kotlin.time.Duration.Companion.milliseconds

const val WEBSOCKET_URL = "wss://www.oreplay.es/api/v1/live/stages/"
const val MAX_BACKOFF_DELAY = 6
const val BACKOFF_BASE_MS = 500F
class OReplayWebsocket(
    val eventID: String,
    val stageID: String,
    val classID: String,
): KoinComponent {
    // Inject the dependencies
    val client by inject<HttpClient>()
    val api by inject<OReplayAPI>()

    // Expose the Error Stream
    private val _error = MutableStateFlow<RepositoryError?>(null)
    val error: StateFlow<RepositoryError?> = _error

    // Store the created websocket
    private var session: WebSocketSession? = null

    // Store if the user has closed the connection
    private var userStopped = false

    // Store if the initial results have been seeded
    private var hasSeeded: Boolean = false

    // Store the backoff delay for attempting to reconnect
    private var backoffDelay = 0

    // Store the list of results from the previous fetches, as DTOs from the API
    private val currentResults: MutableMap<String, RemoteResult> = mutableMapOf()

    // Store the list of updates that have been received while fetching the inital results
    private val updatesArrivedWhileSeeding: MutableList<List<RemoteLiveResult>> = mutableListOf()

    /**
     * Function to create a new websocket connection with a class from a stage, and get the results flow for it
     */
    fun getResultsStream(): Flow<List<RemoteResult>> {
        return flow {
            // Keep the results updated while the connection is active
            while(currentCoroutineContext().isActive && !userStopped) {
                try {
                    // Create connection to the websocket
                    session = client.webSocketSession {
                        url("$WEBSOCKET_URL/$stageID/classes/$classID")
                    }

                    // Reset the backoff delay to its initial value
                    backoffDelay = 0

                    // After the websocket has been created, seed the results from the API
                    seed()

                    // Emit the current initial results
                    emit(currentResults.values.toList())

                    // Collect the live updates stream
                    session!!
                        .incoming
                        .consumeAsFlow()
                        .filterIsInstance<Frame.Text>()
                        .collect { update ->
                            // Print the update
                            println(update)

                            // Parse the response to a DTO object
                            val incomingResults = Json.decodeFromString<RemoteLiveResultsResponse>(update.readText())

                            // Change the action on the update depeding on whether the initial results have been seeded
                            if (hasSeeded) {
                                applyUpdate(incomingResults.results)

                                // Emit the new results after applying the changes
                                emit(currentResults.values.toList())
                            } else {
                                updatesArrivedWhileSeeding.add(incomingResults.results)
                            }
                        }
                } catch (e: CancellationException) {
                    // The user willingly disconnected the websocket
                    throw e
                } catch (e: Exception) {
                    // If there's a disconnection not triggered by the user, the results must be seeded again from the REST API after a backoff delay
                    hasSeeded = false
                    updatesArrivedWhileSeeding.clear()
                    reconnectDelay()
                }
            }
        }
    }

    suspend fun close() {
        userStopped = true
        session?.close()
        session = null
    }

    suspend fun seed(){
        val response = api.getStageResults(
            eventID = eventID,
            stageID = stageID,
            classID = classID,
        )
            .onSuccess { success ->
                // Clear the current results before adding the ones received from the api
                currentResults.clear()

                success.results.forEach { currentResults[it.id] = it }
                _error.value = null
                hasSeeded = true

                // After a successful seed, apply the changes received while seeding
                updatesArrivedWhileSeeding.forEach(::applyUpdate)

                // Clear the cached updates after applying them
                updatesArrivedWhileSeeding.clear()
            }
            .onError {
                _error.value = handleNetworkError(it)
            }
    }

    private fun applyUpdate(incomingResults: List<RemoteLiveResult>) {
        // Create a new list
        val updatedRunners = mutableMapOf<String, RemoteResult>()

        for (runner in incomingResults) {
            // Get the current result for this runner
            val currentResult = currentResults[runner.id]

            // If the runner existed
            if (currentResult != null) {
                // Merge the two results
                val newResult = mergeRemoteResults(currentResult, runner)
                updatedRunners[newResult.id] = newResult
            } else {
                // Keep the new result
                val newResult = mergeRemoteNewResults(runner)
                updatedRunners[newResult.id] = newResult
            }
        }

        // Set the new list. This automatically deletes the runners that aren't present in the new list
        currentResults.clear()
        currentResults.putAll(updatedRunners)
    }

    private suspend fun reconnectDelay() {
        // Increase the backoff delay before reconnecting
        backoffDelay = minOf(backoffDelay + 1, MAX_BACKOFF_DELAY)

        // Calculate the delay exponentially from the backoff delay
        val msDelay = (BACKOFF_BASE_MS * 2).pow(backoffDelay).toLong().milliseconds

        // Apply the delay
        delay(msDelay)
    }
}