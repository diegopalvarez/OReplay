package com.diegopalvarez.oreplay.feature.results.common.types.legs.components

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.results.common.types.legs.LegResultScreen
import com.diegopalvarez.oreplay.feature.results.common.types.legs.LegsComponent
import com.diegopalvarez.oreplay.feature.stageDetails.navigation.StageDetailsComponent
import com.diegopalvarez.oreplay.feature.stageDetails.screens.classes.StageClassesScreen
import com.diegopalvarez.oreplay.feature.stageDetails.screens.clubs.StageClubsScreen
import com.diegopalvarez.oreplay.ui.components.NoDataScreen

@Composable
fun LegsContent(
    component: LegsComponent
) {
    // Subscribe to the selected tab
    val pages = component.pages.subscribeAsState()

    if(pages.value.items.isNotEmpty()) {
        when(val child = pages.value.items[pages.value.selectedIndex].instance) {
            is LegsComponent.LegsTabChild.Leg -> LegResultScreen(child.component)
            null -> TODO()
        }
    }
    else{
        NoDataScreen()
    }

}