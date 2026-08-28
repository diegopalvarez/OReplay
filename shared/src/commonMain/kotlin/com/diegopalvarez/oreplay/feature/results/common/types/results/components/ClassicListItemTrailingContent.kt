package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.ui.util.display
import org.jetbrains.compose.resources.stringResource
import kotlin.math.roundToInt
import kotlin.time.Duration
import kotlin.time.Instant

@Composable
fun classicListItemTrailingContent(
    isNC: Boolean,
    timeSeconds: Duration,
    timeBehind: Duration,
    startTime: Instant?,
    statusCode: StatusCode,
    now: State<Instant>?,
    position: Long
): @Composable () -> Unit {
    return {
        // Column containing the final time and the time difference, if the result OK and has a position
        // In case of a runner that hasn't finished, show the current time
        // In case of an error, show its code

        if(statusCode == StatusCode.OK){
            // The position is 0 when a position is not applicable
            if(position > 0 || isNC){
                // Show the time and difference
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End,
                ){
                    // Final time
                    Text(
                        text = timeSeconds.display(),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    // Time difference
                    Text(
                        text = "+${timeBehind.display()}",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
            else{
                // Show current time
                // TODO - Maybe change to monospace font
                // Only display the time if the runner has started
                if(now != null && startTime != null && startTime < now.value){
                    Text(
                        text = "(${now.value.minus(startTime).display()})",
                        style = MaterialTheme.typography.bodyMedium,
                        fontStyle = FontStyle.Italic,
                    )
                }

            }
        }
        else{
            // Show the error code
            Text(
                text = stringResource(statusCode.displayName),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}