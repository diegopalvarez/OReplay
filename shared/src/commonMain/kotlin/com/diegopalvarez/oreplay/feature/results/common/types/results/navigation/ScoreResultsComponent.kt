package com.diegopalvarez.oreplay.feature.results.common.types.results.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.children.ChildNavState.Status
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Result
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.repository.util.ScoreResultStats
import com.diegopalvarez.oreplay.domain.types.StageType
import com.diegopalvarez.oreplay.feature.results.common.util.Optional

class ScoreResultsComponent(
    componentContext: ComponentContext,
    val scoreResults: Value<List<Result>>,
    private val event: Event,
    private val stage: Stage,
    private val stageType: StageType,
    private val isClubView: Boolean,
    private val isStageLive: Value<Boolean>,
    val visitedStatsMap: Value<Optional<Map<String, ScoreResultStats>>>,
    goToPage: (String, String) -> Unit
): CommonResultComponent(
    componentContext = componentContext,
    results = scoreResults,
    event = event,
    stage = stage,
    stageType = stageType,
    isClubView = isClubView,
    isLive = isStageLive,
    goToPage = goToPage
) {
    /**
     * Function to get the visited stats for the class of the runner in the ticker
     */
    fun getVisitedStats(classID: String?): Optional<ScoreResultStats>{
        when(val stats = visitedStatsMap.value){
            Optional.None -> return Optional.None
            is Optional.Some -> if(classID != null){
                                    val result = stats.value[classID]
                                    return if(result != null) {
                                        Optional.Some(result)
                                    } else{
                                        Optional.None
                                    }
                                }
                                else{
                                    return Optional.None
                                }
        }
    }

    /**
     * Set up Tab Navigation for the different ticket views
     */
    private val navigation = PagesNavigation<ScoreTabConfiguration>()

    // TODO - Handle back button to exit, not go to the first screen

    // Exposed navigation
    val pages = childPages(
        source = navigation,
        serializer = ScoreTabConfiguration.serializer(),
        initialPages = {
            Pages(
                items = listOf(
                    ScoreTabConfiguration.ScoreTab,
                    ScoreTabConfiguration.TableTab,
                ),
                selectedIndex = 0
            )
        },
        pageStatus = ::handlePageStatus,
        childFactory = ::createChild,
        handleBackButton = false
    )

    // Child Factory Function
    private fun createChild(
        config: ScoreTabConfiguration,
        component: ComponentContext
    ): TicketTabChild {
        return when(config){
            ScoreTabConfiguration.TableTab -> TicketTabChild.TableView(
                TableTabComponent(
                    componentContext = component,
                    ticketRunner = ticketRunner,
                )
            )
            ScoreTabConfiguration.ScoreTab -> TicketTabChild.ScoreView(
                ScoreTabComponent(
                    componentContext = component,
                    ticketRunner = ticketRunner,
                )
            )
        }
    }

    // Sealed class will all the different tabs
    sealed class TicketTabChild {
        data class TableView(val component: TableTabComponent) : TicketTabChild()
        data class ScoreView(val component: ScoreTabComponent) : TicketTabChild()
    }

    // Tab Picker Function
    fun selectTab(index: Int) {
        navigation.select(index)
    }

    // Custom function to handle Page Status
    private fun handlePageStatus(index: Int, pages: Pages<ScoreTabConfiguration>): Status{
        // Keeps all pages CREATED, doesn't destroy and recompose the tabs
        return when(index){
            pages.selectedIndex -> Status.RESUMED
            else -> Status.CREATED
        }
    }
}