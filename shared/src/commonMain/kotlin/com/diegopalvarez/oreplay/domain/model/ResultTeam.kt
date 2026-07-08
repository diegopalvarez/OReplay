package com.diegopalvarez.oreplay.domain.model

import kotlinx.datetime.LocalDateTime

data class ResultTeam(
    val id: String,
    val bibNumber: String,
    val isNc: Boolean,
    val eligibility: Boolean?,
    val legs: Int?,
    val created: LocalDateTime,
    val runners: List<ResultIndividual>,
    val teamClass: StageClass,
    val teamClub: StageClub,
    val fullName: String,

    // Final team result information
    val stageResult: StageResult,
    val overallResult: Overall
): Result
