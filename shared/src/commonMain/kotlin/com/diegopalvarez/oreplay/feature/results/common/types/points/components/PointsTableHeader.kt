package com.diegopalvarez.oreplay.feature.results.common.types.points.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.diegopalvarez.oreplay.domain.repository.util.ScoreResultStats
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ControlNumber
import com.diegopalvarez.oreplay.feature.results.common.util.Optional
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.bonus
import oreplay.shared.generated.resources.name
import oreplay.shared.generated.resources.penalty
import oreplay.shared.generated.resources.points
import oreplay.shared.generated.resources.total_time
import org.jetbrains.compose.resources.stringResource

@Composable
fun PointsTableHeader(
    modifier: Modifier = Modifier,
    scrollState: ScrollState,
    columnWidth: Dp,
    visitedStats: Optional<ScoreResultStats>,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState)
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 32.dp, vertical = 8.dp)
    ) {
        // Bonus Column Header
        Text(
            text = stringResource(Res.string.bonus),
            modifier = Modifier
                .width(columnWidth),
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
        )

        // Penalty Column Header
        Text(
            text = stringResource(Res.string.penalty),
            modifier = Modifier
                .width(columnWidth + 10.dp),
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
        )

        // Points Column Header
        Text(
            text = stringResource(Res.string.points),
            modifier = Modifier
                .width(columnWidth),
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
        )

        // Time Column Header
        Text(
            text = stringResource(Res.string.total_time),
            modifier = Modifier
                .width(columnWidth),
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
        )

        // Reserve space if there are visited controls
        when(visitedStats) {
            Optional.None -> null
            is Optional.Some -> ControlStatsRow(visitedStats.value) //Row(modifier = Modifier.width(56.dp * visitedStats.value.visited.size)) {}
        }
    }
}