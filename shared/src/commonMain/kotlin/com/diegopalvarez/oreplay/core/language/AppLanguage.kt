package com.diegopalvarez.oreplay.core.language

import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.english_language
import oreplay.shared.generated.resources.spanish_language
import org.jetbrains.compose.resources.StringResource

enum class AppLanguage(val code: String, val string: StringResource) {
    ENGLISH("en", Res.string.english_language),
    SPANISH("es", Res.string.spanish_language);
}

fun getAppLanguageByCode(code: String?): AppLanguage {
    return when(code) {
        "en" -> AppLanguage.ENGLISH
        "es" -> AppLanguage.SPANISH
        else -> AppLanguage.ENGLISH
    }
}