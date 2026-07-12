package com.diegopalvarez.oreplay.data.remote.dto.results

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteResultsResponse(
    @SerialName("data")
    val results: List<RemoteResult>
)
