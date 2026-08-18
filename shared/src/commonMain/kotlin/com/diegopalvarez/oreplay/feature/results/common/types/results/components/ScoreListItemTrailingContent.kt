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
import androidx.compose.ui.text.font.FontWeight
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.ui.util.display
import com.diegopalvarez.oreplay.ui.util.toPoints
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.nc_position
import org.jetbrains.compose.resources.stringResource
import kotlin.math.roundToInt
import kotlin.time.Instant

@Composable
fun scoreListItemTrailingContent(
    isNC: Boolean,
    result: StageResult,
    statusCode: StatusCode,
    now: State<Instant>?,
    position: Long
): @Composable () -> Unit {
    return {
        // Column containing the final points and time, if the result OK and has a position
        // In case of a runner that hasn't finished, show the current time
        // In case of an error, show its code

        if(statusCode == StatusCode.OK) {
            // The position is 0 when a position is not applicable
            if (position > 0 || isNC) {
                // Show the points and time
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End,
                ) {
                    // Total Points
                    if(result.pointsTotal != null){
                        // TODO - See when points can be null
                        Text(
                            text = result.pointsTotal.toPoints(),
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }

                    // Total Time
                    Text(
                        text = result.timeSeconds.display(),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            } else {
                // Show current time
                // TODO - Maybe change to monospace font
                val startTime = result.startTime
                if (now != null && startTime != null) {
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