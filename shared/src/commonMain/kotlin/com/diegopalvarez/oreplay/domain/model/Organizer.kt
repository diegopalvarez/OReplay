package com.diegopalvarez.oreplay.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Organizer(
    val id: String,
    val name: String,
    val countryCode: String,
    val regionCode: String,
    val province: String?,
    val city: String?,
    val region: String?,
)
