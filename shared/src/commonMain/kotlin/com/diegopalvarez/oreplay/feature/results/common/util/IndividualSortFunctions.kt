package com.diegopalvarez.oreplay.feature.results.common.util

import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.types.StatusCode
import kotlin.time.Clock
import kotlin.time.Instant

fun sortByStatus(): Comparator<ResultIndividual> {
    return Comparator{ a, b ->
        val statusA = statusOrder(a.stageResult, a.isNc)
        val statusB = statusOrder(b.stageResult, b.isNc)

        statusA - statusB // Smaller status are the ones with the most priority
    }
}

fun sortByStagePosition(): Comparator<ResultIndividual> {
    return Comparator{ a, b ->
        val positionA = a.stageResult?.position
        val positionB = b.stageResult?.position

        if(positionA != 0L && positionB != 0L){
            // If both positions are valid finished positions, sort in a new step
            sortByPosition(positionA, positionB, a.isNc, b.isNc)
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

fun sortByOverallPosition(): Comparator<ResultIndividual> {
    return Comparator{ a, b ->
        sortByPosition(
            a.overallResult?.overallTotal?.position,
            b.overallResult?.overallTotal?.position,
            a.isNc,     // TODO - Check why there are several different isNC fields
            b.isNc,)
    }
}

fun sortByName(): Comparator<ResultIndividual> {
    return Comparator{ a, b ->
        a.fullName
            .lowercase()
            .compareTo(b.fullName.lowercase())
    }
}

fun sortByStartTime(
    ascending: Boolean = true
): Comparator<ResultIndividual> {
    return Comparator{ a, b ->
        val startTimeA = a.stageResult?.startTime
        val startTimeB = b.stageResult?.startTime

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

fun hasFinished(runner: ResultIndividual): Boolean {
    return if(runner.stageResult == null){
        false
    }
    else{
        if(runner.stageResult.finishTime != null){
            true
        } else if(runner.stageResult.position > 0L){
            true
        } else if(runner.stageResult.statusCode != StatusCode.OK){
            true
        } else{
            false
        }
    }
}

fun hasStarted(runner: ResultIndividual, now: Instant): Boolean {
    return if(hasFinished(runner)){
        // If a runner has finished, then it has started
        true
    }
    else if(runner.stageResult?.startTime != null){
       now > runner.stageResult.startTime
    }
    else{
        // If the runner doesn't have a stageResult, then it never starts
        false
    }
}

fun sortByFinishedStatus(): Comparator<ResultIndividual> {
    return Comparator{ a, b ->
        val finishedA = hasFinished(a)
        val finishedB = hasFinished(b)

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

fun sortByStartedStatus(now: Instant): Comparator<ResultIndividual> {
    return Comparator{ a, b ->
        val startedA = hasStarted(a, now)
        val startedB = hasStarted(b, now)

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

fun sortByTime(): Comparator<ResultIndividual> {
    return Comparator{ a, b ->
        val timeA = a.stageResult?.timeSeconds
        val timeB = b.stageResult?.timeSeconds

        if(timeA != null && timeB != null){
            timeA.compareTo(timeB)
        }
        else if(timeA != null){
            -1
        }
        else if(timeB != null){
            1
        }
        else{
            0
        }

    }
}

fun haveBothFinished(a: ResultIndividual, b: ResultIndividual): Boolean {
    return hasFinished(a) && hasFinished(b)
}

fun haveBothStarted(a: ResultIndividual, b: ResultIndividual, now: Instant): Boolean {
    return hasStarted(a, now) && hasStarted(b, now)
}