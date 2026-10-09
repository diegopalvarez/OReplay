package com.diegopalvarez.oreplay.data.remote.dto.liveResults

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteLiveResultsResponse(
    @SerialName("data")
    val results: List<RemoteLiveResult>
)
