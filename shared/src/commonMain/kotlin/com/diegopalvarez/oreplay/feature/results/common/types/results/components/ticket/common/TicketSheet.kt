package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.classic.RunnerResultsHeader
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.CommonResultComponent
import kotlinx.datetime.TimeZone

@Composable
fun TicketSheet(
    runnerResult: ResultIndividual,
    eventTimezone: TimeZone,
    splitTable: @Composable (result: StageResult) -> Unit,
    component: CommonResultComponent
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        // Information about the runner
        item {
            RunnerInformationHeader(runnerResult, component)
        }

        // Information about the runner results
        if (runnerResult.stageResult != null) {
            item {
                RunnerResultsHeader(runnerResult.stageResult, eventTimezone)
            }

            if (runnerResult.stageResult.statusCode != StatusCode.DID_NOT_START) {
                if(runnerResult.stageResult.finishTime != null){    // Only show splits table if the runner has finished
                    item {
                        // Table of splits
                        splitTable(runnerResult.stageResult)
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