package com.diegopalvarez.oreplay.data.remote.dto.clubs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteClub(
    val id: String,

    @SerialName("short_name")
    val shortName: String,
)
