package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource

@Composable
fun ControlNumber(
    order: Long,
    number: String,
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
        }
    }

}