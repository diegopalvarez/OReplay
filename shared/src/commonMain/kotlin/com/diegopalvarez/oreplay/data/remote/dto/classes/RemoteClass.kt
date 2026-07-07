package com.diegopalvarez.oreplay.data.remote.dto.classes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteClass(
    val id: String,

    @SerialName("short_name")
    val shortName: String,

    @SerialName("long_name")
    val longName: String,

    val radios: List<RemoteRadioControl>,       // TODO - Verify Radio Controls
)
