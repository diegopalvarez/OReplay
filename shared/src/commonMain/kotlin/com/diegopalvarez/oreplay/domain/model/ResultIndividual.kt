package com.diegopalvarez.oreplay.domain.model

import kotlinx.datetime.LocalDateTime
import kotlin.time.Instant

data class ResultIndividual(
    val id: String,
    val bibNumber: String?,
    val isNc: Boolean,
    val eligibility: Boolean?,
    val siCard: String,
    val sex: String?,
    val legNumber: Long,
    val created: Instant,
    val runnerClass: ResultClass?,
    val runnerClub: StageClub?,
    val fullName: String,
    val stageResult: StageResult?,
    val overallResult: Overall?
): Result
