package com.diegopalvarez.oreplay.feature.stageDetails.navigation

import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub

// A Sealed Interface is an interface whose direct implementations are known at compile time
sealed interface StageDetailsEvent {
    data class ClickClass(val selectedClass: StageClass): StageDetailsEvent
    data class ClickClub(val selectedClub: StageClub): StageDetailsEvent
    data object GoBack: StageDetailsEvent
}