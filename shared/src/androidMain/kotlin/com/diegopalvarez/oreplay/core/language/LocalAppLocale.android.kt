package com.diegopalvarez.oreplay.core.language

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import java.util.Locale
import androidx.compose.ui.platform.LocalLocale

actual object LocalAppLocale {

    private var defaultLocale: Locale? = null

    actual val current: String
        @Composable
        get() = LocalLocale.current.platformLocale.toLanguageTag()

    @Composable
    actual infix fun provides(value: String?): ProvidedValue<*> {
        val configuration = LocalConfiguration.current

        // If there's no value set, we initialize the default Locale
        if(defaultLocale == null) {
            defaultLocale = LocalLocale.current.platformLocale
        }

        val newLocale = if (value == null) {
            defaultLocale!!
        } else {
            Locale.forLanguageTag(value)
        }

        // Set the new Locale
        Locale.setDefault(newLocale)
        configuration.setLocale(newLocale)

        val context = LocalContext.current
        val newContext = context.createConfigurationContext(configuration)

        return LocalContext provides newContext
    }
}