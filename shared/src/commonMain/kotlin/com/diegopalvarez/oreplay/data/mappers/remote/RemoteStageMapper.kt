package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.mappers.util.getInstant
import com.diegopalvarez.oreplay.data.remote.dto.stages.RemoteEventDetailsResponse
import com.diegopalvarez.oreplay.data.remote.dto.stages.RemoteStage
import com.diegopalvarez.oreplay.domain.model.Stage

private fun getStage(remoteStage: RemoteStage): Stage {
    return Stage(
        id = remoteStage.id,
        description = remoteStage.description,
        start = if(remoteStage.start != null){
                    getInstant(remoteStage.start)
                }
                else{
                    null
                },
        stageType = remoteStage.stageType.id,      // Only the ID is needed, not the description since it's static
        state = getStageState(remoteStage.lastLogs),
        // The classes and clubs are missing but must be added when parsed
        )
}

/**
 * Function to parse the response from getting the stages from an event
 * @param remoteEventDetailsResponse Response gotten from the API
 * @return List just including the stages from the event, without the event information already parsed
 */
fun getStages(remoteEventDetailsResponse: RemoteEventDetailsResponse): List<Stage> {
    val remoteStages = remoteEventDetailsResponse.details.stages
    return remoteStages.map(::getStage)
}