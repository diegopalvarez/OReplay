package com.diegopalvarez.oreplay.feature.results.common.types.legs.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.operator.map
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.RelayLegResult
import com.diegopalvarez.oreplay.domain.model.Result
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.ResultTeam
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.feature.results.common.util.sortIndividualResults
import com.diegopalvarez.oreplay.feature.results.common.util.sortLegResults
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.isActive
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.Duration.Companion.seconds
import kotlin.time.Instant

class LegResultComponent(
    componentContext: ComponentContext,
    val event: Event,
    val stage: Stage,
    val results: Value<List<Result>>,
    val legNumber: Int,
): ComponentContext by componentContext {
    // Create a coroutine scope
    val scope = CoroutineScope(Dispatchers.Default)

    // State to use as an elapsed time ticker
    val now: StateFlow<Instant> = flow {
        while (currentCoroutineContext().isActive) {
            emit(Clock.System.now())
            delay(1.seconds)
        }
    }.stateIn(
        scope = scope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = Clock.System.now()
    )

    // Expose the filtered results for this leg
    val legResults: Value<List<RelayLegResult>> =
        results.map { results ->
            val filteredResults = results
                .filterIsInstance<ResultTeam>()
                .filter { it.runners.size >= legNumber }
                .map { team ->
                    // Create a RelayLegResult for each leg runner in the team
                    RelayLegResult(
                        result = team.runners.first { it.legNumber.toInt() == legNumber },
                        teamName = team.fullName,
                        teamError = if(team.isAccumulatedError[legNumber - 1]) team.stageResult?.statusCode else null,
                        accumulatedPosition = team.teamPositions[legNumber - 1],
                        previousPosition = team.teamPositions.getOrNull(legNumber - 2)
                    )

                }

            // Sort the results
            sortLegResults(
                results = filteredResults,
                now = now.value
            )
        }

    // Function to get if the event is live or not
    fun isLive(): Boolean {
        return if(stage.start == null){
            false
        } else{
            stage.start.toLocalDateTime(event.timezone).date == Clock.System.now().toLocalDateTime(event.timezone).date
        }
    }

}