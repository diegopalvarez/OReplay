package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.types.StatusCode
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.nc_position
import org.jetbrains.compose.resources.stringResource

@Composable
fun resultListItemLeadingContent(
    isNC: Boolean,
    statusCode: StatusCode,
    position: Long
): @Composable (() -> Unit)? {
    return if(isNC){
        @Composable {
            Text(
                text = stringResource(Res.string.nc_position),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
            )
        }
    }
    else if(statusCode == StatusCode.OK){
        // The position is 0 when a position is not applicable
        if(position > 0){
            @Composable {
                Text(
                    text = "${position}.",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
        else{
            // The runner hasn't finished yet
            null
        }
    }
    else{
        // The runner's status isn't OK
        null
    }
}