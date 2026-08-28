package com.diegopalvarez.oreplay.ui.util

import androidx.compose.ui.text.intl.Locale
import kotlinx.datetime.number
import kotlin.time.Duration
import kotlin.time.TimeMark

fun Duration.display(): String{
    return this.toComponents { hours, minutes, seconds, _ ->
        if(hours == 0L){
            "${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}"

        }
        else{
            "${hours}:${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}"
        }
    }
}

fun Duration.displayWithUnit(): String{
    return this.toComponents { minutes, seconds, _ ->
        if(minutes == 0L){
            "${seconds}s"

        }
        else{
            if(seconds == 0){
                "${minutes}m"
            }
            else{
                "${minutes}m ${seconds}s"
            }
        }
    }
}