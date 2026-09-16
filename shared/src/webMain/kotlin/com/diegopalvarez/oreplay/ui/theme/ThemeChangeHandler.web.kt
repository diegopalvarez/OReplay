package com.diegopalvarez.oreplay.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import kotlinx.browser.document

@Composable
actual fun changeAppTheme(isDark: Boolean, colorScheme: ColorScheme) {
    setColorScheme(isDark)

    // This one isn't supported by many browsers for now but it's nice to have
    setThemeColor(colorScheme)
}

fun setThemeColor(colorScheme: ColorScheme) {
    val meta = document
        .querySelector("meta[name='theme-color']")
        ?: document.createElement("meta")
            .also {
                it.setAttribute("name", "theme-color")
                document.head?.appendChild(it)
            }

    meta
        .setAttribute(
            "content",
            colorScheme.background.toCssColor()
        )
}

fun setColorScheme(isDark: Boolean) {
    val meta = document
        .querySelector("meta[name='color-scheme']")
        ?: document.createElement("meta")
            .also {
                it.setAttribute("name", "color-scheme")
                document.head?.appendChild(it)
            }

    meta
        .setAttribute(
            "content",
            when(isDark){
                true -> "dark"
                false -> "light"
            }
        )
}

fun Color.toCssColor(): String {
    val r = (red * 255).toInt()
    val g = (green * 255).toInt()
    val b = (blue * 255).toInt()
    val a = alpha

    return if (a >= 1f) {
        "rgb($r, $g, $b)"
    } else {
        "rgba($r, $g, $b, $a)"
    }
}