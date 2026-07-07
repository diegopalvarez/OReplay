package com.diegopalvarez.oreplay.data.remote.dto.stages

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteStage(
    val id: String,
    val description: String,
    val start: String? = null,

    @SerialName("stage_type")
    val stageType: RemoteStageType,

    @SerialName("last_logs")
    val lastLogs: List<RemoteLastLog>,

    @SerialName("_links")
    val links: RemoteStageLinks
)
