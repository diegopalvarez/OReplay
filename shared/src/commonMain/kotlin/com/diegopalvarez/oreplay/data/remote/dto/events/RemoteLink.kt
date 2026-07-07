package com.diegopalvarez.oreplay.data.remote.dto.events

import kotlinx.serialization.Serializable

@Serializable
data class RemoteLink(
    val href: String,
)
