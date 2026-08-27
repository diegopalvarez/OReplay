package com.diegopalvarez.oreplay.feature.results.common.types.splits.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.children.ChildNavState.Status
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.subscribe
import com.diegopalvarez.oreplay.domain.model.Result
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.types.StageType
import com.diegopalvarez.oreplay.domain.types.getStageType
import com.diegopalvarez.oreplay.feature.results.common.navigation.ResultsTabConfiguration
import com.diegopalvarez.oreplay.feature.results.common.types.legs.LegsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.points.PointsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.ResultsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.ScoreResultsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.startTimes.StartTimesComponent
import com.diegopalvarez.oreplay.feature.results.common.types.statistics.StatisticsComponent
import com.diegopalvarez.oreplay.feature.results.common.util.filterResultsWithSplits
import com.diegopalvarez.oreplay.feature.results.common.util.hasFinished
import com.diegopalvarez.oreplay.feature.results.common.util.sortIndividualResults

class SplitsComponent(
    componentContext: ComponentContext,
    val results: Value<List<Result>>,
    val widestString: Value<String>,
): ComponentContext by componentContext {
    /**
     * Expose the already sorted results
     */
    private val _sortedResults = MutableValue<List<ResultIndividual>>(emptyList())
    val sortedResults: Value<List<ResultIndividual>> = _sortedResults

    init {
        filterResults()

        // Subscribe so that in every value change the filter updates
        results.subscribe {
            filterResults()
        }
    }

    private fun filterResults(){
        val individualResults = results.value.filterIsInstance<ResultIndividual>()
        val splitResults = filterResultsWithSplits(individualResults.filter { hasFinished(it) })

        // Sort the results
        val sortedResults = sortIndividualResults(splitResults, null)
        _sortedResults.value = sortedResults
    }

    /**
     * Split tab functionality
     */
    // Tab Navigation Functionality
    private val navigation = PagesNavigation<SplitsTabConfiguration>()

    // TODO - Handle back button to exit, not go to the first screen

    // Exposed navigation
    val pages = childPages(
        source = navigation,
        serializer = SplitsTabConfiguration.serializer(),
        initialPages = {
            Pages(
                items = listOf(
                    SplitsTabConfiguration.Partials,
                    SplitsTabConfiguration.Accumulated,
                ),
                selectedIndex = 0
            )
        },
        pageStatus = ::handlePageStatus,
        childFactory = ::createChild,
        handleBackButton = true
    )

    // Child Factory Function
    private fun createChild(
        config: SplitsTabConfiguration,
        component: ComponentContext
    ): SplitsTabChild {
        return when(config){
            SplitsTabConfiguration.Partials -> SplitsTabChild.Partials(
                PartialsComponent(
                    componentContext = component,
                )
            )
            SplitsTabConfiguration.Accumulated -> SplitsTabChild.Accumulated(
                AccumulatedComponent(
                    componentContext = component,
                )
            )
        }
    }

    // Sealed class will all the different tabs
    sealed class SplitsTabChild {
        data class Partials(val component: PartialsComponent) : SplitsTabChild()
        data class Accumulated(val component: AccumulatedComponent) : SplitsTabChild()
    }

    // Tab Picker Function
    fun selectTab(index: Int) {
        navigation.select(index)
    }

    // Custom function to handle Page Status
    private fun handlePageStatus(index: Int, pages: Pages<SplitsTabConfiguration>): Status{
        // Keeps all pages CREATED, doesn't destroy and recompose the tabs
        return when(index){
            pages.selectedIndex -> Status.RESUMED
            else -> Status.CREATED
        }
    }
}