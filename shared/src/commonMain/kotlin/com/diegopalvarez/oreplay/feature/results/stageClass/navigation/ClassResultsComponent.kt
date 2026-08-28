package com.diegopalvarez.oreplay.feature.results.stageClass.navigation

import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.doOnDestroy
import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.SplitIndividual
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.domain.repository.ClassResultsRepository
import com.diegopalvarez.oreplay.domain.repository.type.ClassicRepositoryResult
import com.diegopalvarez.oreplay.domain.repository.type.OneManRelayRepositoryResult
import com.diegopalvarez.oreplay.domain.repository.type.OverallRepositoryResult
import com.diegopalvarez.oreplay.domain.repository.type.RelayRepositoryResult
import com.diegopalvarez.oreplay.domain.repository.type.ScoreRepositoryResult
import com.diegopalvarez.oreplay.domain.types.StageType
import com.diegopalvarez.oreplay.domain.types.getStageType
import com.diegopalvarez.oreplay.feature.eventStages.navigation.EventStagesEvent
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import com.diegopalvarez.oreplay.feature.results.common.util.Optional
import com.diegopalvarez.oreplay.ui.util.display
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_split
import org.jetbrains.compose.resources.getString
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

class ClassResultsComponent(
    componentContext: ComponentContext,
    val pageEvent: Event,
    val stage: Stage,
    val stageClass: StageClass,
    private val repository: ClassResultsRepository,
    private val preferences: PreferencesManager,
    private val onGoBack: () -> Unit,
    private val onGoToClub: (Event, Stage, StageClub) -> Unit
): AbstractResultsComponent(
    componentContext = componentContext,
    onGoBack = onGoBack,
    event = pageEvent,
    stage = stage,
    isClubResults = false,
    preferencesManager = preferences
) {
    /**
     * Result Functionality
     */
    private val scope = CoroutineScope(Dispatchers.Default)

    override suspend fun fetchResults(){
        repository.getClassResults(
            eventID = pageEvent.id,
            stageID = stage.id,
            classID = stageClass.id,
            stageType = stage.stageType.getStageType()
        )
            .onSuccess {
                _isError.value = false
                _results.value = it.result

                // If the results are Score, also fetch the additional information
                if(stage.stageType.getStageType() == StageType.SCORE){
                    _visitedScoreControls.value = Optional.Some((it as ScoreRepositoryResult).visitedControls)
                }
                else if(stage.stageType.getStageType() == StageType.RELAY){
                    _numberOfLegs.value = Optional.Some((it as RelayRepositoryResult).numberOfLegs)
                }

                // Get the widest string from the results
                getWidestString()

                _isInit.value = true
            }
            .onError {
                _isError.value = true
                _errorType.value = it

                // In case of error, also reset the optional values for these types of events
                if(stage.stageType.getStageType() == StageType.SCORE){
                    _visitedScoreControls.value = Optional.None
                }
                else if(stage.stageType.getStageType() == StageType.RELAY){
                    _numberOfLegs.value = Optional.None
                }
            }

    }

    /**
     * Init function
     */
    init {
        // Set up scope cancellation if the component is destroyed
        componentContext.lifecycle.doOnDestroy {
            scope.cancel()
        }

        scope.launch {
            getResults()

            // If the event is live, set up the automatic reload timer
            if(isLive.value){
                while(isActive){
                    delay(reloadInterval.value?.seconds ?: 1.minutes)       // If it's null, defaults to 1 minute
                    getResults()
                    println("AUTOMATIC RELOAD")
                }
            }
        }
    }

    /**
     * Reload function
     */
    override fun reloadResults(){
        scope.launch {
            _isRefreshing.value = true // TODO - Check and standardize where the loading state is updated
            getResults()
            _isRefreshing.value = false
        }
    }

    /**
     * Event Handling
     */
    fun onEvent(event: ClassResultsEvent) {
        when(event) {
            ClassResultsEvent.GoBack -> {
                onGoBack()
            }

            is ClassResultsEvent.GoToClub -> {
                onGoToClub(pageEvent, stage, event.stageClub)
            }
        }
    }

    /**
     * Function to measure the column widths
     */
    // TODO - Parallelize this calculation
    fun getWidestString() {
        if(results.value.all { it is ResultIndividual }){
            val individualResults = results.value.filterIsInstance<ResultIndividual>()      // TODO - Use this better way of casting across all the code

            scope.launch {
                val noSplit = getString(Res.string.no_split)


                val widest = individualResults
                    .asSequence()
                    .flatMap { runner ->
                        runner.stageResult
                            ?.splits
                            ?.asSequence()
                            ?: emptySequence()
                    }
                    .map { split ->
                        getWidestSplitText(split, noSplit)
                    }
                    .maxByOrNull { it.length }

                if(widest != null){
                    _widestString.value = widest
                }
            }

        }

    }

    private fun getWidestSplitText(
        control: SplitIndividual,
        noSplit: String
    ): String {
        val candidates = buildList {
            control.partial?.let { total ->
                add(total.display())

                control.partialDifference?.let { difference ->
                    add(
                        buildString {
                            append("+")
                            append(difference.display())

                            control.partialPosition?.let {
                                append(" ($it)")
                            }
                        }
                    )
                } ?: add(noSplit)
            } ?: add(noSplit)

            control.accumulated?.let { total ->
                add(total.display())

                control.accumulatedDifference?.let { difference ->
                    add(
                        buildString {
                            append("+")
                            append(difference.display())

                            control.accumulatedPosition?.let {
                                append(" ($it)")
                            }
                        }
                    )
                } ?: add(noSplit)
            } ?: add(noSplit)
        }

        return candidates.maxBy { it.length }
    }
}