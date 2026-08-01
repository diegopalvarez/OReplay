package com.diegopalvarez.oreplay.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.diegopalvarez.oreplay.core.language.LocalAppLocale
import com.diegopalvarez.oreplay.ui.theme.AppTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.jetbrains.compose.resources.painterResource

import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.compose_multiplatform
import oreplay.shared.generated.resources.hello_world
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import androidx.compose.runtime.collectAsState
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.app.navigation.RootComponent

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
                    is RootComponent.Child.EventsScreen -> TODO()       //EventsUI(instance.component)
                    is RootComponent.Child.StageDetailsScreen -> TODO() //StageDetailsUI(instance.component)
                }
            }
        }
    }
}