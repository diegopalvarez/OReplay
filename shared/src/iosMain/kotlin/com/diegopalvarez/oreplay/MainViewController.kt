package com.diegopalvarez.oreplay

import androidx.compose.ui.window.ComposeUIViewController
import com.diegopalvarez.oreplay.app.App
import com.diegopalvarez.oreplay.app.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }