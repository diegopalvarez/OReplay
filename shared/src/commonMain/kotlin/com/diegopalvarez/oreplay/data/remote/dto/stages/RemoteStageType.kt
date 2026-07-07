package com.diegopalvarez.oreplay.data.remote.dto.stages

import kotlinx.serialization.Serializable

@Serializable
data class RemoteStageType(
    val id: String,
    val description: String
)
