package com.diegopalvarez.oreplay.feature.stageResults.util

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.panels.ChildPanelsMode
import androidx.compose.runtime.DisposableEffect
import androidx.window.core.layout.WindowSizeClass

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun ChildPanelsModeChangedEffect(
    onModeChanged: (ChildPanelsMode) -> Unit
) {
    // Get the window properties
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

    // TODO - Add fold information to change aspect ratio to 50%-50%

    // Calculate the mode the view should be displayed
    val mode = if(windowSizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND)) {
        ChildPanelsMode.DUAL
    }
    else {
        ChildPanelsMode.SINGLE
    }

    DisposableEffect(mode) {
        onModeChanged(mode)
        onDispose {}
    }
}