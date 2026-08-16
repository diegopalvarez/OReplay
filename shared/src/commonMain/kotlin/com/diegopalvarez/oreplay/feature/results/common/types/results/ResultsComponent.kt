package com.diegopalvarez.oreplay.feature.results.common.types.results

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Result
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.types.StageType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.isActive
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.Duration.Companion.seconds
import kotlin.time.Instant

class ResultsComponent(
    componentContext: ComponentContext,
    val results: Value<List<Result>>,
    private val event: Event,
    private val stage: Stage,
    private val stageType: StageType,
    private val isClubView: Boolean
): ComponentContext by componentContext {
    // Create a coroutine scope
    val scope = CoroutineScope(Dispatchers.Main)

    // Function to get the stage type
    fun getStageType(): StageType {
        return stageType
    }

    // Function to get if the event is live or not
    fun isLive(): Boolean {
        return if(stage.start == null){
            false
        } else{
            stage.start.toLocalDateTime(event.timezone).date == Clock.System.now().toLocalDateTime(event.timezone).date
        }
    }

    // Function to get if the results are for a club or a class view
    fun isClubView(): Boolean {
        return isClubView
    }

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
}