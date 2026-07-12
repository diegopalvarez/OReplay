package com.diegopalvarez.oreplay.data.remote.dto.clubs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteClubsResponse(
    @SerialName("data")
    val clubs: List<RemoteClub>
)
