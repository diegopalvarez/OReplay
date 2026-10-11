package com.diegopalvarez.oreplay.feature.results.stageClass.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnDestroy
import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.data.remote.api.OReplayAPI
import com.diegopalvarez.oreplay.data.remote.websocket.OReplayWebsocket
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.SplitIndividual
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.domain.repository.ClassResultsRepository
import com.diegopalvarez.oreplay.domain.repository.type.RelayRepositoryResult
import com.diegopalvarez.oreplay.domain.repository.type.ScoreRepositoryResult
import com.diegopalvarez.oreplay.domain.types.StageType
import com.diegopalvarez.oreplay.domain.types.getStageType
import com.diegopalvarez.oreplay.domain.wrappers.ResultHistory
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import com.diegopalvarez.oreplay.feature.results.common.util.Optional
import com.diegopalvarez.oreplay.ui.util.display
import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ClassResultsComponent(
    componentContext: ComponentContext,
    val pageEvent: Event,
    val stage: Stage,
    val stageClass: StageClass,
    private val repository: ClassResultsRepository,
    private val preferences: PreferencesManager,
    private val onGoBack: () -> Unit,
    onGoToClass: (Event, Stage, StageClass) -> Unit,
    onGoToClub: (Event, Stage, StageClub) -> Unit,

    // Stage History
    stageHistory: ResultHistory,
): AbstractResultsComponent(
    componentContext = componentContext,
    onGoBack = onGoBack,
    event = pageEvent,
    stage = stage,
    category = stageClass,
    preferencesManager = preferences,
    stageHistory = stageHistory,
    onGoToClass = onGoToClass,
    onGoToClub = onGoToClub
) {
    /**
     * Result Functionality
     */
    private val scope = CoroutineScope(Dispatchers.Default)

    // Create the websocket
    val websocket = OReplayWebsocket(
        eventID = pageEvent.id,
        stageID = stage.id,
        classID = stageClass.id
    )

    override suspend fun fetchResults(){
        websocket.getResultsStream()
            .onStart {
                // Not needed
            }
            .onEach {
                // Process the results
                repository.processClassResults(
                    classID = stageClass.id,
                    results = it,
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
            .catch { error ->
                // TODO - Handle errors
                println(error)
            }
            .collect()
    }

    /**
     * Init function
     */
    init {
        // Set up scope cancellation if the component is destroyed
        componentContext.lifecycle.doOnDestroy {
            // Close the websocket
            CoroutineScope(Dispatchers.Default).launch {
                try {
                    websocket.close()
                } finally {
                    scope.cancel()
                }
            }
        }

        scope.launch {
            getResults()
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
                // Add the current screen to the history
                updateStageHistory()

                // Delete the current selected tab
                stageHistory.clearCurrentCategory()

                onGoBack()
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

            val widest = individualResults
                .asSequence()
                .flatMap { runner ->
                    runner.stageResult
                        ?.splits
                        ?.asSequence()
                        ?: emptySequence()
                }.maxOfOrNull { split ->
                    getWidestSplitText(split)
                }

            if(widest != null){
                _widestString.value = widest
            }

        }

    }

    private fun getWidestSplitText(
        control: SplitIndividual,
    ): Int {
        val noSplitLength = 2

        val candidates = buildList {
            control.partial?.let { total ->
                add(total.display().length)

                control.partialDifference?.let { difference ->
                    add(
                        buildString {
                            append("+")
                            append(difference.display())

                            control.partialPosition?.let {
                                append(" ($it)")
                            }
                        }.length
                    )
                } ?: add(noSplitLength)
            } ?: add(noSplitLength)

            control.accumulated?.let { total ->
                add(total.display().length)

                control.accumulatedDifference?.let { difference ->
                    add(
                        buildString {
                            append("+")
                            append(difference.display())

                            control.accumulatedPosition?.let {
                                append(" ($it)")
                            }
                        }.length
                    )
                } ?: add(noSplitLength)
            } ?: add(noSplitLength)
        }

        return candidates.max()
    }

    // Function to update the history when navigating away
    override fun updateStageHistory() {
        stageHistory.push(stageClass)
    }
}