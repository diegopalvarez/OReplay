package com.diegopalvarez.oreplay.data.remote.dto.classes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteClassesResponse(
    @SerialName("data")
    val classes: List<RemoteClass>
)
