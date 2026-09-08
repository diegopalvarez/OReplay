package com.diegopalvarez.oreplay.feature.results.common.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.children.ChildNavState.Status
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.types.getStageType
import com.diegopalvarez.oreplay.feature.results.common.types.legs.LegsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.splits.navigation.SplitsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.startTimes.StartTimesComponent
import com.diegopalvarez.oreplay.feature.results.common.types.statistics.StatisticsComponent
import kotlin.time.Clock
import com.diegopalvarez.oreplay.domain.model.Result
import com.diegopalvarez.oreplay.domain.model.StageCategory
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.domain.repository.util.ScoreResultStats
import com.diegopalvarez.oreplay.domain.types.StageType
import com.diegopalvarez.oreplay.domain.wrappers.ResultHistory
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent.ResultsTabChild.*
import com.diegopalvarez.oreplay.feature.results.common.navigation.categories.CategoryTabComponent
import com.diegopalvarez.oreplay.feature.results.common.types.points.PointsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.CommonResultComponent
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.ResultsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.ScoreResultsComponent
import com.diegopalvarez.oreplay.feature.results.common.util.Optional
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.Serializable

abstract class AbstractResultsComponent(
    componentContext: ComponentContext,
    private val onGoBack: () -> Unit,

    // List of attributes for the stage
    private val event: Event,
    private val stage: Stage,

    // Category Selected for this view
    private val category: StageCategory,

    // Preferences manager
    val preferencesManager: PreferencesManager,

    // Stage History
    val stageHistory: ResultHistory,

    // Navigation functions
    private val onGoToClass: (Event, Stage, StageClass) -> Unit,
    private val onGoToClub: (Event, Stage, StageClub) -> Unit,
): ComponentContext by componentContext {
    /**
     * Repository Connection
     */

    // Variable to store the list of results
    protected val _results = MutableValue<List<Result>>(emptyList())
    val results: Value<List<Result>> = _results

    // Variable to store if the data has been initialized
    protected val _isInit = MutableValue(false)
    val isInit: Value<Boolean> = _isInit

    // Variable to store the loading state of the results
    protected val _isRefreshing = MutableValue(false)
    val isRefreshing: Value<Boolean> = _isRefreshing

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
     * Protected function to safely get the results using a MUTEX
     */
    protected suspend fun getResults(){
        refreshMutex.withLock {
            fetchResults()
        }
    }

    /**
     * Reload function
     */
    abstract fun reloadResults()

    /**
     * Abstract function that allows the components to add their current category to the history before navigating
     */
    abstract fun updateStageHistory()

    /**
     * Function to go to a page using direct links
     */
    fun goToPage(page: StageCategory){
        // Add the CURRENT class or club to the history before navigating
        updateStageHistory()

        when(page){
            is StageClass -> onGoToClass(
                event,
                stage,
                page
            )
            is StageClub -> onGoToClub(
                event,
                stage,
                page
            )
        }
    }


    /**
     * Variable to hold the information regarding visitedControls in Score
     */
    protected val _visitedScoreControls: MutableValue<Optional<Map<String, ScoreResultStats>>> = MutableValue(Optional.None)
    val visitedScoreControls: Value<Optional<Map<String, ScoreResultStats>>> = _visitedScoreControls

    /**
     * Variable to hold the information regarding the widest string used for Split Tables
     */
    protected val _widestString = MutableValue<Int>(0)
    val widestString: Value<Int> = _widestString

    /**
    * Variable to hold the information regarding the number of legs in a Relay Race
    */
    protected val _numberOfLegs: MutableValue<Optional<Int>> = MutableValue(Optional.None)
    val numberOfLegs: Value<Optional<Int>> = _numberOfLegs

    /**
     * Variables to know if the event has started and is live
     */
    private val stageStart = stage.start
    private val hasStarted = (stageStart != null && stageStart < Clock.System.now())    // Check if the stage has already started
    private val isToday = (stageStart != null && stageStart.toLocalDateTime(event.timezone).date == Clock.System.now().toLocalDateTime(event.timezone).date)

    // Check if the event is happening right now
    private val _isLive = MutableValue(hasStarted && isToday)
    val isLive: Value<Boolean> = _isLive

    /**
     * State of the automatic reload interval
     */
    val reloadInterval = preferencesManager.convertRefresh

    /**
     * Set up a Mutex so that only one results fetch can be happening at the same time
     */
    protected val refreshMutex = Mutex()

    /**
     * Tab Navigation Functionality
     */
    // Tab Navigation Functionality
    private val navigation = PagesNavigation<ResultsTabConfiguration>()

    // Create the initial pages based on the stage type
    val isClubResult = when(category){
        is StageClass -> false
        is StageClub -> true
    }
    private val initialPages = initialPagesHelper(isClubResult, hasStarted, stage.stageType.getStageType())

    // Exposed navigation
    val pages = childPages(
        source = navigation,
        serializer = ResultsTabConfiguration.serializer(),
        initialPages = {
            initialPages
        },
        pageStatus = ::handlePageStatus,
        childFactory = ::createChild,
        handleBackButton = false,
        key = "DefaultChildPages"
    )

    // Child Factory Function
    private fun createChild(
        config: ResultsTabConfiguration,
        component: ComponentContext
    ): ResultsTabChild {
        return when(config){
            ResultsTabConfiguration.StartTimes -> StartTimes(
                StartTimesComponent(
                    componentContext = component,
                    results = results,
                    event = event,
                    isClubView = isClubResult,
                )
            )
            ResultsTabConfiguration.Results -> {
                if(stage.stageType.getStageType() == StageType.SCORE){
                    // The Component for Score Stages is different since it has two tabs for the ticket
                    Results(
                        ScoreResultsComponent(
                            componentContext = component,
                            scoreResults = results,
                            event = event,
                            stage = stage,
                            stageType = stage.stageType.getStageType(),
                            isClubView = isClubResult,
                            isStageLive = isLive,
                            visitedStatsMap = visitedScoreControls,
                            goToPage = ::goToPage,
                            mapResultClass = stageHistory::getClass
                        )
                    )
                }
                else{
                    Results(
                        ResultsComponent(
                            componentContext = component,
                            regularResults = results,
                            event = event,
                            stage = stage,
                            stageType = stage.stageType.getStageType(),
                            isClubView = isClubResult,
                            isStageLive = isLive,
                            goToPage = ::goToPage,
                            mapResultClass = stageHistory::getClass
                        )
                    )
                }
            }
            ResultsTabConfiguration.Splits -> Splits(
                SplitsComponent(
                    componentContext = component,
                    results = results,
                    widestString = widestString,
                )
            )
            ResultsTabConfiguration.Legs -> Legs(
                LegsComponent(
                    componentContext = component,
                    event = event,
                    stage = stage,
                    results = results,
                    numberOfLegs = numberOfLegs
                )
            )
            ResultsTabConfiguration.Statistics -> Statistics(
                StatisticsComponent(
                    componentContext = component,
                    results = results
                )
            )

            ResultsTabConfiguration.Points -> Points(
                PointsComponent(
                    componentContext = component,
                    results = results,
                    visitedStatsMap = visitedScoreControls
                )
            )
        }
    }

    // Sealed class will all the different tabs
    sealed class ResultsTabChild {
        data class StartTimes(val component: StartTimesComponent) : ResultsTabChild()
        data class Results(val component: CommonResultComponent) : ResultsTabChild()
        data class Splits(val component: SplitsComponent) : ResultsTabChild()
        data class Legs(val component: LegsComponent) : ResultsTabChild()
        data class Points(val component: PointsComponent) : ResultsTabChild()
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

    /**
     * State to track the selected tab in the stage details dialog
     */
    private val dialogNavigation = PagesNavigation<CategoryTabConfiguration>()


    // Exposed navigation
    val dialogPages = childPages(
        source = dialogNavigation,
        serializer = CategoryTabConfiguration.serializer(),
        initialPages = {
            Pages(
                items = listOf(
                    CategoryTabConfiguration.ClassTab,
                    CategoryTabConfiguration.ClubTab
                ),
                selectedIndex = if(isClubResult) 1 else 0
            )
        },
        pageStatus = ::handleDialogPageStatus,
        childFactory = ::createDialogChild,
        handleBackButton = false,
        key = "CategoryDialogChildPages"
    )

    // Sealed Configuration Class
    @Serializable
    sealed class CategoryTabConfiguration {
        @Serializable
        data object ClassTab: CategoryTabConfiguration()

        @Serializable
        data object ClubTab: CategoryTabConfiguration()
    }

    // Child Factory Function
    private fun createDialogChild(
        config: CategoryTabConfiguration,
        component: ComponentContext
    ): CategoryTabChild {
        return when(config){
            CategoryTabConfiguration.ClassTab -> {
                CategoryTabChild.ClassTab(
                    CategoryTabComponent(
                        componentContext = component,
                        history = stageHistory,
                        current = category
                    )
                )
            }
            CategoryTabConfiguration.ClubTab -> {
                CategoryTabChild.ClubTab(
                    CategoryTabComponent(
                        componentContext = component,
                        history = stageHistory,
                        current = category
                    )
                )
            }
        }
    }

    // Sealed class will all the different tabs
    sealed class CategoryTabChild {
        data class ClassTab(val component: CategoryTabComponent) : CategoryTabChild()
        data class ClubTab(val component: CategoryTabComponent) : CategoryTabChild()
    }

    // Tab Picker Function
    fun selectDialogTab(index: Int) {
        dialogNavigation.select(index)
    }

    // Custom function to handle Page Status
    private fun handleDialogPageStatus(index: Int, pages: Pages<CategoryTabConfiguration>): Status{
        // Keeps all pages CREATED, doesn't destroy and recompose the tabs
        return when(index){
            pages.selectedIndex -> Status.RESUMED
            else -> Status.CREATED
        }
    }
}