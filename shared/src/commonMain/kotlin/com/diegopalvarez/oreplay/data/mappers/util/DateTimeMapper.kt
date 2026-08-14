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

fun getInstantOrNull(dateTime: String?): Instant? {
    return if(dateTime==null){
        null
    }
    else {
        Instant.parse(dateTime)
    }
}

fun getDuration(seconds: Long): Duration {
    return seconds.toDuration(DurationUnit.SECONDS)
}

fun getDurationOrNull(seconds: Long?): Duration? {
    return if(seconds==null){
        null
    }
    else{
        seconds.toDuration(DurationUnit.SECONDS)
    }
}