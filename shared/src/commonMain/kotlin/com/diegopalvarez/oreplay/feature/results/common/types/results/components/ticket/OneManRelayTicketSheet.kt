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
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.domain.types.getStatusCode
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.NoPartialSplitTime
import kotlinx.datetime.TimeZone

@Composable
fun OneManRelayTicketSheet(
    runnerResult: ResultIndividual,
    eventTimezone: TimeZone
) {
    TicketSheet(
        runnerResult,
        eventTimezone,
        ::OneManRelayTicketSplitTable
    )
}