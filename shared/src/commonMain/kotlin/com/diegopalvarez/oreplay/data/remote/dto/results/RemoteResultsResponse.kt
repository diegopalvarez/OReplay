package com.diegopalvarez.oreplay.data.remote.dto.results

import kotlinx.serialization.Serializable

@Serializable
data class RemoteResultsResponse(
    val results: List<RemoteResult>
)
