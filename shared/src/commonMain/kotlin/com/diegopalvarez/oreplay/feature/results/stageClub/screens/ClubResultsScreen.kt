package com.diegopalvarez.oreplay.feature.results.stageClub.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.feature.results.common.components.ResultsScaffold
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsEvent
import com.diegopalvarez.oreplay.feature.results.stageClub.navigation.ClubResultsComponent
import com.diegopalvarez.oreplay.feature.results.stageClub.navigation.ClubResultsEvent

@Composable
fun ClubResultsScreen(
    pageEvent: Event,
    stage: Stage,
    stageClubName: String,
    component: ClubResultsComponent,
    expandedScreen: MutableState<Boolean>
) {
    ResultsScaffold(
        event = pageEvent,
        stage = stage,
        tabName = stageClubName,
        navigationAction = {
            component.onEvent(ClubResultsEvent.GoBack)
        },
        component = component,
        expandedScreen = expandedScreen,
    )
}