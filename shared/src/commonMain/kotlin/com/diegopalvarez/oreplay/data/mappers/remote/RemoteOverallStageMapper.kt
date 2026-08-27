package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteStageOveralls
import com.diegopalvarez.oreplay.domain.model.OverallStage

fun getOverallStage(remoteStage: RemoteStageOveralls?): OverallStage? {
    return if(remoteStage != null) {
        OverallStage(
            id = remoteStage.id,
            description = remoteStage.description,
        )
    }
    else{
        null
    }

}