package com.diegopalvarez.oreplay.feature.results.common.types.points.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.dp
@Composable
fun ScorePointsStat(
    visitedNumber: Long,
    totalRunners: Long,
){
    // Calculate the progress of the bar
    val progress = if (totalRunners > 0) {
        (visitedNumber.toFloat() / totalRunners.toFloat()).coerceIn(0f, 1f)
    } else {
        0f
    }

    // Get the outline color
    val outlineColor = MaterialTheme.colorScheme.outline

    // TODO - Make the size of the circle responsive
    // Bar Width
    val barWidth = 40.dp

    // Bar height
    val barHeight = 4.dp

    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Actual stats for the visitor
        Text(
            text = "$visitedNumber/$totalRunners",
            style = MaterialTheme.typography.bodySmall,
        )

        // Spacer
        Spacer(modifier = Modifier.height(4.dp))

        // Create canvas for displaying the number of runners that visited the control
        Canvas(
            modifier = Modifier
                .width(barWidth)
                .height(barHeight)
        ) {
            // First display the full bar as an underline
            drawRoundRect(
                color = outlineColor.copy(alpha = 0.25f),
                size = size,
                cornerRadius = CornerRadius(size.height / 2)
            )

            // Draw the actual progress on top
            drawRoundRect(
                color = outlineColor,
                size = Size(
                    width = size.width * progress,
                    height = size.height
                ),
                cornerRadius = CornerRadius(size.height / 2)
            )
        }

    }
}