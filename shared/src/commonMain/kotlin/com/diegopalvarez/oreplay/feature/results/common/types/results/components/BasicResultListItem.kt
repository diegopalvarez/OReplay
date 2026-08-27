package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.ui.util.RunnerClassFormatter
import com.diegopalvarez.oreplay.ui.util.StageClubFormatter

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun BasicResultListItem(
    runner: ResultIndividual,
    isClubView: Boolean,
    leadingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null,
    showTicketDrawer: (ResultIndividual) -> Unit = {}
) {
    SegmentedListItem(
        shapes = ListItemDefaults.shapes(),
        onClick = { showTicketDrawer(runner) },
        enabled = true,
        leadingContent = leadingContent,
        trailingContent = trailingContent,
        overlineContent = null,
        supportingContent = {
            // Name of the class or the club of the runner as a supporting content for the name
            if (isClubView) {
                // Name of the class if it's club view
                RunnerClassFormatter(runner.runnerClass)

            } else {
                // Name of the club if it's the class view
                StageClubFormatter(runner.runnerClub)
            }
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