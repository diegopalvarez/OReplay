package com.diegopalvarez.oreplay.domain.model

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone

data class Event(
    val id: String,
    val isHidden: Boolean,
    val picture: String,
    val website: String,
    val scope: String,
    val location: String,
    val countryCode: String,
    val initialDate: LocalDate,
    val finalDate: LocalDate,
    val timezone: TimeZone,
    val federation: String,
    val created: LocalDateTime,
    val modified: LocalDateTime,
    val organizer: Organizer,
    val selfLink: String,

    // Stages
    val stages: List<Stage>
)
