package com.diegopalvarez.oreplay.data.remote.dto.links

import kotlinx.serialization.Serializable

@Serializable
data class RemotePageListLinks (
    val self: RemoteLink,
    val next: RemoteLink? = null,
    val previous: RemoteLink? = null,
)