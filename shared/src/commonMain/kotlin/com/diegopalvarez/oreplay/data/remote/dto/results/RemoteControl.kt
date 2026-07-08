package com.diegopalvarez.oreplay.data.remote.dto.results

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteControl(
    val id: String,
    val station: String,

    @SerialName("control_type")
    val controlType: ControlType
)
