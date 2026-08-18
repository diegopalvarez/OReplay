package com.diegopalvarez.oreplay.feature.results.stageClub.navigation

import com.arkivanov.decompose.ComponentContext
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.domain.repository.ClubResultsRepository
import com.diegopalvarez.oreplay.domain.repository.type.ScoreRepositoryResult
import com.diegopalvarez.oreplay.domain.types.StageType
import com.diegopalvarez.oreplay.domain.types.getStageType
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import com.diegopalvarez.oreplay.feature.results.common.util.Optional
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClubResultsComponent(
    componentContext: ComponentContext,
    val pageEvent: Event,
    val stage: Stage,
    val stageClub: StageClub,
    private val repository: ClubResultsRepository,
    private val onGoBack: () -> Unit
): AbstractResultsComponent(
    componentContext = componentContext,
    onGoBack = onGoBack,
    event = pageEvent,
    stage = stage,
    isClubResults = true
) {
    /**
     * Result Functionality
     */
    private val scope = CoroutineScope(Dispatchers.Main)

    override suspend fun fetchResults(){
        repository.getClubResults(
            eventID = pageEvent.id,
            stageID = stage.id,
            clubID = stageClub.id,
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