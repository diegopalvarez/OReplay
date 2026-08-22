package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import com.diegopalvarez.oreplay.domain.model.OverallResult
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.ui.util.display
import org.jetbrains.compose.resources.stringResource

@Composable
fun OverallTimeTrailingContent(
    total: OverallResult,
    isNC: Boolean
) {
    if(total.statusCode == StatusCode.OK){
        // The position is 0 when a position is not applicable
        if(total.position > 0 || isNC){
            // Show the time and difference
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
            ){
                // Final time
                Text(
                    text = total.timeSeconds.display(),
                    style = MaterialTheme.typography.bodyMedium,
                )
                // Time difference
                if(total.timeBehind != null) {
                    Text(
                        text = "+${total.timeBehind.display()}",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
        }
        // I case the runner hasn't finished, we don't show anything
    }
    else{
        // Show the error code
        Text(
            text = stringResource(total.statusCode.displayName),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}