package com.diegopalvarez.oreplay.feature.events.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.feature.events.screens.futureEvents.FutureEventsComponent
import com.diegopalvarez.oreplay.feature.events.screens.liveEvents.LiveEventsComponent
import com.diegopalvarez.oreplay.feature.events.screens.pastEvents.PastEventsComponent

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

    // Tab Navigation Functionality
    private val navigation = PagesNavigation<EventTabConfiguration>()

    // TODO - Check if the pages are stored or recreated in every visit
    // TODO - Handle back button in Tabs and Menu

    // Exposed navigation
    val pages = childPages(
        source = navigation,
        serializer = EventTabConfiguration.serializer(),
        initialPages = {
            Pages(
                items = listOf(
                    EventTabConfiguration.PastEvents,
                    EventTabConfiguration.LiveEvents,
                    EventTabConfiguration.FutureEvents
                ),
                selectedIndex = 1       // The main page is the Live Events Tab
            )
        },
        childFactory = ::createChild,
        handleBackButton = true
    )

    // Child Factory Function
    private fun createChild(
        config: EventTabConfiguration,
        component: ComponentContext
    ): EventTabChild {
        return when(config){
            EventTabConfiguration.PastEvents -> EventTabChild.PastEvents(
                PastEventsComponent(
                    componentContext = component
                )
            )
            EventTabConfiguration.LiveEvents -> EventTabChild.LiveEvents(
                LiveEventsComponent(
                    componentContext = component
                )
            )
            EventTabConfiguration.FutureEvents -> EventTabChild.FutureEvents(
                FutureEventsComponent(
                    componentContext = component
                )
            )

        }
    }

    // Sealed class will all the different tabs
    sealed class EventTabChild {
        data class PastEvents(val component: PastEventsComponent) : EventTabChild()
        data class LiveEvents(val component: LiveEventsComponent) : EventTabChild()
        data class FutureEvents(val component: FutureEventsComponent) : EventTabChild()
    }

    // Tab Picker Function
    fun selectTab(index: Int) {
        navigation.select(index)
    }

}