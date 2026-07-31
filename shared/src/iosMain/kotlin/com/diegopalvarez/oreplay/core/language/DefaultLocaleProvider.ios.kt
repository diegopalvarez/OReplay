package com.diegopalvarez.oreplay.core.language

import platform.Foundation.NSLocale
import platform.Foundation.preferredLanguages

actual fun getDefaultLocale(): String {
    return (NSLocale.preferredLanguages.firstOrNull() as? String) ?: "en"       // The default language is English if none is set
}