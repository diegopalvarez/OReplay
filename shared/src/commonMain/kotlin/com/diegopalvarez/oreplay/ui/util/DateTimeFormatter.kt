package com.diegopalvarez.oreplay.ui.util

import androidx.compose.ui.text.intl.Locale
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.number
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Instant

fun Instant.display(timezone: TimeZone = TimeZone.currentSystemDefault()): String{
    val dateTime = this.toLocalDateTime(timezone)
    return if(Locale.current.language == "es"){
        "${dateTime.dayOfWeek}, ${dateTime.day} de ${dateTime.month} del ${dateTime.year} a las ${dateTime.time}"
    }
    else{
        "${dateTime.dayOfWeek}, ${dateTime.month} ${dateTime.day}, ${dateTime.year}, ${dateTime.time}"
    }
}