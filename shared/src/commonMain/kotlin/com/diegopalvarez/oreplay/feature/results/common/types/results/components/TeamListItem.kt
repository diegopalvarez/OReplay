package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.ResultTeam
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.ui.util.display
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.nc_position
import org.jetbrains.compose.resources.stringResource
import kotlin.time.Duration.Companion.seconds
import kotlin.time.Instant

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun TeamListItem(
    teamResult: ResultTeam,
    now: State<Instant>?,
    leadingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null,
    showTicketDrawer: (ResultIndividual, ResultTeam) -> Unit
) {
    val stageResult = teamResult.stageResult

    SegmentedListItem(
        shapes = ListItemDefaults.shapes(),
        onClick = {  },
        enabled = true,
        leadingContent = null,
        trailingContent = null,
        overlineContent = null,
        supportingContent = {
            // List of members of the team with their individual results
            if(teamResult.stageResult != null) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    for(index in teamResult.runners.indices){
                        val member = teamResult.runners[index]
                        SegmentedListItem(
                            onClick = { showTicketDrawer(member, teamResult) },
                            shapes = ListItemDefaults.shapes(),
                            enabled = true,
                            overlineContent = null,
                            leadingContent = {
                                Text(
                                    text = "${member.legNumber}.",
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Bold,
                                )
                            },
                            trailingContent =   if(member.stageResult != null){
                                // Final time and Time Behind for the leg
                                teamListItemTrailingContent(
                                    isNC = member.isNc,
                                    result = member.stageResult,
                                    statusCode = member.stageResult.statusCode,
                                    now = now,
                                    position = member.stageResult.position,
                                    accumulatedTime = teamResult.teamAccumulatedTime[index],
                                    isAccumulatedError = teamResult.isAccumulatedError[index],
                                    teamStatusCode = teamResult.stageResult.statusCode
                                )
                            } else null,
                            colors = ListItemDefaults.colors(
                                containerColor = MaterialTheme.colorScheme.surfaceContainer,
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 2.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ){
                            // Name of the team runner
                            Text(
                                text = member.fullName
                            )
                        }
                    }
                }
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
        // Name of the team as the main content, as well as the time and difference
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
            ) {
                if(stageResult != null){
                    if(teamResult.isNc){
                        Text(
                            text = stringResource(Res.string.nc_position),
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    else if(stageResult.statusCode == StatusCode.OK){
                        // The position is 0 when a position is not applicable
                        if(stageResult.position > 0){
                            Text(
                                text = "${stageResult.position}.",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold,
                            )
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

                // Name of the team
                Text(
                    text = teamResult.fullName,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }


            if(stageResult != null) {
                // Final time and Time Behind (only if the stageResult isn't null)
                if(stageResult.statusCode == StatusCode.OK){
                    // The position is 0 when a position is not applicable
                    if(stageResult.position > 0 || teamResult.isNc){
                        // Show the time and difference
                        Column(
                            modifier = Modifier
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.End,
                        ){
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
                        // Show current time
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
                        text = stringResource(stageResult.statusCode.displayName),
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }
        }

    }
}