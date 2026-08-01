package com.diegopalvarez.oreplay.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class StageClub(
    val id: String,
    val shortName: String,
)
