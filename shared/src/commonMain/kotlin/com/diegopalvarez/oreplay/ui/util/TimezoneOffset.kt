package com.diegopalvarez.oreplay.ui.util

import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.UtcOffset
import kotlinx.datetime.atTime
import kotlinx.datetime.offsetAt
import kotlinx.datetime.toInstant

fun TimeZone.offsetOn(date: LocalDate): UtcOffset {
    val instant = date
        .atTime(12, 0)
        .toInstant(this)

    return offsetAt(instant)
}