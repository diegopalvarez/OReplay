package com.diegopalvarez.oreplay

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.resume
import com.diegopalvarez.oreplay.app.App
import com.diegopalvarez.oreplay.app.di.initKoin
import com.diegopalvarez.oreplay.app.navigation.RootComponent
import com.diegopalvarez.oreplay.app.platform.addPointerListener
import com.diegopalvarez.oreplay.app.platform.setPointerType
import kotlin.js.ExperimentalWasmJsInterop
import kotlin.js.JsModule
import kotlin.js.js

// Create the TimeZone object for web
@OptIn(ExperimentalComposeUiApi::class, ExperimentalWasmJsInterop::class)
@JsModule("@js-joda/timezone")
external object JsJodaTimeZoneModule

private val jsJodaTimeZone = JsJodaTimeZoneModule

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    // Initialize the TimeZone database
    jsJodaTimeZone

    // Initialize Koin for Dependency Injection
    initKoin()

    // Create Root Component
    val lifecycle = LifecycleRegistry()

    val root = RootComponent(
        // Pass the LifecycleRegistry to the context
        componentContext = DefaultComponentContext(lifecycle = lifecycle),
    )

    // Add an event listener to register if the web display is touchable or not
    addTouchableEventListener()

    // Resume the lifecycle
    lifecycle.resume()

    // Render the UI
    ComposeViewport {
        App(
            root = root,
        )
    }
}

@OptIn(ExperimentalWasmJsInterop::class)
fun addTouchableEventListener(){
    addPointerListener { pointerType ->
        setPointerType(pointerType)
    }
}