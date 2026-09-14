package com.diegopalvarez.oreplay

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.resume
import com.diegopalvarez.oreplay.app.App
import com.diegopalvarez.oreplay.app.di.initKoin
import com.diegopalvarez.oreplay.app.navigation.RootComponent

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    // Initialize Koin for Dependency Injection
    initKoin()

    // Create Root Component
    val lifecycle = LifecycleRegistry()

    val root = RootComponent(
        // Pass the LifecycleRegistry to the context
        componentContext = DefaultComponentContext(lifecycle = lifecycle),
    )

    // Resume the lifecycle
    lifecycle.resume()

    // Render the UI
    ComposeViewport {
        App(
            root = root,
        )
    }
}