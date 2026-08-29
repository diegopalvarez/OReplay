package com.diegopalvarez.oreplay.data.remote.dto.results

import com.diegopalvarez.oreplay.data.remote.dto.stages.RemoteStage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteOverall(
    val id: String,

    @SerialName("stage_order")
    val stageOrder: Long,                   // Numbered from 1 to N for parts, and 0 in case of an overall result.

    @SerialName("upload_type")
    val uploadType: String,

    val stage: RemoteStageOveralls? = null,         // If it corresponds to a Stage it takes a non-null value. If it corresponds to an overall result, it might be bull
    val position: Long,

    @SerialName("status_code")
    val statusCode: String,

    @SerialName("is_nc")
    val isNc: Boolean? = null,

    val contributory: Boolean? = null,      // True if it's taken into account, false if dropped. Null if it corresponds to an overall result.

    @SerialName("time_seconds")
    val timeSeconds: Long,

    @SerialName("time_behind")
    val timeBehind: Long? = null,

    @SerialName("points_final")
    val pointsFinal: Double,

    @SerialName("points_behind")
    val pointsBehind: Double? = null,

    val note: String? = null
)
