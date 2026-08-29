package com.diegopalvarez.oreplay.domain.model

import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.domain.types.UploadType
import kotlin.time.Duration

data class OverallResult(
    val id: String,
    val stageOrder: Long,
    val uploadType: UploadType,
    val stage: OverallStage?,
    val position: Long,
    val statusCode: StatusCode,
    val isNc: Boolean?,
    val contributory: Boolean?,
    val timeSeconds: Duration,
    val timeBehind: Duration?,
    val pointsFinal: Double,
    val pointsBehind: Double?,
    val note: String?,
)
