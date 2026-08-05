package com.diegopalvarez.oreplay.feature.eventStages.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.repository.StageRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventStagesComponent(
    componentContext: ComponentContext,
    private val repository: StageRepository,
    val pageEvent: Event,
    private val onNavigateToStageDetailsScreen: (Stage) -> Unit,
    private val onSkipToStageDetailsScreen: (Stage) -> Unit,
    private val onGoBack: () -> Unit
): ComponentContext by componentContext {
    // Create and store coroutine scope
    val scope = CoroutineScope(Dispatchers.Default)

    // Variable to store the list of stages for the event
    private val _stagesList = MutableValue(emptyList<Stage>())
    val stagesList: Value<List<Stage>> = _stagesList

    // Variable to store if the stages have been loaded
    private val _isLoaded = MutableValue(false)
    val isLoaded: Value<Boolean> = _isLoaded

    // Variable to signal if an error happened
    private val _isError = MutableValue(false)
    val isError: Value<Boolean> = _isError

    // Variable to store the error type
    private val _errorType = MutableValue(RepositoryError.UNKNOWN)
    val errorType: Value<RepositoryError> = _errorType

    // Init Function
    init {
        scope.launch {
            fetchEventStages()
            _isLoaded.value = true
        }
    }

    // Function to fetch the Event Stages
    private suspend fun fetchEventStages() {
        repository.getEventStages(pageEvent.id)
            .onSuccess {
                _isError.value = false
                _stagesList.value = it

                // Check if there's more than one stage
                if(it.size == 1){
                    // Navigate directly to the only stage
                    onEvent(EventStagesEvent.ClickStage(it.first()))
                }
                else{
                    // Signal that it's loaded
                    _isLoaded.value = true
                }
            }
            .onError {
                _isError.value = true
                _errorType.value = it
            }
    }

    /**
     * Navigation functions
     */

    // Event Handler Function
    fun onEvent(event: EventStagesEvent) {
        when (event) {
            is EventStagesEvent.ClickStage -> onNavigateToStageDetailsScreen(event.selectedStage)
            is EventStagesEvent.SkipToStage -> onSkipToStageDetailsScreen(event.selectedStage)
            EventStagesEvent.GoBack -> onGoBack()
        }
    }
}