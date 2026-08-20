package com.diegopalvarez.oreplay.feature.results.common.util

import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.ResultTeam
import com.diegopalvarez.oreplay.domain.types.StatusCode
import kotlin.time.Clock
import kotlin.time.Instant

fun sortTeamResults(
    results: List<ResultTeam>,
    now: Instant?,
): List<ResultTeam> {
    val liveNow = now ?: Clock.System.now()
    return results
        .sortedWith(
            sortByStatusTeam()
                .then { a, b ->
                    // All sorting paths must end in a compare(a, b)

                    // Check if they have both finished
                    val haveBothFinished = haveBothFinishedTeam(a, b)

                    if(haveBothFinished){
                        // If both have finished, compare by stage Position, Start Time and if it's NC
                        sortByStagePositionTeam()
                            .then(sortByTimeTeam())
                            .then(sortByNCTeam())
                            .compare(a, b)
                    }
                    else{
                        // Check if they have both started
                        val haveBothStarted = haveBothStartedTeam(a, b, liveNow)

                        if(haveBothStarted){
                            // TODO - Add radio controls sorts
                            // If both have started, sort by total live relay time. If there's a tie, check if the same leg is running for both teams
                            sortByLiveRelayTime(liveNow)
                                .then{ a, b ->
                                    // Check if the same leg is running for both teams
                                    val isSameLegRunning = isSameLegRunning(a, b, liveNow)

                                        if(isSameLegRunning){
                                            sortByLastCommonLegTime(liveNow)
                                                .compare(a, b)
                                        }
                                        else{
                                            sortByLastCommonLegTime(liveNow)
                                                .then(sortByFinishedStatusTeam())
                                                .then(sortByStartTimeTeam(false))
                                                .compare(a, b)
                                    }
                                }
                                .compare(a, b)

                        }
                        else{
                            // If not both have started, sort by startedStatus and startTime
                            sortByStartedStatusTeam(liveNow)
                                .then(sortByStartTimeTeam())
                                .compare(a, b)
                        }
                    }
                }
                .then(sortByNameTeam())
        )
}

fun sortTeamStartTimes(
    results: List<ResultTeam>
): List<ResultTeam> {
    return results
        .sortedWith(
            sortByStartTimeTeam()
                .then(sortByNameTeam())
        )
}