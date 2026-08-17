package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import kotlinx.datetime.TimeZone

@Composable
fun ClassicTicketSheet(
    runnerResult: ResultIndividual,
    eventTimezone: TimeZone
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        // Information about the runner
        item{
            RunnerInformationHeader(runnerResult)
        }

        // Information about the runner results
        if(runnerResult.stageResult != null){
            item {
                RunnerResultsHeader(runnerResult.stageResult, eventTimezone)
            }

            item {
                // Table of splits
                ClassicTicketSplitTable(runnerResult.stageResult)
            }
        }
        else{
            // The runner hasn't downloaded their chip yet
        }

    }
}