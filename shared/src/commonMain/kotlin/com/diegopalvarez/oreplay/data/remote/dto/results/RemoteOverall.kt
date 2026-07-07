package com.diegopalvarez.oreplay.data.remote.dto.results

import com.diegopalvarez.oreplay.data.remote.dto.stages.RemoteStage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteOverall(
    val id: String,

    @SerialName("stage_order")
    val stageOrder: Long,

    @SerialName("upload_type")
    val uploadType: String,

    val stage: RemoteStage? = null,         // If it corresponds to a Stage it takes a non-null value. If it corresponds to an overall result, it might be bull
    val position: Long,

    @SerialName("status_code")
    val statusCode: String,

    @SerialName("is_nc")
    val isNc: Boolean? = null,

    val contributory: Boolean? = null,

    @SerialName("time_seconds")
    val timeSeconds: Long,

    @SerialName("time_behind")
    val timeBehind: Long? = null,

    @SerialName("points_final")
    val pointsFinal: Long,

    @SerialName("points_behind")
    val pointsBehind: Long? = null,

    val note: String? = null
)
