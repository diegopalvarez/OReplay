package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.SplitIndividual
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.domain.types.getStatusCode
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ControlNumber
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.NoPartialSplitTime
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.SplitTime
import com.diegopalvarez.oreplay.ui.util.RunnerClassFormatter
import com.diegopalvarez.oreplay.ui.util.StageClubFormatter
import com.diegopalvarez.oreplay.ui.util.displayTime
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_start_time
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun OneManRelayTicketSplitItem(
    split: SplitIndividual,
    alternateColor: Boolean
) {
    // Calculate the color for the row
    val color = if (alternateColor) {
                    MaterialTheme.colorScheme.surfaceContainer
                } else {
                    MaterialTheme.colorScheme.surfaceContainerHigh
                }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color)
            .padding(horizontal = 8.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        // Number of the control
        ControlNumber(split.orderNumber, split.control.station, Modifier.weight(0.75f))

        // Partial
        NoPartialSplitTime(
            split.partial,
            Modifier.weight(1.125f)
        )

        // Accumulated
        NoPartialSplitTime(
            split.accumulated,
            Modifier.weight(1.125f)
        )
    }
}