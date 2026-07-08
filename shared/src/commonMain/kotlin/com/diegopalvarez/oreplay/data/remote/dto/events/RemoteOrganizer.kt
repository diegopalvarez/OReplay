package com.diegopalvarez.oreplay.data.remote.dto.events

import kotlinx.serialization.Serializable

@Serializable
data class RemoteOrganizer(
    val id: String,
    val name: String,
    val country: String,
    val region: String? = null
)
