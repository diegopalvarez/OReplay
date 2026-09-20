package com.diegopalvarez.oreplay.feature.stageResults.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.panels.ChildPanels
import com.arkivanov.decompose.router.panels.ChildPanelsMode
import com.arkivanov.decompose.router.panels.Panels
import com.arkivanov.decompose.router.panels.PanelsNavigation
import com.arkivanov.decompose.router.panels.activateDetails
import com.arkivanov.decompose.router.panels.childPanels
import com.arkivanov.decompose.router.panels.dismissDetails
import com.arkivanov.decompose.router.panels.setMode
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.app.navigation.RootComponent.Configuration
import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.domain.repository.ClassResultsRepository
import com.diegopalvarez.oreplay.domain.repository.ClubResultsRepository
import com.diegopalvarez.oreplay.domain.repository.StageRepository
import com.diegopalvarez.oreplay.domain.wrappers.ResultHistory
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import com.diegopalvarez.oreplay.feature.results.common.navigation.ResultsTabConfiguration
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsComponent
import com.diegopalvarez.oreplay.feature.results.stageClass.screens.ClassResultsScreen
import com.diegopalvarez.oreplay.feature.results.stageClub.navigation.ClubResultsComponent
import com.diegopalvarez.oreplay.feature.stageDetails.navigation.StageDetailsComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.getValue

class StagePanelsComponent(
    componentContext: ComponentContext,
    val stage: Stage,
    val pageEvent: Event,
    private val stageRepository: StageRepository,
    private val onGoBack: () -> Unit
): ComponentContext by componentContext, KoinComponent {
    // Inject the dependencies for details tab creation
    val classResultsRepository: ClassResultsRepository by inject()
    val clubResultsRepository: ClubResultsRepository by inject()
    val preferencesManager: PreferencesManager by inject()

    // Declare the auxiliary functions for changing between detail view
    @OptIn(ExperimentalDecomposeApi::class)
    private fun goToClassResults(
        event: Event,
        stage: Stage,
        stageClass: StageClass,
        stageHistory: ResultHistory
    ) {
        navigation.activateDetails(
            details = StageResultsConfiguration.ClassResultsScreen(
                event = event,
                stage = stage,
                stageClass = stageClass,
                stageHistory = stageHistory
            )
        )
    }

    @OptIn(ExperimentalDecomposeApi::class)
    private fun goToClubResults(
        event: Event,
        stage: Stage,
        stageClub: StageClub,
        stageHistory: ResultHistory
    ) {
        navigation.activateDetails(
            details = StageResultsConfiguration.ClubResultsScreen(
                event = event,
                stage = stage,
                stageClub = stageClub,
                stageHistory = stageHistory
            )
        )
    }

    /**
     * Functionality for the Panels Navigation
     */
    @OptIn(ExperimentalDecomposeApi::class)
    private val navigation = PanelsNavigation<Unit, StageResultsConfiguration, Nothing>()

    @OptIn(ExperimentalDecomposeApi::class, ExperimentalSerializationApi::class)
    val panels: Value<ChildPanels<*, StageDetailsComponent, *, AbstractResultsComponent, Nothing, Nothing>> =
        childPanels(
            source = navigation,
            serializers = Unit.serializer() to StageResultsConfiguration.serializer(),
            initialPanels = {
                Panels(main = Unit)
            },
            handleBackButton = false,
            mainFactory = { _, ctx ->
                StageDetailsComponent(
                    componentContext = componentContext,
                    stage = stage,
                    pageEvent = pageEvent,
                    repository = stageRepository,
                    onGoBack = onGoBack,
                    onNavigateToClassResultsScreen = ::goToClassResults,
                    onNavigateToClubResultsScreen = ::goToClubResults,
                )
            },
            detailsFactory = { config, context ->
                when(config) {
                    is StageResultsConfiguration.ClassResultsScreen -> {
                        ClassResultsComponent(
                            componentContext = context,
                            pageEvent = config.event,
                            stage = config.stage,
                            stageClass = config.stageClass,
                            repository = classResultsRepository,
                            preferences = preferencesManager,
                            onGoBack = {
                                onEvent(StagePanelsEvent.CloseDetailsPanel)
                            },
                            onGoToClass = { event, stage, stageClass ->
                                goToClassResults(event, stage, stageClass, config.stageHistory)
                            },
                            onGoToClub = { event, stage, stageClub ->
                                goToClubResults(event, stage, stageClub, config.stageHistory)
                            },
                            stageHistory = config.stageHistory,
                        )
                    }
                    is StageResultsConfiguration.ClubResultsScreen -> {
                        ClubResultsComponent(
                            componentContext = context,
                            pageEvent = config.event,
                            stage = config.stage,
                            stageClub = config.stageClub,
                            repository = clubResultsRepository,
                            preferences = preferencesManager,
                            onGoBack = {
                                onEvent(StagePanelsEvent.CloseDetailsPanel)
                            },
                            onGoToClass = { event, stage, stageClass ->
                                goToClassResults(event, stage, stageClass, config.stageHistory)
                            },
                            onGoToClub = { event, stage, stageClub ->
                                goToClubResults(event, stage, stageClub, config.stageHistory)
                            },
                            stageHistory = config.stageHistory,
                        )
                    }
                }
            }
        )

    @OptIn(ExperimentalDecomposeApi::class)
    fun setMode(mode: ChildPanelsMode) {
        navigation.setMode(mode)
    }

    /**
     * Event Handling Functions
     */
    @OptIn(ExperimentalDecomposeApi::class)
    fun onEvent(event: StagePanelsEvent) {
        when(event) {
            StagePanelsEvent.GoBack -> onGoBack()
            StagePanelsEvent.CloseDetailsPanel -> navigation.dismissDetails()
        }
    }

}