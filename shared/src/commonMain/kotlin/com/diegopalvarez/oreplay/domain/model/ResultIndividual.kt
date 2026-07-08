package com.diegopalvarez.oreplay.domain.model

import kotlinx.datetime.LocalDateTime

data class ResultIndividual(
    val id: String,
    val bibNumber: String,
    val isNc: Boolean,
    val eligibility: Boolean?,
    val siCard: String,
    val sex: String,
    val legNumber: Long,
    val created: LocalDateTime,
    val fullName: String,
    val stageResult: StageResult,
    val overallResult: Overall
): Result
