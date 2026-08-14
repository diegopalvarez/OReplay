package com.diegopalvarez.oreplay.domain.model

import kotlinx.datetime.LocalDateTime
import kotlin.time.Duration
import kotlin.time.Instant

data class StageResult(
    val id: String?,
    val resultType: String,
    val startTime: Instant?,
    val finishTime: Instant?,
    val uploadType: String,
    val timeSeconds: Duration,
    val position: Long,
    val statusCode: String,
    val isNC: Boolean,
    val contributory: Boolean?,

    val timeBehind: Duration,
    val timeNeutralization: Duration?,
    val timeAdjusted: Duration?,
    val timePenalty: Duration?,
    val timeBonus: Duration?,

    val pointsTotal: String?,
    val pointsBehind: String?,
    val pointsAdjusted : String?,
    val pointsPenalty: String?,
    val pointsBonus: String?,

    val note: String? = null,
    val legNumber: Long?,
    val created: Instant?,
    val splits: List<SplitIndividual>       // This list will be always empty in a Team Result, but not in the individual part of a team result
    )
