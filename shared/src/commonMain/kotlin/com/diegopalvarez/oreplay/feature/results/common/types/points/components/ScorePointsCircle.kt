package com.diegopalvarez.oreplay.feature.results.common.types.points.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.runners
import oreplay.shared.generated.resources.score_stat_text
import org.jetbrains.compose.resources.stringResource

@Composable
fun ScorePointsCircle(
    control: String,
    visited: Boolean,
){
    // Get the outline color
    val outlineColor = MaterialTheme.colorScheme.outline

    // Get the circle color
    val circleColor = MaterialTheme.colorScheme.secondaryContainer

    // TODO - Make the size of the circle responsive
    // Circle size
    val circleSize = 40.dp

    // Stroke width
    val strokeWidth = 2.dp

    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(circleSize)
            .background(
                color = if (visited) circleColor else Color.Transparent,
                shape = CircleShape
            )
            .border(
                width = strokeWidth,
                color = outlineColor,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        // Display the control number
        Text(
            text = control,
        )
    }

}