package com.diegopalvarez.oreplay.domain.model

import com.diegopalvarez.oreplay.domain.types.StatusCode
import kotlin.time.Duration

data class RelayLegResult(
    val result: ResultIndividual,
    val teamName: String,
    val teamNC: Boolean,
    val teamError: StatusCode,
    val accumulatedPosition: Long,
    val previousPosition: Long?,
    val teamTime: Duration,
    val teamTimeBehind: Duration
)