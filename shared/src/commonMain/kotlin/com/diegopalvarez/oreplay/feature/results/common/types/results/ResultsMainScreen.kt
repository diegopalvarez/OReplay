package com.diegopalvarez.oreplay.feature.results.common.types.results

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.domain.types.StageType
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.TicketSheetRouter
import com.diegopalvarez.oreplay.feature.results.common.types.results.screen.ClassicResultsScreen
import com.diegopalvarez.oreplay.feature.results.common.types.results.screen.OverallResultsScreen
import com.diegopalvarez.oreplay.feature.results.common.types.results.screen.RelayResultsScreen
import com.diegopalvarez.oreplay.feature.results.common.types.results.screen.ScoreResultsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultsMainScreen(
    component: ResultsComponent
) {
    // Router to the different type of result views depending on the stage type

    // Get the type of result from the component
    val resultType = component.getStageType()

    /**
     * Create the Modal Bottom Sheet for the Ticket View
     */
    val sheetState = rememberModalBottomSheetState()
    val showBottomSheet = component.ticketDrawerState.subscribeAsState()

    /**
     * Subscribe to the parameters of the Modal Bottom Sheet
     */
    val ticketRunner = component.ticketRunner.subscribeAsState()
    val ticketStageType = component.getStageType()
    val eventTimezone = component.getEventTimezone()

    when (resultType) {
        StageType.CLASSIC -> ClassicResultsScreen(component)
        StageType.MASS_START -> TODO("Implement in the whole app")
        StageType.CHASE_START -> TODO("Implement in the whole app")
        StageType.OVERALL -> OverallResultsScreen(component)
        StageType.RELAY -> RelayResultsScreen(component)
        StageType.SCORE -> ScoreResultsScreen(component)
        StageType.RAID -> TODO("Implement in the whole app")
        StageType.TRAIL -> TODO("Implement in the whole app")
        StageType.ONE_MAN_RELAY -> ClassicResultsScreen(component)
        StageType.RANKING -> TODO("Implement in the whole app")
    }

    // Create the content of the Modal Bottom Sheet
    if(showBottomSheet.value){
        ModalBottomSheet(
            onDismissRequest = component::hideTicketModal,
            sheetState = sheetState,
        ) {
            // Ticket Content
            TicketSheetRouter(
                runner = ticketRunner.value,
                stageType = ticketStageType,
                eventTimezone = eventTimezone
            )
        }
    }
}