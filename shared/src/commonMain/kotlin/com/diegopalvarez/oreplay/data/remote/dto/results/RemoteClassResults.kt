package com.diegopalvarez.oreplay.data.remote.dto.results

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteClassResults(
    val id: String,

    @SerialName("short_name")
    val shortName: String,

    @SerialName("long_name")
    val longName: String

    // In results, there's no information about radios
)