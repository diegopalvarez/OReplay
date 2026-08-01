package com.diegopalvarez.oreplay.feature.events.navigation

import com.arkivanov.decompose.ComponentContext
import com.diegopalvarez.oreplay.domain.model.Event

class EventsScreenComponent(
    componentContext: ComponentContext,
    private val onNavigateToEventStagesScreen: (Event) -> Unit
): ComponentContext by componentContext {

    // Event Handler Function
    fun onEvent(event: EventScreenEvent) {
        when (event) {
            is EventScreenEvent.ClickEvent -> onNavigateToEventStagesScreen(event.selectedEvent)
        }
    }
}