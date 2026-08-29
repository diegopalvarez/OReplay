package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.classic

import androidx.compose.runtime.Composable
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.common.TicketSheet
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.CommonResultComponent
import kotlinx.datetime.TimeZone

@Composable
fun ClassicTicketSheet(
    runnerResult: ResultIndividual,
    eventTimezone: TimeZone,
    component: CommonResultComponent
) {
    TicketSheet(
        runnerResult,
        eventTimezone,
        ::ClassicTicketSplitTable,
        component
    )
}