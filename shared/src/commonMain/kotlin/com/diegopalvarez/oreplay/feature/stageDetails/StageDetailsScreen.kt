package com.diegopalvarez.oreplay.feature.stageDetails

import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.feature.stageDetails.navigation.StageDetailsComponent
import com.diegopalvarez.oreplay.feature.stageDetails.navigation.StageDetailsEvent
import com.diegopalvarez.oreplay.ui.components.TitlePageBarWithSearch

@Composable
fun StageDetailsScreen(
    stage: Stage,
    component: StageDetailsComponent
) {
    // Create the scrollBehavior for the Page Bar
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    TitlePageBarWithSearch(
        text = stage.description,
        navigationAction = {
            component.onEvent(StageDetailsEvent.GoBack)
        },
        scrollBehavior = scrollBehavior,
    )
}