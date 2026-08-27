package com.diegopalvarez.oreplay.feature.results.common.util

import com.diegopalvarez.oreplay.domain.model.RelayLegResult
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.types.StatusCode
import kotlin.time.Clock
import kotlin.time.Instant

fun teamStatusOrder(runnerStageResult: StageResult?, teamStatus: StatusCode, teamPosition: Long, isNC: Boolean): Int{
    if(runnerStageResult == null){
        return 10
    }

    // If the results is NC, it is shown depending on its status code
    // TODO - Check NC ordering

    // The position is 0 when there's no position applicable
    return when(teamStatus){
        StatusCode.OK -> {
            if(teamPosition > 0 || isNC){
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
        StatusCode.DID_NOT_FINISH -> 4
        StatusCode.DID_NOT_START -> 6
    }
}

fun sortByStatusLeg(): Comparator<RelayLegResult> {
    return Comparator{ a, b ->
        val statusA = teamStatusOrder(a.result.stageResult, a.teamError, a.accumulatedPosition, a.teamNC)
        val statusB = teamStatusOrder(b.result.stageResult, b.teamError, b.accumulatedPosition, b.teamNC)

        statusA - statusB // Smaller status are the ones with the most priority
    }
}

fun sortByStagePositionLeg(): Comparator<RelayLegResult> {
    return Comparator{ a, b ->
        val positionA = a.accumulatedPosition
        val positionB = b.accumulatedPosition

        if(positionA != 0L && positionB != 0L){
            // If both positions are valid finished positions, sort in a new step
            sortByPosition(positionA, positionB, a.teamNC, b.teamNC)
        }
        else if(positionA == 0L && positionB == 0L) {
            // If both positions are 0, both runners haven't finished correctly or yet
            0
        }
        else if(positionA == 0L){
            1
        }
        else if(positionB == 0L){
            -1
        }
        else{
            0
        }
    }
}

fun sortByTeamName(): Comparator<RelayLegResult> {
    return Comparator{ a, b ->
        a.teamName
            .lowercase()
            .compareTo(b.teamName.lowercase())
    }
}

fun sortByStartTimeLeg(
    ascending: Boolean = true
): Comparator<RelayLegResult> {
    return Comparator{ a, b ->
        val startTimeA = a.result.stageResult?.startTime
        val startTimeB = b.result.stageResult?.startTime

        if(startTimeA != null && startTimeB != null){
            if(ascending){
                startTimeA.compareTo(startTimeB)
            }
            else{
                startTimeB.compareTo(startTimeA)
            }
        }
        else if(startTimeA != null){
            -1
        }
        else if(startTimeB != null){
            1
        }
        else{
            0
        }
    }
}

// TODO - Add functions to sort radio controls
fun sortByFinishedStatusLeg(): Comparator<RelayLegResult> {
    return Comparator{ a, b ->
        val finishedA = hasFinished(a.result)
        val finishedB = hasFinished(b.result)

        if(finishedA && finishedB){
            0
        }
        else if(finishedA){
            -1
        }
        else if(finishedB){
            1
        }
        else{
            0
        }
    }
}

fun sortByStartedStatusLeg(now: Instant): Comparator<RelayLegResult> {
    return Comparator{ a, b ->
        val startedA = hasStarted(a.result, now)
        val startedB = hasStarted(b.result, now)

        if(startedA && startedB){
            0
        }
        else if(startedA){
            -1
        }
        else if(startedB){
            1
        }
        else{
            0
        }
    }
}

fun sortByTeamTime(): Comparator<RelayLegResult> {
    return Comparator{ a, b ->
        val timeA = a.teamTime
        val timeB = b.teamTime

        timeA.compareTo(timeB)
    }
}

fun haveBothFinishedLeg(a: RelayLegResult, b: RelayLegResult): Boolean {
    return hasFinished(a.result) && hasFinished(b.result)
}

fun haveBothStartedLeg(a: RelayLegResult, b: RelayLegResult, now: Instant): Boolean {
    return hasStarted(a.result, now) && hasStarted(b.result, now)
}