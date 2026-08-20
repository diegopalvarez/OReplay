package com.diegopalvarez.oreplay.feature.results.common.util

import com.diegopalvarez.oreplay.domain.model.ResultTeam
import com.diegopalvarez.oreplay.domain.types.StatusCode

// TODO - Check if it's possible to handle runners that are still running dynamically in their "LIVE" position
// TODO - Will need a different function to handle radio controls
// TODO - Modularize to avoid code repetition
private fun sortPriority(result: ResultTeam): Int{
    // The default is the lowest priority possible
    if(result.stageResult == null){
        return 10
    }

    // If the results is NC, it has its own priority behind OK results
    if(result.isNc){
        return 4
    }

    // The position is 0 when there's no position applicable
    return when(result.stageResult.statusCode){
        StatusCode.OK -> {
            if(result.stageResult.position > 0){
                // The first results are the correct ones
                0
            } else{
                // Runners that are still running are displayed under correctly finished runners and OT
                2
            }
        }
        StatusCode.OVERTIME -> 1
        StatusCode.MISSING_PUNCH -> 3
        StatusCode.DISQUALIFIED -> 5
        StatusCode.DID_NOT_FINISH -> 6
        StatusCode.DID_NOT_START -> 7
    }
}

fun sortTeamResults(
    results: List<ResultTeam>
): List<ResultTeam> {
    return results
        .sortedWith(
            compareBy<ResultTeam>(
                ::sortPriority
            ).thenBy {
                // Runners that have finished are ordered by their positions, and the others keep their relative order
                it.stageResult?.position ?: Int.MIN_VALUE
            }.thenBy {
                // Runners that have the same position (in a club, for example) are ordered by their total time
                it.stageResult?.timeSeconds ?: Int.MIN_VALUE
            }

        )
}