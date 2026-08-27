package com.diegopalvarez.oreplay.feature.results.common.util

import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.types.StatusCode
import kotlin.time.Clock
import kotlin.time.Instant

fun sortIndividualResults(
    results: List<ResultIndividual>,
    now: Instant?,
): List<ResultIndividual> {
    return results
        .sortedWith(
            individualResultsComparator(now)
        )
}

fun sortIndividualStartTimes(
    results: List<ResultIndividual>
): List<ResultIndividual> {
    return results
        .sortedWith(
            sortByStartTime()
                .then(sortByName())
        )
}