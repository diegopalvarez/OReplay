package com.diegopalvarez.oreplay.data.remote.dto.results

import kotlinx.serialization.Serializable

@Serializable
data class RemoteStageOveralls(
    val id: String,
    val description: String,
)