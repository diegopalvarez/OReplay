package com.diegopalvarez.oreplay.app

import androidx.compose.runtime.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.diegopalvarez.oreplay.core.language.LocalAppLocale
import com.diegopalvarez.oreplay.ui.theme.AppTheme
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.app.navigation.RootComponent
import com.diegopalvarez.oreplay.core.language.LanguageManager
import com.diegopalvarez.oreplay.feature.eventStages.EventStagesScreen
import com.diegopalvarez.oreplay.feature.events.EventsScreen
import com.diegopalvarez.oreplay.feature.results.stageClass.screens.ClassResultsScreen
import com.diegopalvarez.oreplay.feature.results.stageClub.screens.ClubResultsScreen
import com.diegopalvarez.oreplay.feature.stageDetails.StageDetailsScreen
import org.koin.compose.koinInject
import org.koin.core.component.KoinComponent

@Composable
fun App(root: RootComponent) {
    // Language Manager
    val languageManager: LanguageManager = koinInject()
    val languageCode by languageManager.languageCode.collectAsStateWithLifecycle()

    // TODO - Check why the language sometimes takes a while to update on start-up

    // Create a CompositionLocalProvider to handle the language preferences for the whole app
    CompositionLocalProvider(LocalAppLocale provides languageCode) {
        AppTheme {
            // Create the ChildStack for the Navigation
            val childStack by root.childStack.subscribeAsState()

            // Different pages of the app
            Children(
                stack = childStack,
                animation = stackAnimation(slide())
            ) { child ->
                when (val instance = child.instance) {
                    is RootComponent.Child.ClassResultsScreen -> ClassResultsScreen(instance.component.pageEvent, instance.component.stage, instance.component.stageClassName, instance.component)
                    is RootComponent.Child.ClubResultsScreen -> ClubResultsScreen(instance.component.pageEvent, instance.component.stage, instance.component.stageClubName, instance.component)
                    is RootComponent.Child.EventStagesScreen -> EventStagesScreen(instance.component.pageEvent, instance.component)
                    is RootComponent.Child.EventsScreen -> EventsScreen(instance.component)
                    is RootComponent.Child.StageDetailsScreen -> StageDetailsScreen(instance.component.pageEvent, instance.component.stage, instance.component)
                }
            }
        }
    }
}