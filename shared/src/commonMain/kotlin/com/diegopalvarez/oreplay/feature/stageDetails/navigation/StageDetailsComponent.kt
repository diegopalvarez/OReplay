package com.diegopalvarez.oreplay.feature.stageDetails.navigation

import com.arkivanov.decompose.ComponentContext
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub

class StageDetailsComponent(
    componentContext: ComponentContext,
    private val onNavigateToClassResultsScreen: (StageClass) -> Unit,
    private val onNavigateToClubResultsScreen: (StageClub) -> Unit,
    private val onGoBack: () -> Unit
): ComponentContext by componentContext {

    // Event Handler Function
    fun onEvent(event: StageDetailsEvent) {
        when (event) {
            is StageDetailsEvent.ClickClass -> onNavigateToClassResultsScreen(event.selectedClass)
            is StageDetailsEvent.ClickClub -> onNavigateToClubResultsScreen(event.selectedClub)
            StageDetailsEvent.GoBack -> onGoBack()
        }
    }
}