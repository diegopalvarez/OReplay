package com.diegopalvarez.oreplay.domain.model

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
    val runners: List<ResultTeamRunner>,
    val teamClass: ResultClass?,
    val teamClub: StageClub?,

    // Final team result information
    override val stageResult: StageResult?,
    override val overallResult: Overall?
): Result
