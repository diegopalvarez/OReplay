package com.diegopalvarez.oreplay.data.remote.dto.events

import kotlinx.serialization.Serializable

@Serializable
data class RemoteEventLink(
    val self: RemoteLink
)
