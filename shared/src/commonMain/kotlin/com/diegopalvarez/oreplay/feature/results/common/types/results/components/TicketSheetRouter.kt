package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.runtime.Composable
import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.ResultTeam
import com.diegopalvarez.oreplay.domain.types.StageType
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.classic.ClassicTicketSheet
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.oneManRelay.OneManRelayTicketSheet
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.relay.RelayTicketSheet
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.score.ScoreTicketSheet
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.CommonResultComponent
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.ScoreResultsComponent
import com.diegopalvarez.oreplay.feature.results.common.util.Optional
import com.diegopalvarez.oreplay.ui.components.ErrorHelper
import kotlinx.datetime.TimeZone

@Composable
fun TicketSheetRouter(
    runner: Optional<ResultIndividual>,
    team: Optional<ResultTeam>,
    stageType: StageType,
    eventTimezone: TimeZone,
    component: CommonResultComponent,
) {
    var runnerResult: ResultIndividual? = null

    // Check if the runner is set up
    runnerResult = when (runner) {
        Optional.None -> null
        is Optional.Some -> runner.value
    }

    if(runnerResult == null) {
        // There's been an error, show an error message
        ErrorHelper(RepositoryError.INTERNAL)
    }
    else{
        // Route the contents of the ticket to the corresponding Composable
        when(stageType){
            StageType.CLASSIC -> ClassicTicketSheet(runnerResult, eventTimezone)
            StageType.MASS_START -> TODO("Implement in the whole app")
            StageType.CHASE_START -> TODO("Implement in the whole app")
            StageType.OVERALL -> TODO()
            StageType.RELAY -> {
                // Check if the team is set up
                when(team){
                    Optional.None -> ErrorHelper(RepositoryError.INTERNAL)
                    is Optional.Some-> RelayTicketSheet(runnerResult, team.value, eventTimezone)
                }
            }
            StageType.SCORE -> ScoreTicketSheet(runnerResult, eventTimezone, component as ScoreResultsComponent)
            StageType.RAID -> TODO("Implement in the whole app")
            StageType.TRAIL -> TODO("Implement in the whole app")
            StageType.ONE_MAN_RELAY -> OneManRelayTicketSheet(runnerResult, eventTimezone)
            StageType.RANKING -> TODO("Implement in the whole app")
        }
    }
}