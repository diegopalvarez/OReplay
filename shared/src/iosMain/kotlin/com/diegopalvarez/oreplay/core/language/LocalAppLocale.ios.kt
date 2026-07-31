package com.diegopalvarez.oreplay.core.language

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.intl.Locale
import platform.Foundation.NSUserDefaults

actual object LocalAppLocale {

    private val defaultLocale = getDefaultLocale()

    private val LocalAppLocale = staticCompositionLocalOf { defaultLocale }

    actual val current: String
        @Composable
        get() = LocalAppLocale.current

    @Composable
    actual infix fun provides(value: String?): ProvidedValue<*> {
        val newLocale = value ?: defaultLocale

        // Update or delete the AppleLanguages list
        if(value == null) {
            NSUserDefaults.standardUserDefaults.removeObjectForKey("AppleLanguages")
        } else {
            NSUserDefaults.standardUserDefaults.setObject(
                listOf(newLocale),
                "AppleLanguages",
            )
        }

        return LocalAppLocale provides newLocale
    }
}