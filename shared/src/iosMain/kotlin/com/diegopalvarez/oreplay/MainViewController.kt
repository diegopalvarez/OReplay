package com.diegopalvarez.oreplay

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.diegopalvarez.oreplay.app.App
import com.diegopalvarez.oreplay.app.di.initKoin
import com.diegopalvarez.oreplay.app.navigation.RootComponent

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    val root = remember {
        RootComponent(DefaultComponentContext(LifecycleRegistry()))
    }
    App(
        root = root
    )
}