package com.diegopalvarez.oreplay.data.remote.dto.events

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteEventResponse(
    val data: List<RemoteEvent>,
    val total: Long,
    val limit: Long,
    @SerialName("_links")
    val links: RemoteEventListLinks
)