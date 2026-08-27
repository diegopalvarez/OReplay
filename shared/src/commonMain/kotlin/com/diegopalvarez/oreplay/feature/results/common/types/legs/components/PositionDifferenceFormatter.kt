package com.diegopalvarez.oreplay.feature.results.common.types.legs.components

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.ui.util.display
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.team_position
import org.jetbrains.compose.resources.stringResource
import kotlin.math.absoluteValue
import kotlin.time.Instant

@Composable
fun positionDifferenceFormatter(
    position: Long,
    previousPosition: Long?,
    teamStatus: StatusCode,
    legNumber: Long
): @Composable (() -> Unit)? {
    // If there's an error, display it
    if(teamStatus == StatusCode.OK && previousPosition != null && position > 0 && previousPosition > 0) {
        return {
            // Team result with colors depending on the change
            val positionDifference = previousPosition - position

            if (positionDifference == 0L) {
                // The positions are the same
                Text(
                    text = "=",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            } else if (positionDifference < 0) {
                // Lost positions
                Text(
                    text = "-${positionDifference.absoluteValue}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.error,
                )
            } else {
                // Gained positions
                Text(
                    text = "+${positionDifference}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Green,
                )
            }
        }
    }
    else{
        return null
    }
}