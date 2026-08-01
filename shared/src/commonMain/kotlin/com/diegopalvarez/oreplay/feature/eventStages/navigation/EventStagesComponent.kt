package com.diegopalvarez.oreplay.feature.eventStages.navigation

import com.arkivanov.decompose.ComponentContext
import com.diegopalvarez.oreplay.domain.model.Stage

class EventStagesComponent(
    componentContext: ComponentContext,
    private val onNavigateToStageDetailsScreen: (Stage) -> Unit,
    private val onGoBack: () -> Unit
): ComponentContext by componentContext {

    // Event Handler Function
    fun onEvent(event: EventStagesEvent) {
        when (event) {
            is EventStagesEvent.ClickStage -> onNavigateToStageDetailsScreen(event.selectedStage)
            EventStagesEvent.GoBack -> onGoBack()
        }
    }
}