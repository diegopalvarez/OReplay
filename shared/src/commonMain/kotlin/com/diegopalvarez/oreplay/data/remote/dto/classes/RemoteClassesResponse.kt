package com.diegopalvarez.oreplay.data.remote.dto.classes

import kotlinx.serialization.Serializable

@Serializable
data class RemoteClassesResponse(
    val classes: List<RemoteClass>
)
