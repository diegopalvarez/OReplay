package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.ui.util.display
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_split
import org.jetbrains.compose.resources.stringResource
import kotlin.time.Duration

@Composable
fun SplitTime(
    total: Duration?,
    partial: Duration?,
    position: Long?,
    modifier: Modifier = Modifier,
) {
    // Calculate the weight based on the position
    val weight = if(position != null && position == 1L){
        FontWeight.Bold
    }
    else{
        FontWeight.Normal
    }

    val style = MaterialTheme.typography.labelLarge

    var alignment = Alignment.Start

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = alignment,
        modifier = modifier
            .padding(8.dp)
    ) {
        if(total != null){
            // In case of an MP, there can be an accumulated time with total (the ones you punch) but no split because you missed the last one
            Text(
                text = total.display(),
                style = style,
                fontWeight = weight,
            )

            if(partial != null){
                // If there's a position calculated, display it next to the partial
                if(position != null){
                    Text(
                        text = "+${partial.display()} (${position})",
                        style = style,
                        fontWeight = weight,
                    )
                }
                else{
                    Text(
                        text = "+${partial.display()}",
                        style = style,
                        fontWeight = weight,
                    )
                }
            }
            else{
                Text(
                    text = stringResource(Res.string.no_split),
                    style = style,
                )
            }
        }
        else{
            // If there's no total, there can't be split at all
            Text(
                text = stringResource(Res.string.no_split),
                style = style,
            )
            Text(
                text = stringResource(Res.string.no_split),
                style = style,
            )

            // The text is center-aligned
            alignment = Alignment.CenterHorizontally
        }
    }
}