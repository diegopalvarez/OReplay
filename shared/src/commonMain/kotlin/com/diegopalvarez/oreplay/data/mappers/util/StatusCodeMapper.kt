package com.diegopalvarez.oreplay.data.mappers.util

import com.diegopalvarez.oreplay.domain.types.StatusCode

// TODO - Decide how to handle legacy STATUS CODE 9 -> NC
fun getStatusCode(statusCode: String): StatusCode {
    return when(statusCode){
        StatusCode.OK.code -> StatusCode.OK
        StatusCode.DID_NOT_START.code -> StatusCode.DID_NOT_START
        StatusCode.DID_NOT_FINISH.code -> StatusCode.DID_NOT_FINISH
        StatusCode.MISSING_PUNCH.code -> StatusCode.MISSING_PUNCH
        StatusCode.DISQUALIFIED.code -> StatusCode.DISQUALIFIED
        StatusCode.OVERTIME.code -> StatusCode.OVERTIME
        else -> throw IllegalArgumentException("Unknown status code: $statusCode")
    }
}