package com.diegopalvarez.oreplay.domain.repository

import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.core.util.Result
import com.diegopalvarez.oreplay.data.mappers.remote.getClasses
import com.diegopalvarez.oreplay.data.mappers.remote.getClubs
import com.diegopalvarez.oreplay.data.mappers.remote.getStages
import com.diegopalvarez.oreplay.data.remote.api.OReplayAPI
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.domain.repository.util.handleNetworkError
import org.koin.core.component.KoinComponent

class StageRepository(
    val api: OReplayAPI
): KoinComponent {

    /**
     * Repository function to get a list of stages for a given event
     * @param eventID UUID that uniquely identifies the event
     * @return RepositoryError if the query fails. In case of success, a list of Stages
     */
    suspend fun getEventStages(eventID: String): Result<List<Stage>, RepositoryError> {
        val eventDetails = api.getEventStages(eventID)

        return when(eventDetails) {
            is Result.Success -> {
                Result.Success(getStages(eventDetails.data))
            }
            is Result.Error -> {
                // TODO - Implement cache as fallback
                Result.Error(handleNetworkError(eventDetails.error))
            }
        }
    }

    /**
     * Repository function to get a list of classes for a given stage of an event
     * @param eventID UUID that uniquely identifies the event
     * @param stageID UUID that uniquely identifies the stage INSIDE THE EVENT
     * @return RepositoryError if the query fails. In case of success, a list of Classes for the stage
     */
    suspend fun getStageClasses(eventID: String, stageID: String): Result<List<StageClass>, RepositoryError> {
        val eventClasses = api.getStageClasses(eventID, stageID)

        return when(eventClasses) {
            is Result.Success -> {
                Result.Success(getClasses(eventClasses.data))
            }
            is Result.Error -> {
                // TODO - Implement cache as fallback
                Result.Error(handleNetworkError(eventClasses.error))
            }
        }
    }

    /**
     * Repository function to get a list of clubs for a given stage of an event
     * @param eventID UUID that uniquely identifies the event
     * @param stageID UUID that uniquely identifies the stage INSIDE THE EVENT
     * @return RepositoryError if the query fails. In case of success, a list of Clubs for the stage
     */
    suspend fun getStageClubs(eventID: String, stageID: String): Result<List<StageClub>, RepositoryError>{
        val eventClubs = api.getStageClubs(eventID, stageID)

        return when(eventClubs) {
            is Result.Success -> {
                Result.Success(getClubs(eventClubs.data))
            }
            is Result.Error -> {
                // TODO - Implement cache as fallback
                Result.Error(handleNetworkError(eventClubs.error))
            }
        }
    }

}