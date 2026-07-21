package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.mappers.util.getDuration
import com.diegopalvarez.oreplay.data.mappers.util.getInstant
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteOverall
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteOverallResult
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteResult
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteResultsResponse
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteSplit
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteStageResult
import com.diegopalvarez.oreplay.domain.model.Overall
import com.diegopalvarez.oreplay.domain.model.OverallResult
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.ResultTeam
import com.diegopalvarez.oreplay.domain.model.SplitIndividual
import com.diegopalvarez.oreplay.domain.model.StageResult
import kotlin.time.Duration
import kotlin.Long
import kotlin.time.Instant

/**
 * Private function to map an Individual Result
 * @param remoteResult result for an individual as gotten from the API
 * @return domain model object with all the data except the CALCULATED FIELDS (partial and accumulated times)
 */
private fun getIndividualResult(remoteResult: RemoteResult): ResultIndividual{
    return ResultIndividual(
        id = remoteResult.id,
        bibNumber = remoteResult.bibNumber,
        isNc = remoteResult.isNc,
        eligibility = remoteResult.eligibility,
        siCard = requireNotNull(remoteResult.sicard) {"Individual results must contain a SI Card"},
        sex = requireNotNull(remoteResult.sex) {"Individual results must contain the sex of the runner"},
        legNumber = requireNotNull(remoteResult.legNumber) {"Individual results must all contains a leg number"},
        created = getInstant(remoteResult.created),
        fullName = remoteResult.fullName,
        runnerClass =   remoteResult.runnerClass?.let(::getResultClass),
        runnerClub =    remoteResult.runnerClub?.let(::getClub),
        stageResult =   remoteResult.stageResult?.let(::getStageResult),
        overallResult = remoteResult.overalls?.let(::getOverallResult)
    )
}

/**
 * Private function to map a Stage Result
 * @param remoteStageResult stage result from the API
 * @return domain model object with all the stage result data, including the sorted splits
 */
private fun getStageResult(remoteStageResult: RemoteStageResult): StageResult {
    return StageResult(
        id = remoteStageResult.id,
        resultType = remoteStageResult.resultTypeID,
        startTime = getInstant(remoteStageResult.startTime),
        finishTime = getInstant(remoteStageResult.finishTime),
        uploadType = remoteStageResult.uploadType,
        timeSeconds = getDuration(remoteStageResult.timeSeconds),
        position = remoteStageResult.position,
        statusCode = remoteStageResult.statusCode,
        isNC = remoteStageResult.isNc,
        contributory = remoteStageResult.contributory,
        timeBehind = getDuration(remoteStageResult.timeBehind),
        timeNeutralization = getDuration(remoteStageResult.timeNeutralization),
        timeAdjusted = getDuration(remoteStageResult.timeAdjusted),
        timePenalty = getDuration(remoteStageResult.timePenalty),
        timeBonus = getDuration(remoteStageResult.timeBonus),
        pointsTotal = remoteStageResult.pointsFinal,
        pointsBehind = remoteStageResult.pointsBehind,
        pointsAdjusted = remoteStageResult.pointsAdjusted,
        pointsPenalty = remoteStageResult.pointsPenalty,
        pointsBonus = remoteStageResult.pointsBonus,
        note = remoteStageResult.note,
        legNumber = remoteStageResult.legNumber,
        created = getInstant(remoteStageResult.created),
        splits = getSplits(remoteStageResult.splits)
    )
}

/**
 * Private function to map an individual split
 * @param remoteSplit single split from the API
 * @return domain model object for a single Split, without the attributes that need to be compared to the class (partial and accumulated)
 */
private fun getSplit(remoteSplit: RemoteSplit): SplitIndividual{
    return SplitIndividual(
        id = remoteSplit.id,
        isIntermediate = remoteSplit.isIntermediate,
        readingTime =   remoteSplit.readingTime?.let(::getInstant),
        points = remoteSplit.points,
        orderNumber = remoteSplit.orderNumber ?: -1,
        created = getInstant(remoteSplit.created),
        control = getControl(remoteSplit.control)
        // Class-related attributes must be calculated in a later stage, since the comparison data isn't available at this time
    )
}

/**
 * Private function to map and sort all the splits from a list of RemoteSplits from the API
 * @param splits List of RemoteSplits
 * @return list of domain model splits, sorted by order number
 */
private fun getSplits(splits: List<RemoteSplit>): List<SplitIndividual> {
    return splits.map(::getSplit).sortedBy { it.orderNumber }
}

/**
 * Function to parse the results for a same class, when the results are CLASSIC/INVIDIDUAL
 * @param remoteResultsResponse response from the API containing the results for the class
 * @param calculateRanks boolean indicating if it's needed to calculate the ranks for these results. By default, true, but in case of a One-Man Relay might be false
 * @return list of domain model objects containing all runners, with additional information added to the splits (if available)
 */
