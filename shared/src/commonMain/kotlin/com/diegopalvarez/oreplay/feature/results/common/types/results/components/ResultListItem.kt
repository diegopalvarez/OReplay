 package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.domain.types.getStatusCode
import com.diegopalvarez.oreplay.ui.util.RunnerClassFormatter
import com.diegopalvarez.oreplay.ui.util.StageClubFormatter
import com.diegopalvarez.oreplay.ui.util.display
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.nc_position
import org.jetbrains.compose.resources.stringResource
import kotlin.time.Instant

 @OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ResultListItem(
    runner: ResultIndividual,
    now: State<Instant>?,
    isClubView: Boolean,
    showTicketDrawer: () -> Unit,
) {
    val result = runner.stageResult

    // If the result is null, there's an error and only the basic information can be displayed
    if(result == null){
        SegmentedListItem(
            shapes = ListItemDefaults.shapes(),
            onClick = { showTicketDrawer() },
            enabled = true,
            leadingContent = null,
            trailingContent = null,
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
    else{
        //If the result is complete, handle all the different information
        // Get the status code of the runner and their position
        val statusCode = runner.stageResult.statusCode.getStatusCode()
        val position = runner.stageResult.position
        SegmentedListItem(
            shapes = ListItemDefaults.shapes(),
            onClick = { showTicketDrawer() },
            enabled = true,
            leadingContent =    if(runner.isNc){
                                    {
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
                                        {
                                            Text(
                                                text = "${runner.stageResult.position}.",
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
                                },
            trailingContent = {
                // Column containing the final time and the time difference, if the result OK and has a position
                // In case of a runner that hasn't finished, show the current time
                // In case of an error, show its code

                if(statusCode == StatusCode.OK){
                    // The position is 0 when a position is not applicable
                    if(position > 0){
                        // Show the time and difference
                        Column(
                            modifier = Modifier
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.End,
                        ){
                            // Final time
                            Text(
                                text = runner.stageResult.timeSeconds.display(),
                                style = MaterialTheme.typography.bodyMedium,
                            )
                            // Time difference
                            Text(
                                text = "+${runner.stageResult.timeBehind.display()}",
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        }
                    }
                    else{
                        // Show current time
                        // TODO - Maybe change to monospace font
                        val startTime = runner.stageResult.startTime
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
            },
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

}