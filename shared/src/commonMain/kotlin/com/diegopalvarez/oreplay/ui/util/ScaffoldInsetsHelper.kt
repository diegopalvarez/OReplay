package com.diegopalvarez.oreplay.ui.util

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Composable
fun getScaffoldInsets(isRightPanel: Boolean = true, isExpanded: Boolean = false): WindowInsets {
    // Get the device type
    val isExpanded = isExpandedDevice()

    // Get the display cutout position (if the padding on the left is not 0)
    val isDisplayCutoutRight = WindowInsets.displayCutout.asPaddingValues().calculateRightPadding(LayoutDirection.Ltr) > 0.dp

    if(isExpanded && isRightPanel != isDisplayCutoutRight && !isExpanded) {
        // If the device is expanded, remove the status bar insets for the secondary panel
        // Only if the display cutout position and the panel side are different (only remove if the cutout is on the other side)
        return ScaffoldDefaults.contentWindowInsets.exclude(WindowInsets.displayCutout)
    }
    else{
        // If the screen is expanded, show the original insets
        return ScaffoldDefaults.contentWindowInsets
    }

}