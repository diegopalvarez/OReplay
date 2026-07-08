package com.diegopalvarez.oreplay.domain.model

import kotlin.time.Duration

data class OverallResult(
    val id: String,
    val stageOrder: Long,
    val uploadType: String,
    val stage: String,
    val position: Long,
    val statusCode: String,
    val isNc: Boolean,
    val contributory: Boolean,
    val timeSeconds: Duration,
    val timeBehind: Duration,
    val pointsFinal: Long,
    val pointsBehind: Long,
    val note: String,
)
