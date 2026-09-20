package com.diegopalvarez.oreplay.ui.util

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.window.core.layout.WindowSizeClass

@Composable
fun isExpandedDevice(): Boolean {
    // Get the window properties
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

    // Calculate the mode the view should be displayed
    return windowSizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND)
}