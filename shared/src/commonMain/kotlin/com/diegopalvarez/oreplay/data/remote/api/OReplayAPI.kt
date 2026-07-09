package com.diegopalvarez.oreplay.data.remote.api

import com.diegopalvarez.oreplay.core.util.NetworkError
import com.diegopalvarez.oreplay.data.remote.dto.events.RemoteEventResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import com.diegopalvarez.oreplay.core.util.Result
import com.diegopalvarez.oreplay.data.remote.dto.classes.RemoteClassesResponse
import com.diegopalvarez.oreplay.data.remote.dto.clubs.RemoteClubsResponse
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteResultsResponse
import com.diegopalvarez.oreplay.data.remote.dto.stages.RemoteEventDetailsResponse
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerializationException

// Base URL Definitions
const val EVENTS_URL = "https://www.oreplay.es/api/v1/events"

class OReplayAPI(
    val client: HttpClient // Inject HTTP Client
): KoinComponent {
    /**
     *  Function to get the list of events uploaded to the server
     *  @param moment one of the common filters provided by the API (today, past or future). Defaults to null
     *  @param page page if the results fill the first page. Defaults to null
     *
    */
    suspend fun getEvents(moment: String? = null, page: Int? = null): Result<RemoteEventResponse, NetworkError> {
       return makeRequest<RemoteEventResponse> {
            client.get(
                urlString = EVENTS_URL
            ) {
                if(!moment.isNullOrBlank()) {
                    parameter("when", moment)
                }

                if(page != null) {
                    parameter("page", page.toString())
                }
            }
       }
    }

    /**
     *  Function to get the list of events uploaded to the server, filtered by all specified characteristics
     *  @param description name of the Event. Defaults to null
     *  @param initialDate first date (included) for the range used to search. Without a _finalDate, returns any future Event. Defaults to null
     *  @param finalDate last date (included) for the range used to search. Without a _initialDate, returns any previous Event. Defaults to null
     */
    suspend fun getEventsFiltered(description: String? = null, initialDate: LocalDate? = null, finalDate: LocalDate? = null): Result<RemoteEventResponse, NetworkError> {
        return makeRequest<RemoteEventResponse> {
            client.get(
                urlString = EVENTS_URL
            ) {
                if(!description.isNullOrBlank()) {
                    parameter("description", description)
                }

                if(initialDate != null) {
                    parameter("initial_date", initialDate.toString())  // Automatically transforms the date following the IS O8601 (YYYY-MM-DD)
                }

                if(finalDate != null) {
                    parameter("final_date", finalDate.toString())  // Automatically transforms the date following the IS O8601 (YYYY-MM-DD)
                }
            }
        }
    }

    /**
     *  Function to get the Stages for a given Event
     *  @param eventID ID of the Event
     */
    suspend fun getEventStages(eventID: String): Result<RemoteEventDetailsResponse, NetworkError> {
        return makeRequest<RemoteEventDetailsResponse> {
            client.get(
                urlString = "$EVENTS_URL/events/$eventID/stages"
            )
        }
    }

    /**
     * Function to get the Classes for a Stage of a given Event
     * @param eventID ID of the Event
     * @param stageID ID of the Stage inside the Event
     */
    suspend fun getStageClasses(eventID: String, stageID: String): Result<RemoteClassesResponse, NetworkError> {
        return makeRequest<RemoteClassesResponse> {
            client.get(
                urlString = "$EVENTS_URL/events/$eventID/stages/$stageID/classes"
            )
        }
    }

    /**
     * Function to get the Clubs for a Stage of a given Event
     * @param eventID ID of the Event
     * @param stageID ID of the Stage inside the Event
     */
    suspend fun getStageClubs(eventID: String, stageID: String): Result<RemoteClubsResponse, NetworkError> {
        return makeRequest<RemoteClubsResponse> {
            client.get(
                urlString = "$EVENTS_URL/events/$eventID/stages/$stageID/clubs"
            )
        }
    }

    // TODO - Add method to get the stage STATS

    /**
     * Function to get the Results for a Stage of a given Event, filtering by a specific class, club, text or station
     * @param eventID ID of the Event
     * @param stageID ID of the Stage inside the Event
     * @param classID ID of the class inside the Stage. Not required, defaults to null
     * @param clubID ID of the club inside the Stage. Not required, defaults to null
     * @param text Text used to filter. Can be a runner name or SICard number. Not required, defaults to null
     * @param station Number of station. It will only show the corresponding split for all runners selected, and an empty string for runners that didn't visit that station.
     */
    suspend fun getStageResults(eventID: String, stageID: String, classID: String? = null, clubID: String? = null, text: String? = null, station: Int? = null): Result<RemoteResultsResponse, NetworkError> {
        return makeRequest {
            client.get(
                urlString = "$EVENTS_URL/events/$eventID/stages/$stageID/results"
            ) {
                if(!classID.isNullOrBlank()) {
                    parameter("class_id", classID)
                }
                if(!clubID.isNullOrBlank()) {
                    parameter("club_id", clubID)
                }
                if(!text.isNullOrBlank()) {
                    parameter("text", text)
                }
                if(station != null) {
                    parameter("station", station.toString())
                }
            }
        }
    }

    // TODO - Might be interesting to use the endpoint /resultsByClass

    /**
     * Private TRY-CATCH wrapper that handles the different calls to the API and solves the different possible errors
     *
     * It has to be an INLINE REIFIED function in order to be able to specify and access the different possible data types at runtime. Kotlin by default only allows access to data type definitions at compile time
     * @param request Function called to make the actual HTTP request. It can have parameters specified as usual because it's a lambda
     */
    suspend inline fun <reified T> makeRequest(request: () -> HttpResponse): Result<T, NetworkError> {
        val response = try {
            request()
        }
        catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        }
        catch (e: ServerResponseException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }
        catch (e: Exception) {
            // Default case, fallback to an unknown error
            return Result.Error(NetworkError.UNKNOWN)
        }

        // Handle all possible return codes from the HTTP API
        return when(response.status.value) {
            in 200 .. 299 -> {
                val eventList = try{
                    response.body<T>()
                }
                catch (e: SerializationException){
                    return Result.Error(NetworkError.SERIALIZATION)
                }
                Result.Success(eventList)
            }
            400 -> Result.Error(NetworkError.BAD_REQUEST)
            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            403 -> Result.Error(NetworkError.FORBIDDEN)
            404 -> Result.Error(NetworkError.NOT_FOUND)
            405 -> Result.Error(NetworkError.METHOD_NOT_ALLOWED)
            409 -> Result.Error(NetworkError.CONFLICT)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)}
    }
}