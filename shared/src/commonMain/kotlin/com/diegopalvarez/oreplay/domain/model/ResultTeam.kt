package com.diegopalvarez.oreplay.domain.model

import com.diegopalvarez.oreplay.domain.types.StatusCode
import kotlinx.datetime.LocalDateTime
import kotlin.time.Duration
import kotlin.time.Instant

data class ResultTeam(
    override val id: String,
    override val bibNumber: String?,
    override val isNc: Boolean,
    override val eligibility: Boolean?,
    override val fullName: String,

    // Team-specific information
    val legs: Long?,
    val created: Instant,
    val runners: List<ResultIndividual>,
    val teamClass: ResultClass?,
    val teamClub: StageClub?,

    // Final team result information
    override val stageResult: StageResult?,
    override val overallResult: Overall?,

    // Additional information for the team result
    val isAccumulatedError: MutableList<Boolean> = mutableListOf(),
    val teamPositions: MutableList<Long> = mutableListOf(),
    val teamAccumulatedTime: MutableList<Duration> = mutableListOf(),
    val teamTimeBehind: MutableList<Duration> = mutableListOf(),            // Accumulated time behind. The individual time behind is stored in the runner's individualResult
): Result
