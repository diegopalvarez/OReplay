package com.diegopalvarez.oreplay.data.remote.dto.results

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteStageResult(
    val id: String,

    @SerialName("result_type_id")
    val resultTypeID: String,

    @SerialName("start_time")
    val startTime: String,

    @SerialName("finish_time")
    val finishTime: String,             // TODO - Check if it can be null

    @SerialName("upload_type")
    val uploadType: String,

    @SerialName("time_seconds")
    val timeSeconds: Long,

    val position: Long,

    @SerialName("status_code")
    val statusCode: String,

    @SerialName("is_nc")
    val isNc: Boolean,

    val contributory: Boolean ? = null,

    @SerialName("time_behind")
    val timeBehind: Long,

    @SerialName("time_neutralization")
    val timeNeutralization: Long,

    @SerialName("time_adjusted")
    val timeAdjusted: Long,

    @SerialName("time_penalty")
    val timePenalty: Long,

    @SerialName("time_bonus")
    val timeBonus: Long,

    @SerialName("points_final")
    val pointsFinal: String,

    @SerialName("points_behind")
    val pointsBehind: String ? = null,          // TODO - Why aren't these returned in the overall team result?

    @SerialName("points_adjusted")
    val pointsAdjusted: String,

    @SerialName("points_penalty")
    val pointsPenalty: String,

    @SerialName("points_bonus")
    val pointsBonus: String,

    val note: String? = null,       // TODO - Never specified, must check later

    @SerialName("leg_number")
    val legNumber: Long,

    val created: String,
    val splits: List<RemoteSplit>
)
