package com.diegopalvarez.oreplay.data.remote.websocket

import com.diegopalvarez.oreplay.data.remote.dto.liveResults.RemoteLiveResult
import com.diegopalvarez.oreplay.data.remote.dto.liveResults.RemoteLiveStageResult
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteOverallResult
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteResult
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteSplit
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteStageResult

fun mergeRemoteResults(currentResult: RemoteResult, newResult: RemoteLiveResult): RemoteResult {
    // All the details for the runner are the ones that come from the new result
    return RemoteResult(
        id = newResult.id,
        bibNumber = newResult.bibNumber,
        isNc = newResult.isNc,
        eligibility = newResult.eligibility,
        sicard = newResult.sicard,
        sex = newResult.sex,
        legNumber = newResult.legNumber,
        legs = newResult.legs,
        runners = mergeRemoteTeamRunners(currentResult.runners, newResult.runners),
        created = newResult.created,
        runnerClass = newResult.runnerClass,
        runnerClub = newResult.runnerClub,
        fullName = newResult.fullName,
        stageResult = mergeRemoteStageResults(currentResult.stageResult, newResult.stageResult)
    )
}

private fun mergeRemoteStageResults(currentStageResult: RemoteStageResult?, newStageResult: RemoteLiveStageResult?): RemoteStageResult? {
    if(newStageResult == null) return null

    // The valid remote stage results are the ones from the updated result
    return RemoteStageResult(
        id = newStageResult.id,
        resultTypeID = newStageResult.resultTypeID,
        startTime = newStageResult.startTime,
        finishTime = newStageResult.finishTime,
        uploadType = newStageResult.uploadType,
        timeSeconds = newStageResult.timeSeconds,
        position = newStageResult.position,
        statusCode = newStageResult.statusCode,
        isNc = newStageResult.isNc,
        contributory = newStageResult.contributory,
        timeBehind = newStageResult.timeBehind,
        timeNeutralization = newStageResult.timeNeutralization,
        timeAdjusted = newStageResult.timeAdjusted,
        timePenalty = newStageResult.timePenalty,
        timeBonus = newStageResult.timeBonus,
        pointsFinal = newStageResult.pointsFinal,
        pointsBehind = newStageResult.pointsBehind,
        pointsAdjusted = newStageResult.pointsAdjusted,
        pointsPenalty = newStageResult.pointsPenalty,
        pointsBonus = newStageResult.pointsBonus,
        note = newStageResult.note,
        legNumber = newStageResult.legNumber,
        created = newStageResult.created,
        splits = mergeRemoteSplits(currentStageResult?.splits, newStageResult.splits),
    )
}

private fun mergeRemoteSplits(currentSplits: List<RemoteSplit>?, newSplits: List<RemoteSplit>?): List<RemoteSplit> {
    // If the current splits are null, this means there wasn't a stage result previously
    return if (currentSplits == null) {
        // This should never happen, but if the current and new splits are null, return an empty list
        if(newSplits != null) newSplits else emptyList()
    }
    else {
        // If there are new splits, return them. If not, keep the old splits
        if(newSplits != null) newSplits else currentSplits
    }
}

private fun mergeRemoteTeamRunners(currentTeamRunners: List<RemoteResult>?, newTeamRunners: List<RemoteLiveResult>?): List<RemoteResult>? {
    if(currentTeamRunners == null) {
        return newTeamRunners?.map { mergeRemoteNewResults(it) }
    }

    if(newTeamRunners == null) {
        // The newest update is always the important one
        return null
    }

    // Create copies of all the lists
    val currentList = currentTeamRunners.toMutableList()
    val newList = newTeamRunners.toMutableList()
    val mergedList = mutableListOf<RemoteResult>()

    while (currentList.isNotEmpty()) {
        // Get the first runner
        val first = currentList.first()

        // Find if this runner is in the new list
        val runner = newList.find { it.id == first.id }

        if(runner != null) {
            // Merge the runner with the new one
            val merged = mergeRemoteResults(first, runner)

            // Insert it into the new list
            mergedList.add(merged)

            // Remove it from both lists
            currentList.remove(first)
            newList.remove(runner)
        }
        else{
            // If it isn't we don't insert it back in the new list
            currentList.remove(first)
        }
    }

    // At this point, only runners that are new in the new results should remain
    for(remaining in newList){
       mergedList.add(mergeRemoteNewResults(remaining))
    }

    // Return the new list
    return mergedList
}

fun mergeRemoteNewResults(newResult: RemoteLiveResult): RemoteResult {
    return RemoteResult(
        id = newResult.id,
        bibNumber = newResult.bibNumber,
        isNc = newResult.isNc,
        eligibility = newResult.eligibility,
        sicard = newResult.sicard,
        sex = newResult.sex,
        legNumber = newResult.legNumber,
        legs = newResult.legs,
        runners = newResult.runners?.map { mergeRemoteNewResults(it) },
        created = newResult.created,
        runnerClass = newResult.runnerClass,
        runnerClub = newResult.runnerClub,
        fullName = newResult.fullName,
        stageResult = mergeRemoteNewStageResult(newResult.stageResult)
    )
}

private fun mergeRemoteNewStageResult(newStageResult: RemoteLiveStageResult?): RemoteStageResult? {
    // If the result is null, return it
    if(newStageResult == null){
        return null
    }

    return RemoteStageResult(
        id = newStageResult.id,
        resultTypeID = newStageResult.resultTypeID,
        startTime = newStageResult.startTime,
        finishTime = newStageResult.finishTime,
        uploadType = newStageResult.uploadType,
        timeSeconds = newStageResult.timeSeconds,
        position = newStageResult.position,
        statusCode = newStageResult.statusCode,
        isNc = newStageResult.isNc,
        contributory = newStageResult.contributory,
        timeBehind = newStageResult.timeBehind,
        timeNeutralization = newStageResult.timeNeutralization,
        timeAdjusted = newStageResult.timeAdjusted,
        timePenalty = newStageResult.timePenalty,
        timeBonus = newStageResult.timeBonus,
        pointsFinal = newStageResult.pointsFinal,
        pointsBehind = newStageResult.pointsBehind,
        pointsAdjusted = newStageResult.pointsAdjusted,
        pointsPenalty = newStageResult.pointsPenalty,
        pointsBonus = newStageResult.pointsBonus,
        note = newStageResult.note,
        legNumber = newStageResult.legNumber,
        created = newStageResult.created,

        // If the splits are null but there is no previous result, return an empty list
        splits = newStageResult.splits ?: emptyList()
    )
}

private fun mergerRemoteOverallResults(currentOverallResult: RemoteOverallResult?, newOverallResult: RemoteOverallResult): RemoteOverallResult {
    // TODO - Check with Adrian if the overalls are dynamically updated
    return newOverallResult
}