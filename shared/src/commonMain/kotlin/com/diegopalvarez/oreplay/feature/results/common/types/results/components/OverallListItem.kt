 package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.types.UploadType
import kotlin.time.Instant
 @OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun OverallListItem(
     runner: ResultIndividual,
     isClubView: Boolean,
) {
     val overallResult = runner.overallResult

     // If the overall result is null, there's an error and only the basic information can be displayed
     if (overallResult == null) {
         BasicResultListItem(runner, false)
     } else {
         //If the overall result is complete, show the expandable list
         if(overallResult.overallTotal.uploadType == UploadType.TOTAL_TIMES){
             // Time-based overall
             ExpandableListParent(
                 runner = runner,
                 isClubView = isClubView,
                 overallResult = overallResult,
                 trailingContent = ::OverallTimeTrailingContent,
             )
         }
         else{
             // Point-based overall
             ExpandableListParent(
                 runner = runner,
                 isClubView = isClubView,
                 overallResult = overallResult,
                 trailingContent = ::OverallPointsTrailingContent,
             )
         }
     }
 }