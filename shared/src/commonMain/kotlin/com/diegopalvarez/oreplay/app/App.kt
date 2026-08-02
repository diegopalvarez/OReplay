package com.diegopalvarez.oreplay.app

import androidx.compose.runtime.*
import com.diegopalvarez.oreplay.core.language.LocalAppLocale
import com.diegopalvarez.oreplay.ui.theme.AppTheme
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.app.navigation.RootComponent
import com.diegopalvarez.oreplay.feature.events.EventsScreen

@Composable
fun App(root: RootComponent) {
    AppTheme {
        // Create the ChildStack for the Navigation
        val childStack by root.childStack.subscribeAsState()

        // TODO - Add actual languageCode logic when I add an actual viewmodel/decompose screen
        val languageCode = "es"

        // Create a CompositionLocalProvider to handle the language preferences for the whole app
        CompositionLocalProvider(LocalAppLocale provides languageCode) {
            Children(
                stack = childStack,
                animation = stackAnimation(slide())
            ) { child ->
                when (val instance = child.instance) {
                    is RootComponent.Child.ClassResultsScreen -> TODO() //ClassResultUI(instance.component)
                    is RootComponent.Child.ClubResultsScreen -> TODO()  //ClubResultUI(instance.component)
                    is RootComponent.Child.EventStagesScreen -> TODO()  //EventStagesUI(instance.component)
                    is RootComponent.Child.EventsScreen -> EventsScreen(instance.component)
                    is RootComponent.Child.StageDetailsScreen -> TODO() //StageDetailsUI(instance.component)
                }
            }
        }
    }
}