package com.diegopalvarez.oreplay.feature.results.common.types.splits.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.types.StatusCode
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.nc_position
import org.jetbrains.compose.resources.stringResource

@Composable
fun StatusIndicator(
    statusCode: StatusCode,
    isNC: Boolean,
    modifier: Modifier = Modifier,
) {
    if(isNC){
        Text(
            text = stringResource(Res.string.nc_position),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(horizontal = 8.dp)
        )
    }
    else if(statusCode != StatusCode.OK){
        // The position is 0 when a position is not applicable
        Text(
            text = stringResource(statusCode.displayName),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(horizontal = 8.dp)
        )
    }
    // The runner's status is OK
}