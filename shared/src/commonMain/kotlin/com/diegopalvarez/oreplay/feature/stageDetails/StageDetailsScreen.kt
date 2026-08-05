package com.diegopalvarez.oreplay.feature.stageDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.feature.stageDetails.components.StageDetailsContent
import com.diegopalvarez.oreplay.feature.stageDetails.components.StageDetailsTabRow
import com.diegopalvarez.oreplay.feature.stageDetails.navigation.StageDetailsComponent
import com.diegopalvarez.oreplay.feature.stageDetails.navigation.StageDetailsEvent
import com.diegopalvarez.oreplay.ui.components.TitlePageBarWithSearch

@Composable
fun StageDetailsScreen(
    event: Event,
    stage: Stage,
    component: StageDetailsComponent
) {
    // Create the scrollBehavior for the Page Bar
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    // Create the Scaffold for the content
    Scaffold(
        topBar = {
            TitlePageBarWithSearch(
                title = stage.description,
                subtitle = event.description,
                navigationAction = {
                    component.onEvent(StageDetailsEvent.GoBack)
                },
                scrollBehavior = scrollBehavior,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()

        ) {
            // Tab Row to select between Classes and Clubs
            StageDetailsTabRow(component)

            // Actual Lists depending on which tab is selected
            StageDetailsContent(
                component = component,
            )
        }

    }

}