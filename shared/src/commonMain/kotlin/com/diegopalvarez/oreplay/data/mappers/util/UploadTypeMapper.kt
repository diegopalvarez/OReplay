package com.diegopalvarez.oreplay.data.mappers.util

import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.domain.types.UploadType

// TODO - Decide how to handle legacy STATUS CODE 9 -> NC
fun getUploadType(uploadType: String): UploadType {
    return when(uploadType){
        UploadType.COMPUTABLE_ORG.type -> UploadType.COMPUTABLE_ORG
        UploadType.ENTRY_LIST.type -> UploadType.ENTRY_LIST
        UploadType.FINAL_RESULT.type -> UploadType.FINAL_RESULT
        UploadType.ONLINE_SPLITS.type -> UploadType.ONLINE_SPLITS
        UploadType.RANKING_COMPUTED.type -> UploadType.RANKING_COMPUTED
        UploadType.SPLIT_RESULT.type -> UploadType.SPLIT_RESULT
        UploadType.START_TIMES.type -> UploadType.START_TIMES
        UploadType.TOTAL_POINTS.type -> UploadType.TOTAL_POINTS
        UploadType.TOTAL_TIMES.type -> UploadType.TOTAL_TIMES
        else -> throw IllegalArgumentException("Unknown upload type: $uploadType")
    }
}