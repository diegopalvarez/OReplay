package com.diegopalvarez.oreplay.feature.results.common.types.points.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.repository.util.ScoreResultStats
import kotlin.collections.component1
import kotlin.collections.component2

@Composable
fun VisitedControlsRow(
    result: StageResult,
    visitedStats: ScoreResultStats
) {
    // Get the list of all controls the runner has visited
    val runnerControls = result.splits.map { it.control.station }

    // Show the row of controls
    Row{
        // TODO - Find a better way to exclude the Finish control
        for ((control, number) in visitedStats.visited.entries.filterNot { it.key == "Finish" } .sortedBy { it.key.toLong() }) {
            val isVisited = runnerControls.contains(control)
            ScorePointsCircle(
                control = control,
                visited = isVisited
            )
        }
    }
}