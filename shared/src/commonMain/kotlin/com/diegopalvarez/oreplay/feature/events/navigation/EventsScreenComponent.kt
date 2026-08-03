package com.diegopalvarez.oreplay.feature.events.navigation

import androidx.compose.material3.rememberSearchBarState
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.core.language.LanguageManager
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.feature.events.screens.futureEvents.FutureEventsComponent
import com.diegopalvarez.oreplay.feature.events.screens.liveEvents.LiveEventsComponent
import com.diegopalvarez.oreplay.feature.events.screens.pastEvents.PastEventsComponent
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

class EventsScreenComponent(
    componentContext: ComponentContext,
    private val onNavigateToEventStagesScreen: (Event) -> Unit,
    private val languageManager: LanguageManager
): ComponentContext by componentContext {

    /**
     * Common Component Functionality for the Events Screen (as a whole, not per event type)
     */
    private val _searchResults = MutableValue(mutableListOf<Event>())
    val searchResults: Value<List<Event>> = _searchResults

    fun getCurrentLanguage(): String? {
        println("Current Language: ${languageManager.languageCode.value}")
        return languageManager.languageCode.value
    }

    // Date Picker Modal State and Results
    private val _showDatePicker = MutableValue(false)
    val showDatePicker: Value<Boolean> = _showDatePicker

    private val _selectedDateRange = MutableValue(Pair<Long?, Long?>(null, null))
    val selectedDateRange: Value<Pair<Long?, Long?>> = _selectedDateRange

    fun showDatePicker(boolean: Boolean){
        _showDatePicker.value = boolean
    }

    fun setSelectedDate(date: Pair<Long?, Long?>){
        _selectedDateRange.value = date
    }

    /**
     * Auxiliary functions for Event Handling and Navigation
     */
    // Event Handler Function
    fun onEvent(event: EventScreenEvent) {
        when (event) {
            is EventScreenEvent.ClickEvent -> onNavigateToEventStagesScreen(event.selectedEvent)
            is EventScreenEvent.SearchEvent -> {
                // TODO - Search function
            }
            is EventScreenEvent.ChangeLanguage -> languageManager.switchLanguage(event.languageCode)
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