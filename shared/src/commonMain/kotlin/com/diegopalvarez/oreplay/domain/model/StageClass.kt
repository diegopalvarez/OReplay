package com.diegopalvarez.oreplay.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class StageClass(
    val id: String,
    val shortName: String,
    val longName: String,
    val radioControls: List<SplitRadio>
)
