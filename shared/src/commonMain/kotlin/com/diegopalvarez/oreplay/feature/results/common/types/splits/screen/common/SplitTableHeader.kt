package com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.common

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.SplitIndividual
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ControlNumber
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.total_time
import org.jetbrains.compose.resources.stringResource

@Composable
fun SplitTableHeader(
    modifier: Modifier = Modifier,
    scrollState: ScrollState,
    controls: List<SplitIndividual>,
    columnWidth: Dp
) {
    Row(
        modifier = modifier
            .horizontalScroll(scrollState)
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        // Total time Column Header
        Text(
            text = stringResource(Res.string.total_time),
            modifier = Modifier
                .width(columnWidth)
                .padding(8.dp),
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
        )

        // Column Header for each control
        controls.forEachIndexed { index, control ->
            ControlNumber(
                order = control.orderNumber,
                number = control.control.station,
                modifier = Modifier
                    .width(columnWidth)
                    .padding(8.dp),
            )
        }
    }
}