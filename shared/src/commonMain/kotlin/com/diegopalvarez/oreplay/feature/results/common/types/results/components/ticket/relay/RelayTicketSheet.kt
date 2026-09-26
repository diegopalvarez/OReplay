package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.relay

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.ResultTeam
import com.diegopalvarez.oreplay.domain.model.ResultTeamRunner
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.common.NoChipDownload
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.common.TicketSheet
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.oneManRelay.OneManRelayTicketSplitTable
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.CommonResultComponent
import com.diegopalvarez.oreplay.ui.components.ScrollableLazyColumn
import kotlinx.datetime.TimeZone

@Composable
fun RelayTicketSheet(
    runnerResult: ResultTeamRunner,
    teamResult: ResultTeam,
    eventTimezone: TimeZone,
    component: CommonResultComponent
) {
    // Get the runner individual result
    val individualResult = runnerResult.individualResult

    ScrollableLazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        // Information about the team and the runner
        item {
            TeamInformationHeader(teamResult, individualResult, component)
        }

        // Information about the team and runner results
        if (teamResult.stageResult != null && individualResult.stageResult != null) {
            val runnerLeg = individualResult.legNumber.toInt() - 1      // The legs start at 1
            item {
                TeamResultsHeader(
                    individualResult.stageResult,
                    runnerResult.teamPositions,
                    runnerResult.teamAccumulatedTime,
                    runnerResult.teamTimeBehind,
                    runnerResult.isAccumulatedError,
                    teamResult.stageResult.statusCode,
                    eventTimezone
                )
            }

            if (individualResult.stageResult.statusCode != StatusCode.DID_NOT_START) {
                if(individualResult.stageResult.finishTime != null){    // Only show splits table if the runner has finished
                    item {
                        // The table of splits is the same as in the One-Man Relay
                        OneManRelayTicketSplitTable(individualResult.stageResult)
                    }
                }
                else{
                    // The runner hasn't finished yet
                    item {
                        NoChipDownload()
                    }
                }

            } else {
                item {
                    NoChipDownload()
                }
            }
        } else {
            // The runner hasn't downloaded their chip yet
            item {
                NoChipDownload()
            }
        }
    }
}