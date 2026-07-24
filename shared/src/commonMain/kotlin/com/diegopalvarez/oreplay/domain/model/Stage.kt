package com.diegopalvarez.oreplay.domain.model

import kotlinx.datetime.LocalDateTime
import kotlin.time.Instant


data class Stage(
    val id: String,
    val description: String,
    val start: Instant?,
    val stageType: String,
    val state: Long?,
    val classes: List<StageClass>? = null,
    val clubs: List<StageClub>? = null,

) {
}
