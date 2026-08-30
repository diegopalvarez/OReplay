package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.diegopalvarez.oreplay.domain.model.OverallResult
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.ui.util.display
import com.diegopalvarez.oreplay.ui.util.toPoints
import org.jetbrains.compose.resources.stringResource
import kotlin.time.Duration.Companion.seconds

@Composable
fun PointPartTrailingContent(
    part: OverallResult,
    isNC: Boolean,
) {
    if(part.statusCode == StatusCode.OK){
        // Show all the data available
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End,
        ){
            // Final Points
            Text(
                text = part.pointsFinal.toPoints(),
                style = MaterialTheme.typography.bodyMedium,
            )
            // Final time
            if(part.timeSeconds != 0.seconds) {
                if(part.position > 0){
                    // Show time with position
                    Text(
                        text = "${part.timeSeconds.display()} (${part.position})",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
                else{
                    // Only show the final time
                    Text(
                        text = part.timeSeconds.display(),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
        }
        // In case the runner hasn't finished, we don't show anything
    }
    else{
        // Show the error code and the final points
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End,
        ) {
            // Final points
            Text(
                text = part.pointsFinal.toPoints(),
                style = MaterialTheme.typography.bodyMedium,
            )

            // Error code
            Text(
                text = stringResource(part.statusCode.displayName),
                style = MaterialTheme.typography.bodyMedium,
            )
        }

    }
}