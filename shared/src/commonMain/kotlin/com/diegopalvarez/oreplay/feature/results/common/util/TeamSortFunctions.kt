package com.diegopalvarez.oreplay.feature.results.common.util

import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.ResultTeam
import com.diegopalvarez.oreplay.domain.types.StatusCode
import kotlin.time.Clock
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlin.time.Instant

fun sortByStatusTeam(): Comparator<ResultTeam> {
    return Comparator{ a, b ->
        val statusA = statusOrder(a.stageResult, a.isNc)
        val statusB = statusOrder(b.stageResult, b.isNc)

        statusA - statusB // Smaller status are the ones with the most priority
    }
}

fun sortByStagePositionTeam(): Comparator<ResultTeam> {
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

fun sortByNameTeam(): Comparator<ResultTeam> {
    return Comparator{ a, b ->
        a.fullName
            .lowercase()
            .compareTo(b.fullName.lowercase())
    }
}

fun sortByStartTimeTeam(
    ascending: Boolean = true
): Comparator<ResultTeam> {
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

private fun hasFinishedTeam(runner: ResultTeam): Boolean {
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

private fun hasStartedTeam(runner: ResultTeam, now: Instant): Boolean {
    return if(hasFinishedTeam(runner)){
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

fun sortByFinishedStatusTeam(): Comparator<ResultTeam> {
    return Comparator{ a, b ->
        val finishedA = hasFinishedTeam(a)
        val finishedB = hasFinishedTeam(b)

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

fun sortByStartedStatusTeam(now: Instant): Comparator<ResultTeam> {
    return Comparator{ a, b ->
        val startedA = hasStartedTeam(a, now)
        val startedB = hasStartedTeam(b, now)

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

fun sortByTimeTeam(): Comparator<ResultTeam> {
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

fun sortByNCTeam(): Comparator<ResultTeam> {
    return Comparator{ a, b ->
        val aNC = a.isNc
        val bNC = b.isNc

        if(aNC && bNC){
            0
        }
        else if(aNC){
            1
        }
        else if(bNC){
            -1
        }
        else{
            0
        }
    }
}

fun haveBothFinishedTeam(a: ResultTeam, b: ResultTeam): Boolean {
    return hasFinishedTeam(a) && hasFinishedTeam(b)
}

fun haveBothStartedTeam(a: ResultTeam, b: ResultTeam, now: Instant): Boolean {
    return hasStartedTeam(a, now) && hasStartedTeam(b, now)
}

fun liveParticipantTime(
    runner: ResultIndividual,
    now: Instant
): Duration? {
    // Check if the runner has start time
    if(runner.stageResult != null && runner.stageResult.startTime != null){
        // Check if the runner has finish time
        return if(runner.stageResult.finishTime != null){
            runner.stageResult.timeSeconds
        } else{
            // Calculate the current time dynamically
            if(now > runner.stageResult.startTime){
                // If the runner has already started, return its current time
                now.minus(runner.stageResult.startTime)
            } else{
                null
            }
        }
    }
    else{
        return null
    }
}

fun liveRelayTime(
    result: ResultTeam,
    now: Instant,
    maxLegParam: Int? = null
): Duration? {
    // If no leg is specified and the team already has a time, use that time
    if(maxLegParam == null && result.stageResult?.timeSeconds != null) {
        return result.stageResult.timeSeconds
    }

    // Check if the result is correct and has team members
    if(result.runners.isEmpty()){
        // TODO - Raise and exception, every team should have members
        return null
    }

    // Compute the total time up to the maximum specified leg
    val maxLeg = maxLegParam ?: result.runners.size         // If there is no maxLeg, count them all
    var teamTime = 0.seconds
    var isValidResult = false

    for(i in 0 until maxLeg){
        val legTime = liveParticipantTime(result.runners[i], now)

        if(legTime != null){
            teamTime += legTime
            isValidResult = true
        }
    }

    // Check if the accumulated result is valid
    return if(isValidResult){
        teamTime
    }
    else{
        null
    }
}

fun findLastFinishedRelayLeg(
    members: List<ResultIndividual>
): Int{
    for(i in members.indices.reversed()){
        if(hasFinished(members[i])){
            return i
        }
    }

    return -1
}

fun findLegsNumberRunning(
    result: ResultTeam,
    now: Instant?
): List<Long> {
    val liveNow = now ?: Clock.System.now()

    if(result.runners.isEmpty()){
        // TODO - Throw exception
        return emptyList()
    }

    // Find the legs that have started
    return result.runners.filter { leg ->
        leg.stageResult != null && leg.stageResult.startTime != null && leg.stageResult.finishTime == null && liveNow > leg.stageResult.startTime
    }.map { leg -> leg.legNumber }
}

fun sortByLiveRelayTime(now: Instant): Comparator<ResultTeam> {
    return Comparator{ a, b ->
        val aRelayTime = liveRelayTime(a, now)
        val bRelayTime = liveRelayTime(b, now)

        if(aRelayTime != null && bRelayTime != null){
            // Round the time to milliseconds to avoid floating-point precision errors
            ((aRelayTime - bRelayTime) * 1000.0).inWholeMilliseconds.toInt()
        }
        else{
            0
        }
    }
}

fun sortByLastCommonLegTime(now: Instant): Comparator<ResultTeam> {
    return Comparator{ a, b ->
        val aRunners = a.runners
        val bRunners = b.runners

        if(aRunners.isEmpty() || bRunners.isEmpty()){
            // This should be impossible since all relay teams must have team members
            // TODO - Raise Exception
            0
        }

        val aLastLegIndex = findLastFinishedRelayLeg(aRunners)
        val bLastLegIndex = findLastFinishedRelayLeg(bRunners)

        if(aLastLegIndex != -1 && bLastLegIndex != -1){
            val lastCommon = minOf(aLastLegIndex, bLastLegIndex)

            val aCommonTime = liveRelayTime(a, now, lastCommon + 1)
            val bCommonTime = liveRelayTime(b, now, lastCommon + 1)

            if(aCommonTime != null && bCommonTime != null){
                aCommonTime.compareTo(bCommonTime)
            }
            else{
                0
            }
        }
        else{
            0
        }
    }
}

fun isSameLegRunning(
    a: ResultTeam,
    b: ResultTeam,
    now: Instant?
): Boolean {
    val aRunningLeg = findLegsNumberRunning(a, now).maxOrNull() ?: 0
    val bRunningLeg = findLegsNumberRunning(b, now).maxOrNull() ?: 0

    return aRunningLeg == bRunningLeg
}