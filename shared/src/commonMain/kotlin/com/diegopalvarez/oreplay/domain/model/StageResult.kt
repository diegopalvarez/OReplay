package com.diegopalvarez.oreplay.domain.model

import kotlinx.datetime.LocalDateTime

data class StageResult(
    val id: String,
    val resultType: String,
    val startTime: LocalDateTime,
    val finishTime: LocalDateTime?,
    val uploadType: String,
    val timeSeconds: Long,
    val position: Long,
    val statusCode: String,
    val isNC: Boolean,
    val contributory: Boolean,

    val timeBehind: Long,
    val timeNeutralization: Long,
    val timePenalty: Long,
    val timeBonus: Long,

    val pointsTotal: Long,
    val pointsBehind: Long,
    val pointsAdjusted : Long,
    val pointsPenalty: Long,
    val pointsBonus: Long,

    val nota: String? = null,
    val legNumber: Long,
    val created: LocalDateTime,
    val splits: List<Result>,

    )
