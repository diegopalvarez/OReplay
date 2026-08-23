package com.diegopalvarez.oreplay.feature.results.stageClass.navigation

import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.SplitIndividual
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClass
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
import kotlinx.coroutines.launch
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_split
import org.jetbrains.compose.resources.getString

class ClassResultsComponent(
    componentContext: ComponentContext,
    val pageEvent: Event,
    val stage: Stage,
    val stageClass: StageClass,
    private val repository: ClassResultsRepository,
    private val onGoBack: () -> Unit
): AbstractResultsComponent(
    componentContext = componentContext,
    onGoBack = onGoBack,
    event = pageEvent,
    stage = stage,
    isClubResults = false
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

                // Get the widest string from the results
                getWidestString()

                _isInit.value = true
            }
            .onError {
                _isError.value = true
                _errorType.value = it
            }

    }

    /**
     * Init function
     */
    init {
        scope.launch {
            fetchResults()
        }
    }

    /**
     * Reload function
     */
    override fun reloadResults(){
        scope.launch {
            _isRefreshing.value = true // TODO - Check and standardize where the loading state is updated
            fetchResults()
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