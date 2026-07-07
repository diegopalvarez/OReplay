package com.diegopalvarez.oreplay.data.remote.dto.clubs

import kotlinx.serialization.Serializable

@Serializable
data class RemoteClubsResponse(
    val classes: List<RemoteClub>
)
