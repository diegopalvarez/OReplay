package com.diegopalvarez.oreplay.ui.util

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Instant

val timeFormatter = LocalDateTime.Format {
    hour()
    chars(":")
    minute()
    chars(":")
    second()
}

fun Instant.displayTime(timezone: TimeZone = TimeZone.currentSystemDefault()): String{
    val dateTime = this.toLocalDateTime(timezone)
    return dateTime.format(timeFormatter)
}