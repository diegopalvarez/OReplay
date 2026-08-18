package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.score

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.repository.util.ScoreResultStats
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.ScoreTabComponent
import com.diegopalvarez.oreplay.feature.results.common.util.Optional

@Composable
fun ScoreTicketPoints(
    result: StageResult,
    visited: Optional<ScoreResultStats>
) {
    // Get the list of all controls the runner has visited
    val runnerControls = result.splits.map { it.control.station }

    // Check if the stats are valid
    when(visited){
        Optional.None -> {
            // Show error message
        }
        is Optional.Some -> {
            val stats = visited.value
            FlowRow(
                modifier = Modifier
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Start,
                verticalArrangement = Arrangement.Center,
            ){
                // TODO - Find a better way to exclude the Finish control
                for ((control, number) in stats.visited.entries.sortedBy { it.key }.dropLast(1)) {
                    val isVisited = runnerControls.contains(control)
                    ScoreControlCircle(
                        control = control,
                        visited = isVisited,
                        numberOfVisitors = number,
                        totalRunners = stats.runners,
                    )
                }
            }
        }
    }

}