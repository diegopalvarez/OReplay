package com.diegopalvarez.oreplay.domain.model

import kotlinx.datetime.LocalDateTime
import kotlin.time.Instant

data class ResultTeam(
    val id: String,
    val bibNumber: String?,
    val isNc: Boolean,
    val eligibility: Boolean?,
    val legs: Long?,
    val created: Instant,
    val runners: List<ResultIndividual>,
    val teamClass: ResultClass?,
    val teamClub: StageClub?,
    val fullName: String,

    // Final team result information
    val stageResult: StageResult?,
    val overallResult: Overall?
): Result
