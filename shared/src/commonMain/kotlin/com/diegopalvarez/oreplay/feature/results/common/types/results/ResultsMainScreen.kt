package com.diegopalvarez.oreplay.feature.results.common.types.results

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.diegopalvarez.oreplay.domain.types.StageType
import com.diegopalvarez.oreplay.feature.results.common.types.results.screen.ClassicResultsScreen
import com.diegopalvarez.oreplay.feature.results.common.types.results.screen.OverallResultsScreen
import com.diegopalvarez.oreplay.feature.results.common.types.results.screen.RelayResultsScreen
import com.diegopalvarez.oreplay.feature.results.common.types.results.screen.ScoreResultsScreen

@Composable
fun ResultsMainScreen(
    component: ResultsComponent
) {
    // Router to the different type of result views depending on the stage type

    // Get the type of result from the component
    val resultType = component.getStageType()

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
}