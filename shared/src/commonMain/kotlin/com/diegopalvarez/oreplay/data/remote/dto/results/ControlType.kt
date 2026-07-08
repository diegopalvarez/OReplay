package com.diegopalvarez.oreplay.data.remote.dto.results

import kotlinx.serialization.Serializable

@Serializable
data class ControlType(
    val id: String,
    val description: String
)
