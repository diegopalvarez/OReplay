package com.diegopalvarez.oreplay.domain.model

data class StageClass(
    val id: String,
    val shortName: String,
    val longName: String,
    val radioControls: List<SplitRadio>
)
