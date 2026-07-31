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

@Composable
@Preview
fun App() {
    AppTheme {
        var showContent by remember { mutableStateOf(false) }

        // TODO - Add actual languageCode logic when I add an actual viewmodel/decompose screen
        val languageCode = "es"

        // Create a CompositionLocalProvider to handle the language preferences for the whole app
        CompositionLocalProvider(LocalAppLocale provides languageCode) {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .safeContentPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(onClick = { showContent = !showContent }) {
                    Text("Click me!")
                }
                AnimatedVisibility(showContent) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(painterResource(Res.drawable.compose_multiplatform), null)
                        Text(
                            text = stringResource(Res.string.hello_world)
                        )
                    }
                }
            }
        }
    }
}