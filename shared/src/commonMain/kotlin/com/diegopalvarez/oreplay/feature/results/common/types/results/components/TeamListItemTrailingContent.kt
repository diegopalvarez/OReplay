package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.ui.util.display
import org.jetbrains.compose.resources.stringResource
import kotlin.math.roundToInt
import kotlin.time.Duration
import kotlin.time.Instant

@Composable
fun teamListItemTrailingContent(
    isNC: Boolean,
    result: StageResult,
    statusCode: StatusCode,
    now: State<Instant>?,
    position: Long,
    accumulatedTime: Duration,
    isAccumulatedError: Boolean,
    teamStatusCode: StatusCode,
): @Composable () -> Unit {
    return {
        // Row containing the final time and the time difference, if the result OK and has a position
        // In case of a runner that hasn't finished, show the current time
        // In case of an error, show its code

        if(statusCode == StatusCode.OK ){
            // The position is 0 when a position is not applicable
            if(position > 0 || isNC){
                Row(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.End)
                ){
                    // Final time
                    Text(
                        text = result.timeSeconds.display(),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    if(!isAccumulatedError){
                        // Team Accumulated time
                        Text(
                            text = accumulatedTime.display(),
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }
                    else{
                        // Team Accumulated Error
                        Text(
                            text = stringResource(teamStatusCode.displayName),
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    }
                }
            }
            else{
                // Show current time for both the leg and the accumulated
                // TODO - Maybe change to monospace font
                val startTime = result.startTime
                // Only show the elapsed time if the runner has started
                if(now != null && startTime != null && startTime < now.value) {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.End)
                    ){
                        // Live Leg Time
                        Text(
                            text = "(${now.value.minus(startTime).display()})",
                            style = MaterialTheme.typography.bodyMedium,
                            fontStyle = FontStyle.Italic,
                        )
                        if(!isAccumulatedError){
                            // Team Live Accumulated time
                            Text(
                                text = "(${now.value.minus(startTime).plus(accumulatedTime).display()})",
                                style = MaterialTheme.typography.bodyMedium,
                                fontStyle = FontStyle.Italic,
                            )
                        }
                        else{
                            // Team Accumulated Error
                            Text(
                                text = stringResource(teamStatusCode.displayName),
                                style = MaterialTheme.typography.bodyLarge,
                            )
                        }

                    }

                }

            }
        }
        else{
            // TODO - Check if the error logic is correct: show the leg error in the leg it happens, and the team error in the following legs
            // Show the error code for both the leg and the team
            Row(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.End)
            ){
                // Leg Error
                Text(
                    text = stringResource(statusCode.displayName),
                    style = MaterialTheme.typography.bodyLarge,
                )
                // Team Error
                Text(
                    text = stringResource(statusCode.displayName),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}