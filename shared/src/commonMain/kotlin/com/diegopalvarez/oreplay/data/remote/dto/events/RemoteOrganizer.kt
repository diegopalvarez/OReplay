package com.diegopalvarez.oreplay.data.remote.dto.events

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteOrganizer(
    val id: String,
    val name: String,
    @SerialName("country_code")
    val countryCode: String,
    @SerialName("region_code")
    val regionCode: String? = null,
    val province: String? = null,
    val city: String? = null,
    val region: String? = null
)
