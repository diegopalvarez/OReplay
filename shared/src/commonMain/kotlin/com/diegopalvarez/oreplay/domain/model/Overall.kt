package com.diegopalvarez.oreplay.domain.model

data class Overall(
    val overallParts: List<OverallResult>,
    val overallTotal: OverallResult,
)
