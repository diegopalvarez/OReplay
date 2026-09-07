package com.diegopalvarez.oreplay.core.language

import java.util.Locale

actual fun getDefaultLocale(): String {
    return Locale.getDefault().toLanguageTag()
}