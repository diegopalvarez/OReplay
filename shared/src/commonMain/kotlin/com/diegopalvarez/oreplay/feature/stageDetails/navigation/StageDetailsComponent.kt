package com.diegopalvarez.oreplay.feature.stageDetails.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.decompose.router.children.ChildNavState.Status
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackCallback
import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.core.util.Result
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.domain.repository.StageRepository
import com.diegopalvarez.oreplay.feature.stageDetails.common.SearchResultWrapper
import com.diegopalvarez.oreplay.feature.stageDetails.screens.classes.StageClassesComponent
import com.diegopalvarez.oreplay.feature.stageDetails.screens.clubs.StageClubsComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlin.time.Duration.Companion.milliseconds

class StageDetailsComponent(
    componentContext: ComponentContext,
    val stage: Stage,
    val pageEvent: Event,
    private val repository: StageRepository,
    private val onNavigateToClassResultsScreen: (Event, Stage, StageClass, List<StageClass>, List<StageClub>) -> Unit,
    private val onNavigateToClubResultsScreen: (Event, Stage, StageClub, List<StageClass>, List<StageClub>) -> Unit,
    private val onGoBack: () -> Unit
): ComponentContext by componentContext {

    /**
     * Component Functionality
     */

    // Create Coroutine Scope
    val scope = CoroutineScope(Dispatchers.Default)

    // Variable to store the list of classes
    private val _classList = MutableValue<List<StageClass>>(emptyList())
    val classList: Value<List<StageClass>> = _classList

    // Variable to store the list of clubs
    private val _clubList = MutableValue<List<StageClub>>(emptyList())
    val clubList: Value<List<StageClub>> = _clubList

    // Function to load the class List
    fun loadClassList(list: List<StageClass>){
        _classList.value = list
    }

    // Function to load the club List
    fun loadClubList(list: List<StageClub>){
        _clubList.value = list
    }

    // Event Handler Function
    fun onEvent(event: StageDetailsEvent) {
        when (event) {
            is StageDetailsEvent.ClickClass -> onNavigateToClassResultsScreen(pageEvent, stage, event.selectedClass, classList.value, clubList.value)
            is StageDetailsEvent.ClickClub -> onNavigateToClubResultsScreen(pageEvent, stage, event.selectedClub, classList.value, clubList.value)
            StageDetailsEvent.GoBack -> onGoBack()
        }
    }

    /**
     * Class and Club Search Functionality
     */
    // Event Search functionality
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    // Combine the query and the Date Range and then execute the query
    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    val searchResults = searchQuery
        .debounce(300.milliseconds)      // Waits 300ms after the last key type to search
        .flatMapLatest { query ->
            if(query.isBlank()) {
                flowOf(null)
            }
            else {
                val classResults = searchClasses(query)
                val clubResults = searchClubs(query)

                // End search
                flowOf<List<SearchResultWrapper>>(classResults + clubResults)
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

    // Callback Function to add Classes
     fun addClasses(classList: List<StageClass>){
        _classList.value = classList
    }

    // Callback Function to add Clubs
     fun addClubs(clubList: List<StageClub>){
        _clubList.value = clubList
    }

    // Private functions for each of the searches
    // TODO - Better search logic

    private fun searchClasses(query: String): List<SearchResultWrapper> {
        val lowercaseQuery = query.lowercase()
        return classList.value
            // TODO - Handle that long Name coincidences don't seem explicable
            .filter { it.longName.lowercase().contains(lowercaseQuery) || it.shortName.lowercase().contains(lowercaseQuery) }
            .map { result -> SearchResultWrapper(true, result, null) }
    }

    private fun searchClubs(query: String): List<SearchResultWrapper> {
        val lowercaseQuery = query.lowercase()
        return clubList.value
            .filter { it.shortName.lowercase().contains(lowercaseQuery) }
            .map { result -> SearchResultWrapper(false, null, result) }
    }

    /**
     * Functionality for the Tab Navigation
     */

    // TODO - Modularize to avoid code repetition
    private val navigation = PagesNavigation<StageDetailsTabConfiguration>()

    // Exposed navigation
    val pages = childPages(
        source = navigation,
        serializer = StageDetailsTabConfiguration.serializer(),
        initialPages = {
            Pages(
                items = listOf(
                    StageDetailsTabConfiguration.Classes,
                    StageDetailsTabConfiguration.Clubs,
                ),
                selectedIndex = 0       // The main page is the Classes Tab
            )
        },
        pageStatus = ::handlePageStatus,
        childFactory = ::createChild,
        handleBackButton = false
    )

    // Child Factory Function
    private fun createChild(
        config: StageDetailsTabConfiguration,
        component: ComponentContext
    ): StageDetailsTabChild {
        return when(config){
            StageDetailsTabConfiguration.Classes -> StageDetailsTabChild.StageClasses(
                StageClassesComponent(
                    componentContext = component,
                    eventID = pageEvent.id,
                    stageID = stage.id,
                    repository = repository,
                    addClasses = ::addClasses,
                    onClassClick = { stageClass ->
                        onEvent(StageDetailsEvent.ClickClass(stageClass))
                    }
                )
            )
            StageDetailsTabConfiguration.Clubs -> StageDetailsTabChild.StageClubs(
                StageClubsComponent(
                    componentContext = component,
                    eventID = pageEvent.id,
                    stageID = stage.id,
                    repository = repository,
                    addClubs = ::addClubs,
                    onClubClick = { stageClub ->
                        onEvent(StageDetailsEvent.ClickClub(stageClub))
                    }
                )
            )

        }
    }

    // Sealed class will all the different tabs
    sealed class StageDetailsTabChild {
        data class StageClasses(val component: StageClassesComponent) : StageDetailsTabChild()
        data class StageClubs(val component: StageClubsComponent) : StageDetailsTabChild()
    }

    // Tab Picker Function
    fun selectTab(index: Int) {
        navigation.select(index)
    }

    // Custom function to handle Page Status
    private fun handlePageStatus(index: Int, pages: Pages<StageDetailsTabConfiguration>): Status{
        // Keeps all pages CREATED, doesn't destroy and recompose the tabs
        return when(index){
            pages.selectedIndex -> Status.RESUMED
            else -> Status.CREATED
        }
    }
}