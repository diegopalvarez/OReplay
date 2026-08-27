package com.diegopalvarez.oreplay.feature.stageDetails.components

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.stageDetails.navigation.StageDetailsComponent
import com.diegopalvarez.oreplay.feature.stageDetails.screens.classes.StageClassesScreen
import com.diegopalvarez.oreplay.feature.stageDetails.screens.clubs.StageClubsScreen

@Composable
fun StageDetailsContent(
    component: StageDetailsComponent,
)
{
    // Subscribe to the Selected Tab
    val pages = component.pages.subscribeAsState()

    // TODO - Handle the back button behavior

    when(val child = pages.value.items[pages.value.selectedIndex].instance) {
        is StageDetailsComponent.StageDetailsTabChild.StageClasses -> StageClassesScreen(child.component)
        is StageDetailsComponent.StageDetailsTabChild.StageClubs -> StageClubsScreen(child.component)
        null -> TODO()
    }
}