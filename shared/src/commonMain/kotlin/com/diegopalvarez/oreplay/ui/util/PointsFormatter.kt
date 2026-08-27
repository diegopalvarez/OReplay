package com.diegopalvarez.oreplay.ui.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import kotlin.math.roundToInt

fun String.toPoints(): String{
    return this.toDouble().roundToInt().toString()
}