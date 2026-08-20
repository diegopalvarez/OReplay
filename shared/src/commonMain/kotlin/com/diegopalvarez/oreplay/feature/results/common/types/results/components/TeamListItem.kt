package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.ResultTeam
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.ui.util.display
import org.jetbrains.compose.resources.stringResource
import kotlin.time.Instant

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun TeamListItem(
    teamResult: ResultTeam,
    now: State<Instant>?,
    leadingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null,
    showTicketDrawer: (ResultIndividual) -> Unit = {}
) {
    val stageResult = teamResult.stageResult

    SegmentedListItem(
        shapes = ListItemDefaults.shapes(),
        onClick = {  },
        enabled = true,
        leadingContent =    if(stageResult != null){
                                resultListItemLeadingContent(teamResult.isNc, teamResult.stageResult.statusCode, teamResult.stageResult.position)
                            }
                            else null,
        trailingContent = null,
        overlineContent = null,
        supportingContent = {
            // List of members of the team with their individual results
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
    ) {
        // Name of the team as the main content, as well as the time and difference
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            // Name of the team
            Text(
                text = teamResult.fullName,
                color = MaterialTheme.colorScheme.onSurface
            )

            // Final time and Time Behind (only if the stageResult isn't null)

            if(stageResult != null) {
                val statusCode = stageResult.statusCode

                if(statusCode == StatusCode.OK ){
                    if (stageResult.position > 0 || teamResult.isNc) {
                        // Show the time and difference
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End),
                        ) {
                            // Final time
                            Text(
                                text = stageResult.timeSeconds.display(),
                                style = MaterialTheme.typography.bodyMedium,
                            )
                            // Time difference
                            Text(
                                text = "+${stageResult.timeBehind.display()}",
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        }
                    }
                    else{
                        // Show the current time
                        // TODO - Maybe change to monospace font
                        val startTime = stageResult.startTime
                        if(now != null && startTime != null){
                            Text(
                                text = "(${now.value.minus(startTime).display()})",
                                style = MaterialTheme.typography.bodyMedium,
                                fontStyle = FontStyle.Italic,
                            )
                        }
                    }
                }
                else{
                    // Show the error code
                    Text(
                        text = stringResource(statusCode.displayName),
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }

        }

    }
}