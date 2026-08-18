package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.score

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
fun ScoreControlCircle(
    control: String,
    visited: Boolean,
    numberOfVisitors: Long,
    totalRunners: Long,
){
    // Calculate the angle of the ring
    val ringAngle = (numberOfVisitors.toFloat()/totalRunners.toFloat()) * 360f

    // Get the outline color
    val outlineColor = MaterialTheme.colorScheme.outline

    // Get the circle color
    val circleColor = MaterialTheme.colorScheme.secondaryContainer

    // TODO - Make the size of the circle responsive
    // Circle size
    val circleSize = 40.dp

    // Stroke width
    val strokeWidth = 4.dp

    // TODO - Add tooltip indicating the number of visitors/runner
    TooltipBox(
        positionProvider = TooltipDefaults.rememberTooltipPositionProvider(
            positioning = TooltipAnchorPosition.Below
        ),
        tooltip = {
            PlainTooltip {
                // TOOLTIP CONTENT
                Text(
                    text = "${stringResource(Res.string.score_stat_text)} $numberOfVisitors/$totalRunners ${stringResource(Res.string.runners)}",
                )
            }
        },
        state = rememberTooltipState()
    ){
        Box(
            modifier = Modifier
                .padding(8.dp)
                .size(circleSize),
            contentAlignment = Alignment.Center
        ) {
            // Create canvas for displaying the number of runners that visited the control
            Canvas(
                modifier = Modifier
                    .matchParentSize()
            ) {
                // Fill the circle if the control has been visited
                if(visited){
                    drawCircle(
                        color = circleColor,
                        radius = (circleSize.toPx() - strokeWidth.toPx()) / 2f,
                    )
                }

                drawArc(
                    color = outlineColor,
                    startAngle = -90f,
                    sweepAngle = ringAngle,
                    useCenter = false,
                    style = Stroke(
                        width = strokeWidth.toPx(),
                        cap = StrokeCap.Round
                    )
                )
            }
            Text(
                text = control,
            )
        }
    }

}