package com.diegopalvarez.oreplay.core.language

import kotlinx.browser.window

actual fun getDefaultLocale(): String {
    return window.navigator.language
}