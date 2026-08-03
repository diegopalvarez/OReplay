package com.diegopalvarez.oreplay.domain.model

import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class Event(
    val id: String,
    val isHidden: Boolean,
    val description: String,
    val picture: String?,
    val website: String?,
    val scope: String,
    val location: String?,
    val countryCode: String?,
    val initialDate: LocalDate,
    val finalDate: LocalDate,
    @Serializable(with = com.diegopalvarez.oreplay.domain.serializer.TimeZoneSerializer::class)
    val timezone: TimeZone,
    val federation: String?,
    val created: Instant,       // A specific moment from the past should be represented as an Instant
    val modified: Instant,
    val organizer: Organizer,
    val selfLink: String,

    // Stages
    val stages: List<Stage>? = null
)
