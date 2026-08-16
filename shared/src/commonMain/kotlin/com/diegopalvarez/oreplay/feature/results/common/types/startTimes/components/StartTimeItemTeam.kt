package com.diegopalvarez.oreplay.feature.results.common.types.startTimes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.ListItemElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.ResultTeam
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.domain.types.getStatusCode
import com.diegopalvarez.oreplay.ui.util.RunnerClassFormatter
import com.diegopalvarez.oreplay.ui.util.StageClubFormatter
import com.diegopalvarez.oreplay.ui.util.displayTime
import kotlinx.datetime.TimeZone
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_start_time
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun StartTimeItemTeam(
    team: ResultTeam,
    timezone: TimeZone,
    isClubView: Boolean = false,
) {
    SegmentedListItem(
        shapes = ListItemDefaults.shapes(),
        onClick = { },
        enabled = true,
        leadingContent = null,
        trailingContent = {
            // Column with the start time of the team as trailing content
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                if (team.stageResult != null){
                    if(team.stageResult.startTime != null) {
                        Text(
                            text = team.stageResult.startTime.displayTime(timezone),
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }
                    else if(team.stageResult.statusCode.getStatusCode() != StatusCode.OK){
                        Text(
                            text = stringResource(team.stageResult.statusCode.getStatusCode().displayName),
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }
                }
                else {
                    Text(
                        text = stringResource(Res.string.no_start_time),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
        },
        overlineContent = null,
        supportingContent = {
            // Names of the members of the team as supporting content

            // Order the team members by team number
            val orderedMembers = team.runners.sortedBy { it.legNumber }
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                for(member in orderedMembers){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start)
                    ) {
                        // Number of the member in the team
                        Text(
                            text = "${member.legNumber}.",
                            style = MaterialTheme.typography.bodySmall,
                        )

                        Text(
                            text = member.fullName,
                            style = MaterialTheme.typography.bodySmall,
                        )
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
    ){
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ){
            // Name of the TEAM as the main content
            Text(
                text = team.fullName,
                color = MaterialTheme.colorScheme.onSurface
            )

            // Name of the class or the club of the runner as a supporting content for the name
            if (isClubView) {
                // Name of the class if it's club view
                RunnerClassFormatter(team.teamClass)

            }
            else{
                // Name of the club if it's the class view
                StageClubFormatter(team.teamClub)
            }
        }

    }
}