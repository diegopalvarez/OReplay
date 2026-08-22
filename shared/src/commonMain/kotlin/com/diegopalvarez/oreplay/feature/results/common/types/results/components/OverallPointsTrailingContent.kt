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
fun OverallPointsTrailingContent(
    total: OverallResult,
    isNC: Boolean
) {
    if(total.statusCode == StatusCode.OK){
        // Even if the position is 0 there might be points
        // Show the time and difference
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End,
        ){
            // Final points
            Text(
                text = total.pointsFinal.toString(),
                style = MaterialTheme.typography.bodyMedium,
            )
            // Points difference
            if(total.pointsBehind != null){
                Text(
                    text = "+${total.pointsBehind}",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
    else{
        // Show the error code
        Text(
            text = stringResource(total.statusCode.displayName),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}