package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.oneManRelay

import androidx.compose.runtime.Composable
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.common.TicketSheet
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.CommonResultComponent
import kotlinx.datetime.TimeZone

@Composable
fun OneManRelayTicketSheet(
    runnerResult: ResultIndividual,
    eventTimezone: TimeZone,
    component: CommonResultComponent
) {
    TicketSheet(
        runnerResult,
        eventTimezone,
        ::OneManRelayTicketSplitTable,
        component
    )
}