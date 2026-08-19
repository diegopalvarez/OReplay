package com.diegopalvarez.oreplay.domain.types

import oreplay.shared.generated.resources.DNF
import oreplay.shared.generated.resources.DNS
import oreplay.shared.generated.resources.DSQ
import oreplay.shared.generated.resources.MP
import oreplay.shared.generated.resources.OK
import oreplay.shared.generated.resources.OT
import oreplay.shared.generated.resources.Res
import org.jetbrains.compose.resources.StringResource

enum class StatusCode(val code: String, val displayName: StringResource) {
    OK("0", Res.string.OK),
    DID_NOT_START("1", Res.string.DNS),
    DID_NOT_FINISH("2", Res.string.DNF),
    MISSING_PUNCH("3", Res.string.MP),
    DISQUALIFIED("4", Res.string.DSQ),
    OVERTIME("5", Res.string.OT)
}

// TODO - Decide how to handle legacy STATUS CODE 9 -> NC
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