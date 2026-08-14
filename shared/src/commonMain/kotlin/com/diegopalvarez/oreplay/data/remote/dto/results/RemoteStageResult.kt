package com.diegopalvarez.oreplay.data.remote.dto.results

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteStageResult(
    // TODO - Check entry_list upload type
    val id: String? = null,

    @SerialName("result_type_id")
    val resultTypeID: String,

    @SerialName("start_time")
    val startTime: String? = null,

    @SerialName("finish_time")
    val finishTime: String? = null,             // TODO - Check if it can be null

    @SerialName("upload_type")
    val uploadType: String,             // If upload type is entry_list, there can be no id, start_time, finish_time, time and points parameters, leg_number and created

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
    val timeNeutralization: Long ? = null,

    @SerialName("time_adjusted")
    val timeAdjusted: Long ? = null,

    @SerialName("time_penalty")
    val timePenalty: Long ? = null,

    @SerialName("time_bonus")
    val timeBonus: Long ? = null,

    @SerialName("points_final")
    val pointsFinal: String ? = null,

    @SerialName("points_behind")
    val pointsBehind: String ? = null,          // TODO - Why aren't these returned in the overall team result?

    @SerialName("points_adjusted")
    val pointsAdjusted: String ? = null,

    @SerialName("points_penalty")
    val pointsPenalty: String ? = null,

    @SerialName("points_bonus")
    val pointsBonus: String ? = null,

    val note: String? = null,       // TODO - Never specified, must check later

    @SerialName("leg_number")
    val legNumber: Long ? = null,

    val created: String ? = null,
    val splits: List<RemoteSplit>
)
