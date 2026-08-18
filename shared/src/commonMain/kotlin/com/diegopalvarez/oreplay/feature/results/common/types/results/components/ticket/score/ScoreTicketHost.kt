package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.score

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.ScoreResultsComponent

@Composable
fun ScoreTicketHost(
    component: ScoreResultsComponent,
    result: StageResult
) {
    // Subscribe to the current active page
    val pages = component.pages.subscribeAsState()

    // Show the different views depending on the active page
    when(val child = pages.value.items[pages.value.selectedIndex].instance) {
        is ScoreResultsComponent.TicketTabChild.ScoreView -> ScoreTicketPoints(result)
        is ScoreResultsComponent.TicketTabChild.TableView -> ScoreTicketTable(result)
        null -> TODO("This shouldn't be a possibility")
    }
}