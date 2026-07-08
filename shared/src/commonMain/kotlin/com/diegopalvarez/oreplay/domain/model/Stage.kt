package com.diegopalvarez.oreplay.domain.model

import kotlinx.datetime.LocalDateTime


data class Stage(
    val id: String,
    val description: String,
    val start: LocalDateTime,
    val stageType: String,
    val state: String,
    val classes: List<StageClass>,
    val clubs: List<StageClub>

) {
}
