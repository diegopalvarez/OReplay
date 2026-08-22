package com.diegopalvarez.oreplay.domain.model

import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.domain.types.UploadType
import kotlin.time.Duration
import kotlin.time.Instant

data class StageResult(
    val id: String?,
    val resultType: String,
    val startTime: Instant?,
    val finishTime: Instant?,
    val uploadType: UploadType,
    val timeSeconds: Duration,
    val position: Long,
    val statusCode: StatusCode,
    val isNC: Boolean,
    val contributory: Boolean?,

    var timeBehind: Duration,
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
