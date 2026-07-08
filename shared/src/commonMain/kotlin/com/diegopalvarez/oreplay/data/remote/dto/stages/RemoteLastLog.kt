package com.diegopalvarez.oreplay.data.remote.dto.stages

import kotlinx.serialization.Serializable

@Serializable
data class RemoteLastLog(
    val state: Long,
    val created: Long,
)
