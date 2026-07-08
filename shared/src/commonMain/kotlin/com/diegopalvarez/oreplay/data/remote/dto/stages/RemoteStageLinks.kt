package com.diegopalvarez.oreplay.data.remote.dto.stages

import com.diegopalvarez.oreplay.data.remote.dto.links.RemoteLink
import kotlinx.serialization.Serializable

@Serializable
data class RemoteStageLinks(
    val self: RemoteLink,
    val results: RemoteLink,
    val classes: RemoteLink,
)
