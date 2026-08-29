package com.diegopalvarez.oreplay.ui.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import kotlin.math.roundToInt

fun String.toPoints(): String{
    return this.toDouble().roundToInt().toString()
}

fun Double.toPoints(): String{
    return if(this % 1.0 == 0.0){
        // The number is exact
        this.toInt().toString()
    }
    else{
        // The number has decimals
        this.toString()
    }
}