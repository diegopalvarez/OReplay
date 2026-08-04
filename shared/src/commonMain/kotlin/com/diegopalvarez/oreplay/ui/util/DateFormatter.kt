package com.diegopalvarez.oreplay.ui.util

import androidx.compose.ui.text.intl.Locale
import kotlinx.datetime.LocalDate
import kotlinx.datetime.number

fun LocalDate.display(): String{
    return if(Locale.current.language == "en"){
        "${this.month.number}/${this.day}/${this.year}"
    }
    else{
        "${this.day}/${this.month.number}/${this.year}"
    }
}