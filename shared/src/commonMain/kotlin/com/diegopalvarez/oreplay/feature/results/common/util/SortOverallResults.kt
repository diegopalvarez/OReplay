package com.diegopalvarez.oreplay.feature.results.common.util

import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.domain.model.RelayLegResult
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.types.StatusCode
import kotlin.time.Clock
import kotlin.time.Instant

// TODO - Check if there is something missing
fun sortOverallResults(
    results: List<ResultIndividual>,
): List<ResultIndividual> {
    return results
        .sortedWith(
            sortByStatusOverall()
                .then { a, b ->
                    // Overall results don't have start times or finish times, so the results can't be ordered on whether they have started and/or finished
                    sortByStagePositionOverall()
                        .then(sortByTimeOverall())
                        .compare(a, b)
                }
                .then(sortByNameOverall())
        )
}