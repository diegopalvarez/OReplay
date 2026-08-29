package com.diegopalvarez.oreplay.app.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import com.diegopalvarez.oreplay.core.language.LanguageManager
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.domain.repository.ClassResultsRepository
import com.diegopalvarez.oreplay.domain.repository.ClubResultsRepository
import com.diegopalvarez.oreplay.domain.repository.EventRepository
import com.diegopalvarez.oreplay.domain.repository.StageRepository
import com.diegopalvarez.oreplay.feature.eventStages.navigation.EventStagesComponent
import com.diegopalvarez.oreplay.feature.events.navigation.EventsScreenComponent
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsComponent
import com.diegopalvarez.oreplay.feature.results.stageClub.navigation.ClubResultsComponent
import com.diegopalvarez.oreplay.feature.stageDetails.navigation.StageDetailsComponent
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RootComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext, KoinComponent {
    // Stack for keeping the active screen layers
    private val navigation = StackNavigation<Configuration>()

    // Navigation Stack
    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.EventsScreen,       // Main Screen for the Feature
        handleBackButton = true,
        childFactory =::createChild
    )

    // Function to create a new child screen
    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Child {
        return when (config) {
            Configuration.EventsScreen -> {
                // Get the LanguageManager by Dependency Injection
                val languageManager: LanguageManager by inject()
                val preferencesManager: PreferencesManager by inject()
                val eventRepository: EventRepository by inject()
                Child.EventsScreen(
                    EventsScreenComponent(
                        componentContext = context,
                        onNavigateToEventStagesScreen = { event ->
                            navigation.pushNew(Configuration.EventStagesScreen(event))
                        },
                        languageManager = languageManager,
                        preferencesManager = preferencesManager,
                        eventRepository = eventRepository
                    )
                )
            }
            is Configuration.EventStagesScreen -> {
                val stageRepository: StageRepository by inject()
                Child.EventStagesScreen(
                    EventStagesComponent(
                        componentContext = context,
                        onNavigateToStageDetailsScreen = { event, stage ->
                            navigation.pushNew(Configuration.StageDetailsScreen(event, stage))
                        },
                        onSkipToStageDetailsScreen = { event, stage ->
                            navigation.replaceCurrent(Configuration.StageDetailsScreen(event, stage))
                        },
                        pageEvent = config.event,
                        onGoBack = {
                            navigation.pop()
                        },
                        repository = stageRepository
                    )
                )
            }
            is Configuration.StageDetailsScreen -> {
                val stageRepository: StageRepository by inject()
                Child.StageDetailsScreen(
                    StageDetailsComponent(
                        componentContext = context,
                        onNavigateToClassResultsScreen = { event, stage, stageClass, stageClassesList, stageClubsList ->
                            navigation.pushNew(Configuration.ClassResultsScreen(event, stage, stageClass.id, stageClass.longName, stageClassesList, stageClubsList))
                        },
                        onNavigateToClubResultsScreen = { event, stage, stageClub, stageClassesList, stageClubsList ->
                            navigation.pushNew(Configuration.ClubResultsScreen(event, stage, stageClub.id, stageClub.shortName, stageClassesList, stageClubsList))
                        },
                        onGoBack = {
                            navigation.pop()
                        },
                        stage = config.stage,
                        pageEvent = config.event,
                        repository = stageRepository
                    )
                )
            }
            is Configuration.ClassResultsScreen -> {
                val repository: ClassResultsRepository by inject()
                val preferencesManager: PreferencesManager by inject()
                Child.ClassResultsScreen(
                    ClassResultsComponent(
                        componentContext = context,
                        pageEvent = config.event,
                        stage = config.stage,
                        stageClassID = config.stageClassID,
                        stageClassName = config.stageClassName,
                        repository = repository,
                        preferences = preferencesManager,
                        onGoBack = {
                            navigation.pop()
                        },
                        onGoToClass = { event, stage, stageClassID, stageClassName ->
                            navigation.replaceCurrent(Configuration.ClassResultsScreen(event, stage, stageClassID, stageClassName, config.stageClasses, config.stageClubs))
                        },
                        onGoToClub = { event, stage, stageClubID, stageClubName ->
                            navigation.replaceCurrent(Configuration.ClubResultsScreen(event, stage, stageClubID, stageClubName, config.stageClasses, config.stageClubs))
                        },
                        stageClasses = config.stageClasses,
                    )
                )
            }
            is Configuration.ClubResultsScreen -> {
                val repository: ClubResultsRepository by inject()
                val preferencesManager: PreferencesManager by inject()
                Child.ClubResultsScreen(
                    ClubResultsComponent(
                        componentContext = context,
                        pageEvent = config.event,
                        stage = config.stage,
                        stageClubID = config.stageClubID,
                        stageClubName = config.stageClubName,
                        repository = repository,
                        preferences = preferencesManager,
                        onGoBack = {
                            navigation.pop()
                        },
                        onGoToClass = { event, stage, stageClassID, stageClassName ->
                            navigation.replaceCurrent(Configuration.ClassResultsScreen(event, stage, stageClassID, stageClassName, config.stageClasses, config.stageClubs))
                        },
                        onGoToClub = { event, stage, stageClubID, stageClubName ->
                            navigation.replaceCurrent(Configuration.ClubResultsScreen(event, stage, stageClubID, stageClubName, config.stageClasses, config.stageClubs))
                        },
                        stageClubs = config.stageClubs
                    )
                )
            }
        }
    }

    // Sealed class including all the different ACTUAL SCREENS under this RootComponent
    // The components are the VIEW MODELS for the different screens
    sealed class Child {
        // Main Screen, shows a list of all valid events
        data class EventsScreen(val component: EventsScreenComponent) : Child()

        // Event Screen, shows the details and stages for the selected Event
        data class EventStagesScreen(val component: EventStagesComponent) : Child()

        // Stage Details Screen, shows the classes and clubs for a single stage of an event
        data class StageDetailsScreen(val component: StageDetailsComponent) : Child()

        // Class Results Screen, shows the results for the selected class
        data class ClassResultsScreen(val component: ClassResultsComponent) : Child()

        // Club Results Screen, shows the results for the selected club
        data class ClubResultsScreen(val component: ClubResultsComponent) : Child()

    }

    // Sealed class including all the different screen CONFIGURATIONS under this RootComponent
    // The main advantage of a Sealed Class is that all its direct subclasses must be known in COMPILE TIME
    @Serializable
    sealed class Configuration {
        @Serializable
        data object EventsScreen: Configuration()                    // Object because it doesn't have parameters

        @Serializable
        data class EventStagesScreen(val event: Event): Configuration()   // Class because it does have parameters that can change

        @Serializable
        data class StageDetailsScreen(val event: Event, val stage: Stage): Configuration()

        @Serializable
        data class ClassResultsScreen(val event: Event, val stage: Stage, val stageClassID: String, val stageClassName: String, val stageClasses: List<StageClass>, val stageClubs: List<StageClub>): Configuration()

        @Serializable
        data class ClubResultsScreen(val event: Event, val stage: Stage, val stageClubID: String, val stageClubName: String, val stageClasses: List<StageClass>, val stageClubs: List<StageClub>): Configuration()
    }
}