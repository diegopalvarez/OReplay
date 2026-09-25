package com.diegopalvarez.oreplay.domain.model

import kotlinx.datetime.LocalDateTime
import kotlin.time.Instant

data class ResultIndividual(
    override val id: String,
    override val bibNumber: String?,
    override val isNc: Boolean,
    override val eligibility: Boolean?,
    override val fullName: String,
    override val stageResult: StageResult?,
    override val overallResult: Overall?,

    // Individual-specific information
    val siCard: String,
    val sex: String?,
    val legNumber: Long,
    val created: Instant,
    val runnerClass: ResultClass?,
    val runnerClub: StageClub?,
): Result
