package com.diegopalvarez.oreplay.feature.events.common

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalWindowInfo
import kotlin.math.floor

@Composable
fun getExpandedGridSize(): Int {
    val windowInfo = LocalWindowInfo.current
    val windowHeight = windowInfo.containerSize.height
    val windowWidth = windowInfo.containerSize.width

    // Divide the height so that two rows of events remain
    val gridHeight = windowHeight/2F

    // Get the number of square tiles that would result for that height and the current width
    val gridWidth = windowWidth/gridHeight

    // Return the floor of the result to get a whole number of tiles, and not make them too small
    return floor(gridWidth).toInt()
}