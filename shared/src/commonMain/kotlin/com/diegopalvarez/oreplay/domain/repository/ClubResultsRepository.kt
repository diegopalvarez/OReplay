package com.diegopalvarez.oreplay.domain.repository

import com.diegopalvarez.oreplay.core.util.NetworkError
import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.data.remote.api.OReplayAPI
import com.diegopalvarez.oreplay.domain.types.StageType
import org.koin.core.component.KoinComponent
import com.diegopalvarez.oreplay.core.util.Result
import com.diegopalvarez.oreplay.data.mappers.remote.getClassicResults
import com.diegopalvarez.oreplay.data.mappers.remote.getTeamResults
import com.diegopalvarez.oreplay.data.mappers.remote.getUnprocessedResults
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteResultsResponse
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.repository.type.RepositoryResult
import com.diegopalvarez.oreplay.domain.repository.util.ScoreResultStats
import com.diegopalvarez.oreplay.domain.repository.util.calculateVisitedControls
import com.diegopalvarez.oreplay.domain.repository.util.handleNetworkError
import com.diegopalvarez.oreplay.domain.repository.util.wrapResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.collections.iterator

class ClubResultsRepository(
    val api: OReplayAPI
): KoinComponent {
    /**
     * Repository function to get the results of a CLUB for a given stage in an event
     * @param eventID UUID that uniquely identifies the event
     * @param stageID UUID that uniquely identifies the stage inside the event
     * @param clubID UUID that uniquely identifies the club for the stage and the event given
     * @param stageType Type of the stage that defines the treatment that the results should have
     */
    suspend fun getClubResults(
        eventID: String,
        stageID: String,
        clubID: String,
        stageType: StageType
    ): Result<RepositoryResult, RepositoryError> {
        val results = api.getStageResults(
            eventID = eventID,
            stageID = stageID,
            clubID = clubID
        )

        return when(results) {
            is Result.Success -> {
                val processed = processResultByType(
                    eventID = eventID,
                    stageID = stageID,
                    clubID = clubID,
                    results = results.data,
                    stageType = stageType)

                when(processed){
                    is Result.Success -> {
                        Result.Success(processed.data)
                    }
                    is Result.Error -> {
                        Result.Error(processed.error)
                    }
                }
            }
            is Result.Error -> {
                Result.Error(handleNetworkError(results.error))
            }
        }
    }

    /**
     * Private function to handle the result mapping in different ways depending on the stage type
     * @param results Results object from the API
     * @param stageType Type of the stage
     * @return RepositoryError if the query fails. In case of success, a list of Results
     */
    private suspend fun processResultByType(
        eventID: String,
        stageID: String,
        clubID: String,
        results: RemoteResultsResponse,
        stageType: StageType
    ): Result<RepositoryResult, RepositoryError> {
        return when(stageType) {
            StageType.CLASSIC -> {
                // A Classic stage has splits and rankings
                // Since the club results can't be compared directly to extract splits, the mapper must compare each class individually
                // TODO - Check if it's faster to calculate the splits as they're needed instead of all at first
                val unprocessed = getUnprocessedResults(results)

                // Calculate all the splits, and check if there's an error
                val processedResults = processTeamResults(
                    eventID = eventID,
                    stageID = stageID,
                    clubID = clubID,
                    results = unprocessed,
                    calculateRanks = true
                )

                when(processedResults){
                    is Result.Success -> {
                        Result.Success(wrapResult(processedResults.data, StageType.CLASSIC))
                    }
                    is Result.Error -> {
                        Result.Error(processedResults.error)
                    }
                }
            }

            StageType.OVERALL -> {
                // An Overall stage doesn't have splits, only overalls
                Result.Success(
                    wrapResult(
                        getUnprocessedResults(
                            remoteResultsResponse = results
                        ),
                        StageType.OVERALL
                    )
                )
            }

            StageType.RELAY -> {
                // A Relay stage is a team race with splits
                // The Relays don't need to compare because they don't have splits, so it can be mapped the same way as a class result
                Result.Success(
                    wrapResult(
                        getTeamResults(
                            remoteResultsResponse = results
                        ),
                        StageType.RELAY
                    )
                )
            }

            StageType.SCORE -> {
                // A Score stage only has points and its splits have no order. There must not be rankings
                // TODO - Develop a better way to calculate and return the list of all possible controls that can be visited during an SCORE race

                // Get the results for the score stage in the club
                val clubResults = getClassicResults(
                    remoteResultsResponse = results,
                    calculateRanks = false
                )

                // Calculate all visited results for all the different classes in the club
                val processedResults = processScoreTeamResults(
                    eventID = eventID,
                    stageID = stageID,
                    clubID = clubID,
                    results = clubResults
                )

                when(processedResults){
                    is Result.Success -> {
                        Result.Success(
                            wrapResult(
                                clubResults,
                                StageType.SCORE,
                                processedResults.data
                            )
                        )
                    }
                    is Result.Error -> {
                        Result.Error(processedResults.error)
                    }
                }
            }

            StageType.ONE_MAN_RELAY -> {
                // A One-Man Relay stage is like a Classic Stage, but since the runners might have different courses in the same class there are no rankings
                // The splits can ba calculated directly, and since there's no ranks there is no need to compare the whole class
                Result.Success(
                    wrapResult(
                        getClassicResults(
                            remoteResultsResponse = results,
                            calculateRanks = false
                        ),
                        StageType.ONE_MAN_RELAY
                    )
                )
            }

            else -> {
                // TODO - All other StageTypes aren't implemented yet
                Result.Error(RepositoryError.NOT_IMPLEMENTED)
            }
        }
    }

    suspend fun processTeamResults(
        eventID: String,
        stageID: String,
        clubID: String,
        results: List<ResultIndividual>,
        calculateRanks: Boolean
    ): Result<List<com.diegopalvarez.oreplay.domain.model.Result>, RepositoryError> = coroutineScope {
        // Group the results given by class, so that results from the same class and club can be calculated together
        val groupsByClass = results.filter {it.runnerClass != null}.groupBy { it.runnerClass!!.id }

        // Create and populate a list of club runners in parallel
        val deferredResults = groupsByClass.map { (classID, classGroupResults) ->

            // Launch the coroutine for this item
            async {
                // Get all results for the class
                val classResults = api.getStageResults(
                    eventID = eventID,
                    stageID = stageID,
                    classID = classID
                )

                when(classResults){
                    is Result.Success -> {
                        // Calculate the additional information for the whole class
                        val classicResults = getClassicResults(
                            remoteResultsResponse = classResults.data,
                            calculateRanks = calculateRanks
                        )

                        // Add only the information for the runners of the club
                        classicResults.filter { it.runnerClub != null }.filter { it.runnerClub!!.id == clubID }
                    }

                    is Result.Error -> {
                        // Add the error to the list
                        Result.Error(handleNetworkError(classResults.error))
                    }
                }
            }
        }

        // Wait for all the coroutines to finish
        val clubResults = deferredResults.awaitAll()

        // Return an error if any of the classes failed
        val firstError = clubResults.firstOrNull{ it is Result.Error<*> }

        if(firstError is Result.Error<*>){
            // Return the error
            return@coroutineScope Result.Error(firstError.error as RepositoryError)
        }

        val clubList = clubResults
            .filterIsInstance<List<com.diegopalvarez.oreplay.domain.model.Result>>()
            .flatten()

        // TODO - Sort the club results

        // Return the list
        return@coroutineScope Result.Success(clubList)
    }

    /**
     * Function to parse all the possible controls to visit in a score race by the members of a club
     * @param eventID ID of the event
     * @param stageID ID of the stage
     * @param clubID ID of the club
     * @param results List of results of the club
     * @returns Map that, for each classID, stores a map with the number of visitors per
     */
    suspend fun processScoreTeamResults(
        eventID: String,
        stageID: String,
        clubID: String,
        results: List<ResultIndividual>,
    ): Result<Map<String, ScoreResultStats>, RepositoryError> = coroutineScope {
        // Group the results given by class, so that results from the same class and club can be calculated together
        val groupsByClass = results.filter {it.runnerClass != null}.groupBy { it.runnerClass!!.id }

        // Create the map of Score Stats to store each class, in parallel
        val deferredResults = groupsByClass.map { (classID, classGroupResults) ->
            async {
                // Get all results for the class
                val classResults = api.getStageResults(
                    eventID = eventID,
                    stageID = stageID,
                    classID = classID
                )

                when(classResults){
                    is Result.Success -> {
                        // Calculate the additional information for the whole class
                        val classicResults = getClassicResults(
                            remoteResultsResponse = classResults.data,
                            calculateRanks = false
                        )

                        // Obtain the information about the control visits for this class and add it to the list
                        Pair(classID, calculateVisitedControls(classicResults))
                    }

                    is Result.Error -> {
                        // Add the error to the list
                        Result.Error(handleNetworkError(classResults.error))
                    }
                }
            }
        }

        // Wait for all the coroutines to finish
        val clubStats = deferredResults.awaitAll()

        // Return an error if any of the classes failed
        val firstError = clubStats.firstOrNull{ it is Result.Error<*> }

        if(firstError is Result.Error<*>){
            // Return the error
            return@coroutineScope Result.Error(firstError.error as RepositoryError)
        }

        val clubList = clubStats
            .filterIsInstance<Pair<String, ScoreResultStats>>()

        // Return the list
        return@coroutineScope Result.Success(clubList.toMap())
    }
}