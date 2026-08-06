package com.diegopalvarez.oreplay.feature.stageDetails.components

import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.style.TextOverflow
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.events.navigation.EventTabConfiguration
import com.diegopalvarez.oreplay.feature.stageDetails.navigation.StageDetailsComponent
import com.diegopalvarez.oreplay.feature.stageDetails.navigation.StageDetailsTabConfiguration
import org.jetbrains.compose.resources.stringResource

@Composable
fun StageDetailsTabRow(
    component: StageDetailsComponent
) {
    // Subscribe to the Active Tab
    val pages by component.pages.subscribeAsState()

    PrimaryTabRow(
        selectedTabIndex = pages.selectedIndex,
    ){
        // Create MANUALLY a tab for each page

        // Classes
        Tab(
            selected = pages.selectedIndex == 0,
            onClick = {
                component.selectTab(0)
            },
            text = {
                Text(
                    text = stringResource(StageDetailsTabConfiguration.Classes.title),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        )

        // Clubs
        Tab(
            selected = pages.selectedIndex == 1,
            onClick = {
                component.selectTab(1)
            },
            text = {
                Text(
                    text = stringResource(StageDetailsTabConfiguration.Clubs.title),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        )

    }
}