package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.Image
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

@Composable
fun ThemeImage(
    painter: Painter,
    contentDescription: String,
    contentScale: ContentScale = ContentScale.FillWidth,
    modifier: Modifier = Modifier,
){
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale,
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground),
    )
}