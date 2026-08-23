package com.diegopalvarez.oreplay.feature.results.common.components

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.legs.ResultsLegScreen
import com.diegopalvarez.oreplay.feature.results.common.types.points.ResultsPointsScreen
import com.diegopalvarez.oreplay.feature.results.common.types.results.ResultsMainScreen
import com.diegopalvarez.oreplay.feature.results.common.types.splits.ResultsSplitsScreen
import com.diegopalvarez.oreplay.feature.results.common.types.startTimes.ResultsStartTimesScreen
import com.diegopalvarez.oreplay.feature.results.common.types.statistics.ResultsStatisticsScreen
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsComponent

@Composable
fun ResultsTabContent(
    component: AbstractResultsComponent
) {
    // Subscribe to the Selected Tab
    val pages = component.pages.subscribeAsState()

    // Every one of the pages inside the pull to refresh box must be a LazyColumn or have any type of vertical scroll

    when(val child = pages.value.items[pages.value.selectedIndex].instance){
        is AbstractResultsComponent.ResultsTabChild.Legs -> ResultsLegScreen(child.component)
        is AbstractResultsComponent.ResultsTabChild.Results -> ResultsMainScreen(child.component)
        is AbstractResultsComponent.ResultsTabChild.Splits -> {
            if(component is ClassResultsComponent){
                ResultsSplitsScreen(child.component)
            }
            else{
                ResultsSplitsScreen(child.component)
            }

        }
        is AbstractResultsComponent.ResultsTabChild.StartTimes -> ResultsStartTimesScreen(child.component)
        is AbstractResultsComponent.ResultsTabChild.Statistics -> ResultsStatisticsScreen(child.component)
        is AbstractResultsComponent.ResultsTabChild.Points -> ResultsPointsScreen(child.component)
        null -> TODO("This shouldn't be a possibility")
    }
}