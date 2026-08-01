package com.diegopalvarez.oreplay.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Organizer(
    val id: String,
    val name: String,
    val country: String,
    val region: String?,
)
