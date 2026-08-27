package com.diegopalvarez.oreplay.domain.repository.util

import com.diegopalvarez.oreplay.domain.model.ResultIndividual

fun calculateVisitedControls(
    results: List<ResultIndividual>
): ScoreResultStats {
    // Create the initial map that will store every different control and the number of people that have visited
    val map = mutableMapOf<String, Long>()

    // Iterate through every runner in the class
    for (runner in results) {
        val stageResult = runner.stageResult

        if(stageResult != null) {
            for(split in stageResult.splits){
                // Increment in one every visited control by this runner

                // Get the current value for that control
                val currentCount = map.getOrElse(split.control.station, { 0L })

                // Increment by one
                map[split.control.station] = currentCount + 1
            }
        }
    }

    return ScoreResultStats(
        visited = map,
        runners = results.size.toLong(),
    )
}