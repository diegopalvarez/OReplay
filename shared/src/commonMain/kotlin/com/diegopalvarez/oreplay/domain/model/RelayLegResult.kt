package com.diegopalvarez.oreplay.domain.model

import com.diegopalvarez.oreplay.domain.types.StatusCode

data class RelayLegResult(
    val result: ResultIndividual,
    val teamName: String,
    val teamError: StatusCode?,
    val accumulatedPosition: Long,
    val previousPosition: Long?
)