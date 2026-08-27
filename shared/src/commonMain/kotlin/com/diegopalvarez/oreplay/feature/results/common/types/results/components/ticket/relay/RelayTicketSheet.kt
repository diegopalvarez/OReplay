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
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.common.NoChipDownload
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.common.TicketSheet
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.oneManRelay.OneManRelayTicketSplitTable
import kotlinx.datetime.TimeZone

@Composable
fun RelayTicketSheet(
    runnerResult: ResultIndividual,
    teamResult: ResultTeam,
    eventTimezone: TimeZone
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        // Information about the team and the runner
        item {
            TeamInformationHeader(teamResult, runnerResult)
        }

        // Information about the team and runner results
        if (teamResult.stageResult != null && runnerResult.stageResult != null) {
            val runnerLeg = runnerResult.legNumber.toInt() - 1      // The legs start at 1
            item {
                TeamResultsHeader(
                    runnerResult.stageResult,
                    teamResult.teamPositions[runnerLeg],
                    teamResult.teamAccumulatedTime[runnerLeg],
                    teamResult.teamTimeBehind[runnerLeg],
                    teamResult.isAccumulatedError[runnerLeg],
                    teamResult.stageResult.statusCode,
                    eventTimezone
                )
            }

            if (runnerResult.stageResult.statusCode != StatusCode.DID_NOT_START) {
                if(runnerResult.stageResult.finishTime != null){    // Only show splits table if the runner has finished
                    item {
                        // The table of splits is the same as in the One-Man Relay
                        OneManRelayTicketSplitTable(runnerResult.stageResult)
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