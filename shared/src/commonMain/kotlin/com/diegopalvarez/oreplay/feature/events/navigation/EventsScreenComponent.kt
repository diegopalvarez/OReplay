package com.diegopalvarez.oreplay.feature.events.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.core.language.LanguageManager
import com.diegopalvarez.oreplay.core.util.Result
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.repository.EventRepository
import com.diegopalvarez.oreplay.feature.events.screens.futureEvents.FutureEventsComponent
import com.diegopalvarez.oreplay.feature.events.screens.liveEvents.LiveEventsComponent
import com.diegopalvarez.oreplay.feature.events.screens.pastEvents.PastEventsComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.collections.emptyList
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Instant

class EventsScreenComponent(
    componentContext: ComponentContext,
    private val eventRepository: EventRepository,
    private val onNavigateToEventStagesScreen: (Event) -> Unit,
    private val languageManager: LanguageManager
): ComponentContext by componentContext {

    /**
     * Common Component Functionality for the Events Screen (as a whole, not per event type)
     */
    fun getCurrentLanguage(): String? {
        println("Current Language: ${languageManager.languageCode.value}")
        return languageManager.languageCode.value
    }

    // Date Picker Modal State and Results
    private val _showDatePicker = MutableValue(false)
    val showDatePicker: Value<Boolean> = _showDatePicker

    private val _selectedDateRange = MutableStateFlow(Pair<Long?, Long?>(null, null))
    val selectedDateRange = _selectedDateRange.asStateFlow()

    fun showDatePicker(boolean: Boolean){
        _showDatePicker.value = boolean
    }

    fun setSelectedDate(date: Pair<Long?, Long?>){
        _selectedDateRange.value = date
    }

    // Set up Coroutine Scope
    val scope = CoroutineScope(Dispatchers.Default)

    // Event Search functionality
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    // Searching Spinner State
    private val _isSearching = MutableValue(false)
    val isSearching: Value<Boolean> = _isSearching

    // Combine the query and the Date Range and then execute the query
    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    val searchResults = combine(
        searchQuery,
        selectedDateRange
    ){ query, selectedDateRange ->
        query to selectedDateRange
    }
        .debounce(300.milliseconds)      // Waits 300ms after the last key type to search
        .flatMapLatest { (query, selectedDateRange) ->
            if(query.isEmpty() && selectedDateRange.first == null && selectedDateRange.second == null) {
                flowOf(null)
            }
            else {
                _isSearching.value = true
                val searchResults = eventRepository.searchEvents(query, parseDate(selectedDateRange.first), parseDate(selectedDateRange.second))
                println("SEARCH RESULTS: $searchResults")
                when(searchResults){
                    is Result.Error -> {
                        _isSearching.value = false
                        flowOf<List<Event>>(emptyList())
                    }
                    is Result.Success -> {
                        _isSearching.value = false
                        flowOf<List<Event>>(searchResults.data)
                    }
                }
            }
        }
    .stateIn(
        scope = scope,
        started = SharingStarted.WhileSubscribed(500L),
        initialValue = null
    )

    fun onQueryChange(newQuery: String){
        println("QUERY: $newQuery")
        _searchQuery.value = newQuery
    }

    fun clearQuery(){
        _searchQuery.value = ""
    }

    // Function to parse from Long to LocalDate
    fun parseDate(date: Long?): LocalDate? {
        return if(date != null){
            Instant.fromEpochMilliseconds(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        } else {
            null
        }
    }

    /**
     * Auxiliary functions for Event Handling and Navigation
     */
    // Event Handler Function
    fun onEvent(event: EventScreenEvent) {
        when (event) {
            is EventScreenEvent.ClickEvent -> onNavigateToEventStagesScreen(event.selectedEvent)
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
                    componentContext = component,
                    repository = eventRepository
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