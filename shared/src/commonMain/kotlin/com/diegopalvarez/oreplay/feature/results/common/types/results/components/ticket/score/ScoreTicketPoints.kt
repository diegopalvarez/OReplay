package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.score

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
            Column(

            ){
                for ((control, number) in stats.visited.entries){
                    if(runnerControls.contains(control)){
                        Text("YES - $control - ${number}/${stats.runners}")
                    }
                    else{
                        Text("NO - $control - ${number}/${stats.runners}")
                    }
                }
            }
        }
    }

}