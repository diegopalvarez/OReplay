package com.diegopalvarez.oreplay.feature.results.common.types.points.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.SplitIndividual
import com.diegopalvarez.oreplay.domain.repository.util.ScoreResultStats
import com.diegopalvarez.oreplay.feature.results.common.util.Optional
import com.diegopalvarez.oreplay.ui.components.NoDataScreen

@Composable
fun PointsTable(
    modifier: Modifier = Modifier,
    runners: List<ResultIndividual>,
    visitedStats: Optional<ScoreResultStats>
) {
    // Create and remember the scroll state
    val scrollState = rememberScrollState()

    // Define the cell width
    val cellWidth = 100.dp

    // Create the table
    if(runners.isEmpty()) {
        NoDataScreen()
    }
    else{
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            // Table Header
            PointsTableHeader(
                scrollState = scrollState,
                columnWidth = cellWidth,
                visitedStats = visitedStats
            )

            // Table Contents
            PointsTableContent(
                scrollState = scrollState,
                runners = runners,
                columnWidth = cellWidth,
                visitedStats = visitedStats
            )

        }
    }
}