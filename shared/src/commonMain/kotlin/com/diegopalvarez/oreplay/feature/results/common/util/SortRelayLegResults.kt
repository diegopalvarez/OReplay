package com.diegopalvarez.oreplay.feature.results.common.util

import com.diegopalvarez.oreplay.domain.model.RelayLegResult
import kotlin.time.Clock
import kotlin.time.Instant

fun sortLegResults(
    results: List<RelayLegResult>,
    now: Instant?
): List<RelayLegResult> {
    val liveNow = now ?: Clock.System.now()
    return results
        .sortedWith(
            sortByStatusLeg()
                .then { a, b ->
                    // All sorting paths must end in a compare(a, b)

                    // Check if they have both finished
                    val haveBothFinished = haveBothFinishedLeg(a, b)

                    if(haveBothFinished){
                        // If both have finished, compare by stage Position, Start Time and Time
                        sortByStagePositionLeg()
                            .then(sortByStartTimeLeg(false))
                            .then(sortByTeamTime())
                            .compare(a, b)
                    }
                    else{
                        // Check if they have both started
                        val haveBothStarted = haveBothStartedLeg(a, b, liveNow)

                        if(haveBothStarted){
                            // TODO - Add radio controls sorts
                            // TODO - Sort by current live time if not radios
                            // If both have started, compare by controlRunningTowards, lastCommonOnlineControl, finishedStatus, runningTowardsFirstOnline and startTime
                            sortByFinishedStatusLeg()
                                .then(sortByStartTimeLeg())
                                .compare(a, b)
                        }
                        else{
                            // If not both have started, sort by startedStatus and startTime
                            sortByStartedStatusLeg(liveNow)
                                .then(sortByStartTimeLeg())
                                .compare(a, b)
                        }
                    }
                }
                .then(sortByTeamName())
        )
}