package com.diegopalvarez.oreplay.domain.repository

import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.data.remote.api.OReplayAPI
import com.diegopalvarez.oreplay.domain.types.StageType
import org.koin.core.component.KoinComponent
import com.diegopalvarez.oreplay.core.util.Result
import com.diegopalvarez.oreplay.data.mappers.remote.getClassicResults
import com.diegopalvarez.oreplay.data.mappers.remote.getTeamResults
import com.diegopalvarez.oreplay.data.mappers.remote.getUnprocessedResults
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteResultsResponse
import com.diegopalvarez.oreplay.domain.repository.util.handleNetworkError

class ClassResultsRepository(
    val api: OReplayAPI
): KoinComponent {
    /**
     * Repository function to get the results of a CLASS for a given stage in an event
     * @param eventID UUID that uniquely identifies the event
     * @param stageID UUID that uniquely identifies the stage inside the event
     * @param classID UUID that uniquely identifies the class for the stage and the event given
     * @param stageType Type of the stage that defines the treatment that the results should have
     */
    suspend fun getClassResults(
        eventID: String,
        stageID: String,
        classID: String,
        stageType: StageType
    ): Result<List<com.diegopalvarez.oreplay.domain.model.Result>, RepositoryError> {
        val results = api.getStageResults(
            eventID = eventID,
            stageID = stageID,
            classID = classID
        )

        return when(results) {
            is Result.Success -> {
                val processed = processResultByType(results.data, stageType)

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
    private fun processResultByType(
        results: RemoteResultsResponse,
        stageType: StageType
    ): Result<List<com.diegopalvarez.oreplay.domain.model.Result>, RepositoryError> {
        return when(stageType) {
            StageType.CLASSIC -> {
                // A Classic stage has splits and rankings
                Result.Success(
                    getClassicResults(
                        remoteResultsResponse = results,
                        calculateRanks = true
                    )
                )
            }

            StageType.OVERALL -> {
                // An Overall stage doesn't have splits, only overalls
                Result.Success(
                    getUnprocessedResults(
                        remoteResultsResponse = results
                    )
                )
            }

            StageType.RELAY -> {
                // A Relay stage is a team race with splits
                Result.Success(
                    getTeamResults(
                        remoteResultsResponse = results
                    )
                )
            }

            StageType.SCORE -> {
                // A Score stage only has points and its splits have no order. There must not be rankings
                // TODO - Develop a better way to calculate and return the list of all possible controls that can be visited during an SCORE race
                Result.Success(
                    getClassicResults(
                        remoteResultsResponse = results,
                        calculateRanks = false
                    )
                )
            }

            StageType.ONE_MAN_RELAY -> {
                // A One-Man Relay stage is like a Classic Stage, but since the runners might have different courses in the same class there are no rankings
                Result.Success(
                    getClassicResults(
                        remoteResultsResponse = results,
                        calculateRanks = false
                    )
                )
            }

            else -> {
                // TODO - All other StageTypes aren't implemented yet
                Result.Error(RepositoryError.NOT_IMPLEMENTED)
            }
        }
    }
}