package com.diegopalvarez.oreplay.domain.model

import kotlinx.datetime.LocalDateTime
import kotlin.time.Duration
import kotlin.time.Instant

data class SplitIndividual(
    val id: String,
    val isIntermediate: Boolean,
    val readingTime: Instant?,
    val points: Long,
    val orderNumber: Long,
    val created: Instant,

    val control: Control,

    // Calculated properties
    var partial: Duration? = null,
    var partialDifference: Duration? = null,
    var partialPosition: Long? = null,
    var accumulated: Duration? = null,
    var accumulatedDifference: Duration? = null,
    var accumulatedPosition: Long? = null,
    var accumulatedError: Boolean = false,
)
