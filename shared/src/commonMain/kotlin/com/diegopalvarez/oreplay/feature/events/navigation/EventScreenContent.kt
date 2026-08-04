package com.diegopalvarez.oreplay.feature.events.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.events.screens.futureEvents.FutureEventsScreen
import com.diegopalvarez.oreplay.feature.events.screens.liveEvents.LiveEventsScreen
import com.diegopalvarez.oreplay.feature.events.screens.pastEvents.PastEventsScreen

@Composable
fun EventScreenContent(
    component: EventsScreenComponent,
    contentPadding: PaddingValues
) {
    // Subscribe to the Selected Tab
    val pages = component.pages.subscribeAsState()

    // TODO - Handle the back button behavior

    when(val child = pages.value.items[pages.value.selectedIndex].instance) {
        is EventsScreenComponent.EventTabChild.FutureEvents -> FutureEventsScreen(child.component, contentPadding)
        is EventsScreenComponent.EventTabChild.LiveEvents -> LiveEventsScreen(child.component, contentPadding)
        is EventsScreenComponent.EventTabChild.PastEvents -> PastEventsScreen(child.component, contentPadding)
        null -> TODO()
    }
}