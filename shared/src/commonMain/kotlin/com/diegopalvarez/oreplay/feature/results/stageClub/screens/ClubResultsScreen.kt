package com.diegopalvarez.oreplay.feature.results.stageClub.screens

import androidx.compose.runtime.Composable
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.feature.results.common.components.ResultsScaffold
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsEvent
import com.diegopalvarez.oreplay.feature.results.stageClub.navigation.ClubResultsComponent

@Composable
fun ClubResultsScreen(
    pageEvent: Event,
    stage: Stage,
    stageClub: StageClub,
    component: ClubResultsComponent
) {
    ResultsScaffold(
        event = pageEvent,
        stage = stage,
        tabName = stageClub.shortName,
        navigationAction = {
            component.onEvent(ClassResultsEvent.GoBack)
        },
        component = component,
    )
}