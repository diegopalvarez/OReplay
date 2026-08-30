package com.diegopalvarez.oreplay.ui.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.intl.Locale
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format.DayOfWeekNames
import kotlinx.datetime.number
import kotlinx.datetime.toLocalDateTime
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.date_full
import org.jetbrains.compose.resources.stringResource
import kotlin.time.Instant

@Composable
fun DateTimeFormatter(
    instant: Instant,
    timezone: TimeZone = TimeZone.currentSystemDefault()
){
    // Get the dateTime
    val dateTime = instant.toLocalDateTime(timezone)

    // Get the localized strings
    val dayOfWeek = stringResource(dateTime.dayOfWeek.display())
    val month = stringResource(dateTime.month.display())

    // Build the text
    Text(
        text = stringResource(
            Res.string.date_full,
            dayOfWeek,
            month,
            dateTime.day,
            dateTime.year,
            dateTime.time
        ),
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        style = MaterialTheme.typography.bodySmall,
    )
}