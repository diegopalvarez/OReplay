package com.diegopalvarez.oreplay.data.remote.dto.stages

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteEventDetailsResponse(
    @SerialName("data")
    val details: RemoteEventDetails,
)
