package com.diegopalvarez.oreplay.core.language

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.intl.Locale
import kotlin.js.ExperimentalWasmJsInterop
import kotlin.js.js

actual object LocalAppLocale {

    private val defaultLocale = getDefaultLocale()

    private val LocalAppLocale = staticCompositionLocalOf { defaultLocale }

    actual val current: String
        @Composable
        get() = LocalAppLocale.current

    @Composable
    actual infix fun provides(value: String?): ProvidedValue<*> {
        updateCustomLocale(value?.replace('_', '-'))

        return LocalAppLocale provides Locale.current.toString()
    }
}

@OptIn(ExperimentalWasmJsInterop::class)
private fun updateCustomLocale(value: String?) {
    js(
        """
        if (window.__customLocale !== value) {
            window.__customLocale = value;
            window.dispatchEvent(new Event("languagechange"));
        }
        """
    )
}