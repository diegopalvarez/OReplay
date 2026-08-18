package com.diegopalvarez.oreplay.feature.results.stageClass.navigation

import com.arkivanov.decompose.ComponentContext
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.domain.model.Event
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

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
    private val scope = CoroutineScope(Dispatchers.Main)

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
}