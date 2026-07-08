package com.diegopalvarez.oreplay.data.remote.dto.results

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteSplit(
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
