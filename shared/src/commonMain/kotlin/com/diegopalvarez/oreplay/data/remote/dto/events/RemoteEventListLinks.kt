package com.diegopalvarez.oreplay.data.remote.dto.events

import kotlinx.serialization.Serializable

@Serializable
data class RemoteEventListLinks (
    val self: RemoteLink,
    val next: RemoteLink? = null,
    val previous: RemoteLink? = null,
)