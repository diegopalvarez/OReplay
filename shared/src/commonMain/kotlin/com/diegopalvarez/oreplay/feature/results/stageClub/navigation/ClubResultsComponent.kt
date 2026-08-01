package com.diegopalvarez.oreplay.feature.results.stageClub.navigation

import com.arkivanov.decompose.ComponentContext
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsEvent

class ClubResultsComponent(
    componentContext: ComponentContext,
    private val onGoBack: () -> Unit
): ComponentContext by componentContext {

    // Event Handler Function
    fun onEvent(event: ClubResultsEvent) {
        when (event) {
            ClubResultsEvent.GoBack -> onGoBack()
        }
    }
}