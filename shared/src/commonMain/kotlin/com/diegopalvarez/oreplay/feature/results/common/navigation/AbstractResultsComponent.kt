package com.diegopalvarez.oreplay.feature.results.common.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.children.ChildNavState.Status
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.types.getStageType
import com.diegopalvarez.oreplay.feature.results.common.types.legs.LegsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.results.ResultsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.splits.SplitsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.startTimes.StartTimesComponent
import com.diegopalvarez.oreplay.feature.results.common.types.statistics.StatisticsComponent
import kotlin.time.Clock
import com.diegopalvarez.oreplay.domain.model.Result
import kotlinx.coroutines.launch

abstract class AbstractResultsComponent(
    componentContext: ComponentContext,
    private val onGoBack: () -> Unit,

    // List of attributes for the stage
    private val event: Event,
    private val stage: Stage,

    // List of attributes to create the different tabs
    private val isClubResults: Boolean,
): ComponentContext by componentContext {
    /**
     * Repository Connection
     */

    // Variable to store the list of results
    protected val _results = MutableValue<List<Result>>(emptyList())
    val results: Value<List<Result>> = _results

    // Variable to store if the data has been initialized
    protected val _isInit = MutableValue(false)
    val isINit: Value<Boolean> = _isInit

    // Variable to store the loading state of the results
    protected val _isLoading = MutableValue(false)
    val isLoading: Value<Boolean> = _isLoading

    // Variable to store if there has been an error connecting to the repository
    protected val _isError = MutableValue(false)
    val isError: Value<Boolean> = _isError

    // Variable to store the type of error in case it happened
    protected val _errorType = MutableValue(RepositoryError.UNKNOWN)
    val errorType: Value<RepositoryError> = _errorType

    /**
     * Protected function to fetch the results
     */
    protected abstract suspend fun fetchResults()

    /**
     * Reload function
     */
    abstract fun reloadResults()

    /**
     * Tab Navigation Functionality
     */
    // Tab Navigation Functionality
    private val navigation = PagesNavigation<ResultsTabConfiguration>()

    // Create the initial pages based on the stage type
    private val stageStart = stage.start
    private val hasStarted = (stageStart != null && stageStart < Clock.System.now())    // Check if the stage has already started

    private val initialPages = initialPagesHelper(isClubResults, hasStarted, stage.stageType.getStageType())

    // TODO - Handle back button to exit, not go to the first screen

    // Exposed navigation
    val pages = childPages(
        source = navigation,
        serializer = ResultsTabConfiguration.serializer(),
        initialPages = {
            initialPages
        },
        pageStatus = ::handlePageStatus,
        childFactory = ::createChild,
        handleBackButton = true
    )

    // Child Factory Function
    private fun createChild(
        config: ResultsTabConfiguration,
        component: ComponentContext
    ): ResultsTabChild {
        return when(config){
            ResultsTabConfiguration.StartTimes -> ResultsTabChild.StartTimes(
                StartTimesComponent(
                    componentContext = component
                )
            )
            ResultsTabConfiguration.Results -> ResultsTabChild.Results(
                ResultsComponent(
                    componentContext = component
                )
            )
            ResultsTabConfiguration.Splits -> ResultsTabChild.Splits(
                SplitsComponent(
                    componentContext = component
                )
            )
            ResultsTabConfiguration.Legs -> ResultsTabChild.Legs(
                LegsComponent(
                    componentContext = component
                )
            )
            ResultsTabConfiguration.Statistics -> ResultsTabChild.Statistics(
                StatisticsComponent(
                    componentContext = component
                )
            )

        }
    }

    // Sealed class will all the different tabs
    sealed class ResultsTabChild {
        data class StartTimes(val component: StartTimesComponent) : ResultsTabChild()
        data class Results(val component: ResultsComponent) : ResultsTabChild()
        data class Splits(val component: SplitsComponent) : ResultsTabChild()
        data class Legs(val component: LegsComponent) : ResultsTabChild()
        data class Statistics(val component: StatisticsComponent) : ResultsTabChild()
    }

    // Tab Picker Function
    fun selectTab(index: Int) {
        navigation.select(index)
    }

    // Custom function to handle Page Status
    private fun handlePageStatus(index: Int, pages: Pages<ResultsTabConfiguration>): Status{
        // Keeps all pages CREATED, doesn't destroy and recompose the tabs
        return when(index){
            pages.selectedIndex -> Status.RESUMED
            else -> Status.CREATED
        }
    }
}