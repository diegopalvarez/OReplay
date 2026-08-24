 package com.diegopalvarez.oreplay.feature.results.common.types.legs.components

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.diegopalvarez.oreplay.domain.model.RelayLegResult
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.BasicResultListItem
import kotlin.time.Instant

 @OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LegListItem(
     runner: RelayLegResult,
     now: State<Instant>?,
) {
     val result = runner.result.stageResult

     // If the result is null, there's an error and only the basic information can be displayed
     if (result == null) {
         BasicResultListItem(runner.result, false)
     } else {
         //If the result is complete, handle all the different information
         LegResultListItem(
             runner = runner.result,
             result = result,
             teamName = runner.teamName,
             now = now,
             teamPosition = runner.accumulatedPosition,
             previousPosition = runner.previousPosition,
             teamError = runner.teamError,
         )
     }
 }