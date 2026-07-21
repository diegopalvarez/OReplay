package com.diegopalvarez.oreplay.data.mappers.util

import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.Instant
import kotlin.time.toDuration

fun getLocalDate(date: String): LocalDate {
    return LocalDate.parse(date, LocalDate.Formats.ISO)
}

fun getTimezone(timezone: String): TimeZone {
    return TimeZone.of(timezone)
}

fun getInstant(dateTime: String): Instant {
    return Instant.parse(dateTime)
}

fun getDuration(seconds: Long): Duration {
    return seconds.toDuration(DurationUnit.SECONDS)
}