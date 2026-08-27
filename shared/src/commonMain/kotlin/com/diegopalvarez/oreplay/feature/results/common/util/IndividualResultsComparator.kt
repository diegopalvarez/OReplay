package com.diegopalvarez.oreplay.feature.results.common.util

import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import kotlin.time.Clock
import kotlin.time.Instant

fun individualResultsComparator(
    now: Instant?
): Comparator<ResultIndividual> {
    val liveNow = now ?: Clock.System.now()
    return sortByStatus()
        .then { a, b ->
            // All sorting paths must end in a compare(a, b)

            // Check if they have both finished
            val haveBothFinished = haveBothFinished(a, b)

            if(haveBothFinished){
                // If both have finished, compare by stage Position, Start Time and Time
                sortByStagePosition()
                    .then(sortByStartTime(false))
                    .then(sortByTime())
                    .compare(a, b)
            }
            else{
                // Check if they have both started
                val haveBothStarted = haveBothStarted(a, b, liveNow)

                if(haveBothStarted){
                    // TODO - Add radio controls sorts
                    // TODO - Sort by current live time if not radios
                    // If both have started, compare by controlRunningTowards, lastCommonOnlineControl, finishedStatus, runningTowardsFirstOnline and startTime
                    sortByFinishedStatus()
                        .then(sortByStartTime())
                        .compare(a, b)
                }
                else{
                    // If not both have started, sort by startedStatus and startTime
                    sortByStartedStatus(liveNow)
                        .then(sortByStartTime())
                        .compare(a, b)
                }
            }
        }
        .then(sortByName())
}