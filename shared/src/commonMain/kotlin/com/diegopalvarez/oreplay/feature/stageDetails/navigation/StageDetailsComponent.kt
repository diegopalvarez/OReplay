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
import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.domain.repository.StageRepository
import com.diegopalvarez.oreplay.feature.stageDetails.screens.classes.StageClassesComponent
import com.diegopalvarez.oreplay.feature.stageDetails.screens.clubs.StageClubsComponent

class StageDetailsComponent(
    componentContext: ComponentContext,
    val stage: Stage,
    val event: Event,
    private val repository: StageRepository,
    private val onNavigateToClassResultsScreen: (StageClass) -> Unit,
    private val onNavigateToClubResultsScreen: (StageClub) -> Unit,
    private val onGoBack: () -> Unit
): ComponentContext by componentContext {

    /**
     * Component Functionality
     */

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
            is StageDetailsEvent.ClickClass -> onNavigateToClassResultsScreen(event.selectedClass)
            is StageDetailsEvent.ClickClub -> onNavigateToClubResultsScreen(event.selectedClub)
            StageDetailsEvent.GoBack -> onGoBack()
        }
    }

    /**
     * Functionality for the Tab Navigation
     */

    // TODO - Modularize to avoid code repetition
    private val navigation = PagesNavigation<StageDetailsTabConfiguration>()
    // TODO - Handle back button in Tabs

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
        handleBackButton = true
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
                    eventID = event.id,
                    stageID = stage.id,
                    repository = repository
                )
            )
            StageDetailsTabConfiguration.Clubs -> StageDetailsTabChild.StageClubs(
                StageClubsComponent(
                    componentContext = component,
                    eventID = event.id,
                    stageID = stage.id,
                    repository = repository
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