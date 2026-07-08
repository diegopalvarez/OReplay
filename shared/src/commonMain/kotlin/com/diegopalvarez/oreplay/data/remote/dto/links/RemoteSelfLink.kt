package com.diegopalvarez.oreplay.data.remote.dto.links

import kotlinx.serialization.Serializable

@Serializable
data class RemoteSelfLink(
    val self: RemoteLink
)