fun getClassicResults(remoteResultsResponse: RemoteResultsResponse, calculateRanks: Boolean = true): List<ResultIndividual> {
    val results = remoteResultsResponse.results

    // Map the individual results to domain model objects
    val resultsList = results.map(::getIndividualResult)

    // If there are splits available, calculate the additional data
    if (resultsList.any { it.stageResult != null }) {
        // Now that we have the results for all the runners, we must calculate the additional data for the splits
        // For each control, we must calculate the partial time and accumulated time, and then rank each one using all the results from the class
        val listResults = calculateIndividualTimes(resultsList)

        // After calculating both the partial and accumulated times for all runners and controls (when possible), we must find the best times for each control and calculate the difference and positions
        if(calculateRanks) {
            calculateRanks(listResults)
        }
    }

    // Overalls don't need additional data to be calculated

    return resultsList
}

/**
 * Private helper function that calculates the partial and accumulated times for a single runner or relay.
 *
 * If a control has no reading time, it's considered an error and subsequential partial times can't be computed until another valid reading appears
 *
 * @param runner runner to be considered for time calculation
 */
private fun calculateTime(runner: ResultIndividual){
    // Check that the results for the given runner are valid
    if(runner.stageResult == null){
        // Skip this runner since it doesn't have results
        return
    }

    // Get the start time for the runner
    val startTime = runner.stageResult.startTime

    // Iterate updating the last visited control
    var previousTime: Instant? = startTime
    var isError = false
    for (control in runner.stageResult.splits) {
        // If the control is not part of the course, we can skip it
        if(control.orderNumber < 1){
            continue
        }

        if(control.readingTime == null){
            isError = true
            previousTime = null
            control.accumulatedError = true
            continue
        }

        // Only if there is a reading time we can calculate the accumulated time and the partial time

        // Calculate accumulated time from the start time. It can always be calculated despite having previous controls not punched
        control.accumulated = control.readingTime.minus(startTime)

        // Calculate partial time from the reading time of the previous control
        if (previousTime != null) {
            // If there's a reading time for the last control, we can safely calculate the partial for this one
            control.partial = control.readingTime.minus(previousTime)
        }

        // Propagate the error into the future controls
        if(isError){
            control.accumulatedError = true
        }

        // Update the previous time to the readingTime of this control, whether it's null or not
        previousTime = control.readingTime
    }
}

/**
 * Private function to calculate the partial and accumulated time to a list of individual runners
 * @param results List of ResultIndividual from the same class
 * @return Map that stores the list of splits for every runner associated to their control number for calculating the splits rankings
 */
private fun calculateIndividualTimes(results: List<ResultIndividual>): Map<Long, List<SplitIndividual>> {
    for (runner in results) {
        calculateTime(runner)
    }

    // After processing the splits, we can group the splits from the different runners by order number
    val listResults = results
        .mapNotNull { it.stageResult}
        .flatMap { it.splits }
        .filter { it.orderNumber > 0 }
        .groupBy { it.orderNumber }

    return listResults
}


/**
 * Private function to calculate the time difference and positions for both partial and accumulated times.
 *
 * The partial classification can be calculated for every control that has a partial. However, accumulated classifications can only be calculated when no error has happened in the past
 *
 */
private fun calculateRanks(listResults: Map<Long, List<SplitIndividual>>) {
    // Iterate over each control in the map
    for (controlList in listResults.values) {
        // Filter out controls with no partial and sort them by partial
        val filteredPartial = controlList.filter{ it.partial != null}.sortedBy { it.partial }

        // Get the best partial if exists
        if(filteredPartial.isNotEmpty()){
            val bestPartialControl = filteredPartial.first()
            val bestPartialTime = requireNotNull(bestPartialControl.partial)          // The best partial will never be null

            // Fill out partial information for first result
            bestPartialControl.partialDifference = Duration.ZERO
            bestPartialControl.partialPosition = 1

            for(i in 1 until filteredPartial.size){
                filteredPartial[i].partialDifference = filteredPartial[i].partial!!.minus(bestPartialTime)       // The partial can't be null since those values are filtered
                filteredPartial[i].partialPosition = i + 1L
            }
        }

        // Filter out controls with no accumulated and sort them by accumulated
        val filteredAccumulated = controlList.filter{ it.accumulated != null}.filter { !it.accumulatedError }.sortedBy { it.accumulated }

        // Get the best accumulated time if exists
        if(filteredAccumulated.isNotEmpty()){
            val bestAccumulatedControl = filteredAccumulated.first()
            val bestAccumulatedTime = requireNotNull(bestAccumulatedControl.accumulated)     // The best accumulated will never be null

            // Fill out partial information for first result
            bestAccumulatedControl.accumulatedDifference = Duration.ZERO
            bestAccumulatedControl.accumulatedPosition = 1

            for(i in 1 until filteredAccumulated.size){
                filteredAccumulated[i].accumulatedDifference = filteredAccumulated[i].accumulated!!.minus(bestAccumulatedTime)       // The partial can't be null since those values are filtered
                filteredAccumulated[i].accumulatedPosition = i + 1L
            }
        }
    }
}

