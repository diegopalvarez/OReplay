package com.diegopalvarez.oreplay.feature.results.common.types.legs.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.RelayLegResult
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.classicListItemTrailingContent
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.resultListItemLeadingContent
import com.diegopalvarez.oreplay.ui.util.RunnerClassFormatter
import com.diegopalvarez.oreplay.ui.util.StageClubFormatter
import kotlin.time.Instant

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LegResultListItem(
    runner: ResultIndividual,
    teamData: RelayLegResult,
    now: State<Instant>?,
    showTicketDrawer: (ResultIndividual) -> Unit = {}
) {
    val statusCode = teamData.teamError ?: StatusCode.OK
    SegmentedListItem(
        shapes = ListItemDefaults.shapes(),
        onClick = { showTicketDrawer(runner) },
        enabled = true,
        leadingContent = resultListItemLeadingContent(teamData.teamNC, statusCode, teamData.accumulatedPosition),
        trailingContent = classicListItemTrailingContent(teamData.teamNC, teamData.teamTime, teamData.teamTimeBehind, runner.stageResult?.startTime, statusCode, now, teamData.accumulatedPosition),
        overlineContent = positionDifferenceFormatter(teamData.accumulatedPosition, teamData.previousPosition, statusCode, runner.legNumber),
        supportingContent = {
            // Name of the team and club of the runner
                RunnerTeamFormatter(runner.runnerClub, teamData.teamName)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
    ) {
        // Name of the runner as the main content
        Text(
            text = runner.fullName,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}