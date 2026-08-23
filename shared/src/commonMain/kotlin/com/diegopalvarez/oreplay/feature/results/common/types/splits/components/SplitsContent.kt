package com.diegopalvarez.oreplay.feature.results.common.types.splits.components

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.results.common.types.splits.navigation.SplitsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.accumulated.AccumulatedSplitsScreen
import com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.partials.PartialSplitsScreen

@Composable
fun SplitsContent(
    component: SplitsComponent
) {
    // Subscribe to the selected tab
    val pages = component.pages.subscribeAsState()

    // TODO - Handle the back button behavior

    when(val child = pages.value.items[pages.value.selectedIndex].instance) {
        is SplitsComponent.SplitsTabChild.Partials -> PartialSplitsScreen(component)
        is SplitsComponent.SplitsTabChild.Accumulated -> AccumulatedSplitsScreen(component)
        null -> TODO()
    }
}