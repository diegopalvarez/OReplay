package com.diegopalvarez.oreplay.feature.results.common.types.legs

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.children.ChildNavState.Status
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.arkivanov.decompose.router.pages.setItems
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Result
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.feature.results.common.types.legs.LegsComponent.LegsTabChild.*
import com.diegopalvarez.oreplay.feature.results.common.types.legs.navigation.LegResultComponent
import com.diegopalvarez.oreplay.feature.results.common.util.Optional
import kotlinx.serialization.Serializable

@OptIn(ExperimentalDecomposeApi::class)
class LegsComponent(
    componentContext: ComponentContext,
    val event: Event,
    val stage: Stage,
    val results: Value<List<Result>>,
    val numberOfLegs: Value<Optional<Int>>,
): ComponentContext by componentContext {

    /**
     * Split tab functionality
     */
    // Tab Navigation Functionality
    private val navigation = PagesNavigation<LegsTabConfiguration>()

    // TODO - Handle back button to exit, not go to the first screen

    // Exposed navigation
    val pages = childPages(
        source = navigation,
        serializer = LegsTabConfiguration.serializer(),
        initialPages = {
            when(val legs = numberOfLegs.value){
                Optional.None -> Pages(
                    items = emptyList(),
                    selectedIndex = 0
                )
                is Optional.Some -> Pages(
                    items = List(legs.value) { index ->
                        LegsTabConfiguration.Leg(index + 1) },
                    selectedIndex = 0
                )
            }
        },
        pageStatus = ::handlePageStatus,
        childFactory = ::createChild,
        handleBackButton = true
    )

    /**
     * Init function to handle changes in the number of legs
     */
    init {
        numberOfLegs.subscribe { legs ->
            if(legs is Optional.Some && legs.value != pages.value.items.size){
                navigation.setItems {
                    List(legs.value) { index ->
                        LegsTabConfiguration.Leg(index + 1)
                    }
                }
            }
        }
    }

    // Child Factory Function
    private fun createChild(
        config: LegsTabConfiguration,
        component: ComponentContext
    ): LegsTabChild {
        return when(config){
            is LegsTabConfiguration.Leg -> Leg(
                LegResultComponent(
                    componentContext = component,
                    event = event,
                    stage = stage,
                    results = results,
                    legNumber = config.legNumber
                )
            )
        }
    }

    // Sealed class will all the different tabs
    sealed class LegsTabChild {
        data class Leg(val component: LegResultComponent) : LegsTabChild()
    }

    // Configuration Class
    @Serializable
    sealed class LegsTabConfiguration(
        val legNumber: Int
    ) {
        @Serializable
        data class Leg(
            val leg: Int
        ) : LegsTabConfiguration(leg)
    }

    // Tab Picker Function
    fun selectTab(index: Int) {
        navigation.select(index)
    }

    // Custom function to handle Page Status
    private fun handlePageStatus(index: Int, pages: Pages<LegsTabConfiguration>): Status{
        // Keeps all pages CREATED, doesn't destroy and recompose the tabs
        return when(index){
            pages.selectedIndex -> Status.RESUMED
            else -> Status.CREATED
        }
    }
}