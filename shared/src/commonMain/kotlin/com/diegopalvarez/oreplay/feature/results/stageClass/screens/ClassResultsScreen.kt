package com.diegopalvarez.oreplay.feature.results.stageClass.screens

import androidx.compose.runtime.Composable
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.feature.results.common.components.ResultsScaffold
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsComponent
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsEvent

@Composable
fun ClassResultsScreen(
    pageEvent: Event,
    stage: Stage,
    stageClass: StageClass,
    component: ClassResultsComponent
) {
    ResultsScaffold(
        event = pageEvent,
        stage = stage,
        tabName = stageClass.longName,
        navigationAction = {
            component.onEvent(ClassResultsEvent.GoBack)
        },
        component = component,
    )
}