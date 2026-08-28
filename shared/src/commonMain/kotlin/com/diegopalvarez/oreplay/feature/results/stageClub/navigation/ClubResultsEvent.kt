package com.diegopalvarez.oreplay.feature.results.stageClub.navigation

import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClass

// A Sealed Interface is an interface whose direct implementations are known at compile time
sealed interface ClubResultsEvent {
    data object GoBack: ClubResultsEvent

    data class GoToClass(val stageClass: StageClass): ClubResultsEvent
}