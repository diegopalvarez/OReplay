package com.diegopalvarez.oreplay.feature.results.stageClass.navigation

import com.arkivanov.decompose.ComponentContext
import com.diegopalvarez.oreplay.feature.eventStages.navigation.EventStagesEvent

class ClassResultsComponent(
    componentContext: ComponentContext,
    private val onGoBack: () -> Unit
): ComponentContext by componentContext {

    // Event Handler Function
    fun onEvent(event: ClassResultsEvent) {
        when (event) {
            ClassResultsEvent.GoBack -> onGoBack()
        }
    }
}