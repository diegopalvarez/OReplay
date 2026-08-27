package com.diegopalvarez.oreplay.feature.results.common.types.splits.components

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
fun ResultIndividualPosition(
    isNC: Boolean,
    statusCode: StatusCode,
    position: Long
) {
    if(isNC){
        Text(
            text = stringResource(Res.string.nc_position),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
        )
    }
    else if(statusCode == StatusCode.OK){
        // The position is 0 when a position is not applicable
        if(position > 0){
            Text(
                text = "${position}.",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
            )
        }
        // The runner hasn't finished yet
    }
    // The runner's status isn't OK
}