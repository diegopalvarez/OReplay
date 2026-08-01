package com.diegopalvarez.oreplay.feature.eventStages.navigation

import com.diegopalvarez.oreplay.domain.model.Stage

// A Sealed Interface is an interface whose direct implementations are known at compile time
sealed interface EventStagesEvent {
    data class ClickStage(val selectedStage: Stage): EventStagesEvent

    data object GoBack: EventStagesEvent
}