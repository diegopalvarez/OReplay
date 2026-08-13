package com.diegopalvarez.oreplay.feature.results.stageClub.navigation

import com.arkivanov.decompose.ComponentContext
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsEvent

class ClubResultsComponent(
    componentContext: ComponentContext,
    val pageEvent: Event,
    val stage: Stage,
    val stageClub: StageClub,
    private val onGoBack: () -> Unit
): AbstractResultsComponent(
    componentContext = componentContext,
    onGoBack = onGoBack,
    event = pageEvent,
    stage = stage,
    isClubResults = true
) {

}