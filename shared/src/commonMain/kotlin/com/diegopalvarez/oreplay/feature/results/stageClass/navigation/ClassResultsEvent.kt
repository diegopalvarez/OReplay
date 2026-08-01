package com.diegopalvarez.oreplay.feature.results.stageClass.navigation

import com.diegopalvarez.oreplay.domain.model.Stage

// A Sealed Interface is an interface whose direct implementations are known at compile time
sealed interface ClassResultsEvent {
    data object GoBack: ClassResultsEvent
}