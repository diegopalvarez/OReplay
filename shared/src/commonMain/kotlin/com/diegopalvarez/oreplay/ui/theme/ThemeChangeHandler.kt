package com.diegopalvarez.oreplay.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable

@Composable
expect fun changeAppTheme(isDark: Boolean, colorScheme: ColorScheme)