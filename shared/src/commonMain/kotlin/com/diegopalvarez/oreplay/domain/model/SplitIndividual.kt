package com.diegopalvarez.oreplay.domain.model

import kotlinx.datetime.LocalDateTime
import kotlin.time.Duration

data class SplitIndividual(
    val id: String,
    val isIntermediate: Boolean,
    val readingTime: LocalDateTime,
    val points: Long,
    val orderNumber: Long,
    val created: LocalDateTime,

    val control: Control,

    // Calculated properties
    val partial: Duration,
    val partialDifference: Duration,
    val partialPosition: Long,
    val accumulated: Duration,
    val accumulatedDifference: Duration,
    val accumulatedPosition: Long,
)
