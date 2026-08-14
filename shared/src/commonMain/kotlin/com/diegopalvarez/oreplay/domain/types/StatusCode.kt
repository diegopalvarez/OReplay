package com.diegopalvarez.oreplay.domain.types

enum class StatusCode(val code: String, val displayName: String) {
    OK("0", "OK"),
    DID_NOT_START("1", "DNS"),
    DID_NOT_FINISH("2", "DNF"),
    MISSING_PUNCH("3", "MP"),
    DISQUALIFIED("4", "DSQ"),
    OVERTIME("5", "OT")
}

fun String.getStatusCode(): StatusCode {
    return when(this){
        StatusCode.OK.code -> StatusCode.OK
        StatusCode.DID_NOT_START.code -> StatusCode.DID_NOT_START
        StatusCode.DID_NOT_FINISH.code -> StatusCode.DID_NOT_FINISH
        StatusCode.MISSING_PUNCH.code -> StatusCode.MISSING_PUNCH
        StatusCode.DISQUALIFIED.code -> StatusCode.DISQUALIFIED
        StatusCode.OVERTIME.code -> StatusCode.OVERTIME
        else -> throw IllegalArgumentException("Unknown status code: $this")
    }
}