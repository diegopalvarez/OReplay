package com.diegopalvarez.oreplay.feature.stageResults.navigation

sealed interface StagePanelsEvent {
    data object GoBack: StagePanelsEvent
    data object CloseDetailsPanel: StagePanelsEvent
}