/**
 * Private function to map the overall result of a runner
 * @param remoteOverallResult Overall Result from the API
 * @return Overall domain model object
 */
private fun getOverallResult(remoteOverallResult: RemoteOverallResult): Overall {
    return Overall(
        overallParts = getOverallParts(remoteOverallResult.parts),
        overallTotal = getOverall(remoteOverallResult.overall)
    )
}

/**
 * Private function to map the list of parts that make up an overall result
 * @param remoteOverallList list of Remote Overall object gotten from the API
 * @return List of Overall Result parts as domain model objects
 */
private fun getOverallParts(remoteOverallList: List<RemoteOverall>): List<OverallResult> {
    return remoteOverallList.map(::getOverall)
}

/**
 * Private function to map a single Remote Overall into the domain model
 * @param remoteOverall remote object gotten from the API
 * @return Overall Result parse to a domain model object
 */
private fun getOverall(remoteOverall: RemoteOverall): OverallResult {
    return OverallResult(
        id = remoteOverall.id,
        stageOrder = remoteOverall.stageOrder,
        uploadType = remoteOverall.uploadType,
        stage = remoteOverall.stage?.id,             // Stages can be uniquely identified by id, so no description is needed
        position = remoteOverall.position,
        statusCode = remoteOverall.statusCode,
        isNc = remoteOverall.isNc,
        contributory = remoteOverall.contributory,
        timeSeconds = getDuration(remoteOverall.timeSeconds),
        timeBehind = remoteOverall.timeBehind?.let(::getDuration),
        pointsFinal = remoteOverall.pointsFinal,
        pointsBehind = remoteOverall.pointsBehind,
        note = remoteOverall.note

    )
}

/**
 * Function to parse the results for a same class, when the results are from a TEAM
 * @param remoteResultsResponse response from the API containing the results for the class
 * @return list of domain model objects containing all teams, with additional information added to the splits (if available)
 */
fun getTeamResults(remoteResultsResponse: RemoteResultsResponse): List<ResultTeam> {
    val results = remoteResultsResponse.results
    val resultsList = results.map(::getTeamResult)

    // Each team results has a field of splits and overall, but these are never use so they will be NULL
    // TODO - Check if these fields can take any different values for other situations and integrate them here

    // For each team runner, there might be splits data from which to calculate its partial and accumulated time

    // If there are splits available, calculate the additional data
    if (resultsList.any { it.stageResult != null }) {
        // For each control, we must calculate the partial time and accumulated time
        calculateRelayTimes(resultsList)

        // There is no need to calculate a rank since it's a relay event and the data can't be directly compared
    }

    // Overalls don't need additional data to be calculated

    return resultsList
}

/**
 * Private helper function that calculates the individual partial and accumulated times for each runner in a team
 * @param results List of Teams from a same class
 */
private fun calculateRelayTimes(results: List<ResultTeam>) {
    // TODO - Check what's incomplete from the API. Will relay time behind be added or do I need to calculate it here?
    for (team in results) {
        for (runner in team.runners) {
            calculateTime(runner)
        }
    }
}

/**
 * Private function to map a remote result from a team
 * @param remoteResult remote team object from the API
 * @return domain model object containing the team data
 */
private fun getTeamResult(remoteResult: RemoteResult): ResultTeam {
    return ResultTeam(
        id = remoteResult.id,
        bibNumber = remoteResult.bibNumber,
        isNc = remoteResult.isNc,
        eligibility = remoteResult.eligibility,
        legs = requireNotNull(remoteResult.legs) {"Team results must all specify the number of legs"},
        runners =  getTeamRunners(requireNotNull(remoteResult.runners) {"Team results must all have a list of runners that make up the team"}),
        created = getInstant(remoteResult.created),
        fullName = remoteResult.fullName,
        teamClass =     remoteResult.runnerClass?.let(::getResultClass),
        teamClub =      remoteResult.runnerClub?.let(::getClub),
        stageResult =   remoteResult.stageResult?.let(::getStageResult),
        overallResult = remoteResult.overalls?.let(::getOverallResult)
    )
}

/**
 * Private function to map the list of runners of a team
 * @param runnerList list of runners from the API
 * @return list of ResultIndividual
 */
private fun getTeamRunners(runnerList: List<RemoteResult>): List<ResultIndividual> {
    return runnerList.map(::getIndividualResult)
}