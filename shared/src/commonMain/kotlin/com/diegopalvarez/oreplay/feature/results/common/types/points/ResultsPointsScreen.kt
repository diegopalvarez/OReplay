package com.diegopalvarez.oreplay.feature.results.common.types.points

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.results.common.types.points.components.PointsTable
import com.diegopalvarez.oreplay.feature.results.common.types.splits.navigation.SplitsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.common.SplitsTable
import com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.common.rememberCellWidth

@Composable
fun ResultsPointsScreen(
    component: PointsComponent,
    classID: String?,
) {
    // Subscribe to the list of results
    val results = component.individualResults.subscribeAsState()

    // Get the list of all points for this race
    val classControls = component.getVisitedStats(classID)

    // TODO - Investigate cause of small delay when changing to points tab

    if(results.value.isNotEmpty()) {
        PointsTable(
            runners = results.value,
            visitedStats = classControls
        )
    }
    else{
        // Show loading spinner
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }
}