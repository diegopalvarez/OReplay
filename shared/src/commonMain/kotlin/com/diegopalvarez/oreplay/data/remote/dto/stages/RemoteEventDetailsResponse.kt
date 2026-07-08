package com.diegopalvarez.oreplay.data.remote.dto.stages

import kotlinx.serialization.Serializable

@Serializable
data class RemoteEventDetailsResponse(
    val details: RemoteEventDetails,
)
