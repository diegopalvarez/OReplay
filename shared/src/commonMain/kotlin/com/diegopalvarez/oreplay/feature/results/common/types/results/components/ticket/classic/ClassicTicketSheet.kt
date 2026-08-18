package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.classic

import androidx.compose.runtime.Composable
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.common.TicketSheet
import kotlinx.datetime.TimeZone

@Composable
fun ClassicTicketSheet(
    runnerResult: ResultIndividual,
    eventTimezone: TimeZone
) {
    TicketSheet(
        runnerResult,
        eventTimezone,
        ::ClassicTicketSplitTable
    )
}