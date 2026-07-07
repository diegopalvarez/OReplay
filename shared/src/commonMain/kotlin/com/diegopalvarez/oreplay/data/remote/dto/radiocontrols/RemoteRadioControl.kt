package com.diegopalvarez.oreplay.data.remote.dto.radiocontrols

import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteControl
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteRadioControl(
    // TODO - Check real case of radio controls in use

    // Same as the regular split
    val id: String,

    @SerialName("is_intermediate")
    val isIntermediate: Boolean,

    @SerialName("reading_time")
    val readingTime: String? = null,

    val points: Long,

    @SerialName("order_number")
    val orderNumber: Long,

    val created: String,
    val control: RemoteControl
)
