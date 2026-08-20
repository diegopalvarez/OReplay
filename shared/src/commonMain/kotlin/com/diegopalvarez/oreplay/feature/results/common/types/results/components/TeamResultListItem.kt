 package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.ResultTeam
import kotlin.time.Instant

 @OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun TeamResultListItem(
     runner: ResultTeam,
     now: State<Instant>?,
     isClubView: Boolean,
     showTicketDrawer: (ResultIndividual) -> Unit,
) {
     val result = runner.stageResult

     // If the result is null, there's an error and only the basic information can be displayed
     if (result == null) {
         // Basic Item
     } else {
         //If the result is complete, handle all the different information
         // Get the status code of the runner and their position
         val statusCode = runner.stageResult.statusCode
         val position = runner.stageResult.position

     }
 }