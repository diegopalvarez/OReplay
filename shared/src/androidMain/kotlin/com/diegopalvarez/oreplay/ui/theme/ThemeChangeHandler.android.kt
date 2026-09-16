package com.diegopalvarez.oreplay.ui.theme

import android.app.Activity
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
actual fun changeAppTheme(isDark: Boolean, colorScheme: ColorScheme) {
    // Change the Status Bar to the correct color
    val view = LocalView.current
    val window = (view.context as Activity).window

    WindowCompat.getInsetsController(window, view).apply {
        isAppearanceLightStatusBars = !isDark
        isAppearanceLightNavigationBars = !isDark
    }
}