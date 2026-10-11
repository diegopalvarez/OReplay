package com.diegopalvarez.oreplay.feature.results.common.util

import kotlin.time.Instant
import com.diegopalvarez.oreplay.domain.model.Result
import kotlin.time.Duration.Companion.seconds

fun isResultUpdated(now: Instant?, updateInterval: Long?, result: Result): Boolean {
    val isUpdate = result.isUpdate
    if(now == null || isUpdate == null){
        return false
    }

    // Get the update interval, that defaults to 30 seconds
    val interval = updateInterval?.seconds ?: 30.seconds

    return now.minus(isUpdate) < interval
}