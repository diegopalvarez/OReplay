package com.diegopalvarez.oreplay.core.language

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.staticCompositionLocalOf

actual object LocalAppLocale {

    private val defaultLocale = getDefaultLocale()

    private val LocalAppLocale = staticCompositionLocalOf { defaultLocale }

    actual val current: String
        @Composable
        get() = LocalAppLocale.current

    @Composable
    actual infix fun provides(value: String?): ProvidedValue<*> {
        val newLocale = value ?: defaultLocale

        // There's no browser global locale to modify

        return LocalAppLocale provides newLocale
    }
}