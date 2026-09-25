package com.diegopalvarez.oreplay.domain.model

import kotlin.time.Duration

data class ResultTeamRunner(
    // Individual Runner Result
    val result: ResultIndividual,

    // Additional team information
    var isAccumulatedError: Boolean = false,
    var teamPositions: Long = 0L,
    var teamAccumulatedTime: Duration = Duration.INFINITE,
    var teamTimeBehind: Duration = Duration.INFINITE,            // Accumulated time behind. The individual time behind is stored in the runner's individualResult
)
