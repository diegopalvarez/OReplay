package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.score

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource

@Composable
fun ControlNumberScore(
    order: Long,
    number: String,
    points: Long,
    modifier: Modifier = Modifier
) {
    val style = MaterialTheme.typography.titleSmall

    if(number == "Finish"){
        // Display just the Finish tag
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = number,
                style = style,
            )
        }
    }
    else{
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
            modifier = modifier
                .padding(horizontal = 8.dp)
        ) {
            // Order in the race
            Text(
                text = order.toString(),
                style = style,
            )

            // Control number
            Text(
                text = "(${number})",
                style = style,
                fontWeight = FontWeight.Light,
            )

            // If there are points available in the split, display them
            if(points > 0){
                // TODO - Display in a Circle
                Text(
                    text = "[${points}]",
                    style = style,
                    fontWeight = FontWeight.Light,
                )
            }
        }
    }

}