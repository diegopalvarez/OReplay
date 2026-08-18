 package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.domain.types.getStatusCode
import com.diegopalvarez.oreplay.ui.util.RunnerClassFormatter
import com.diegopalvarez.oreplay.ui.util.StageClubFormatter
import com.diegopalvarez.oreplay.ui.util.display
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.nc_position
import org.jetbrains.compose.resources.stringResource
import kotlin.time.Instant

 @OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ResultListItem(
     runner: ResultIndividual,
     now: State<Instant>?,
     isClubView: Boolean,
     showTicketDrawer: (ResultIndividual) -> Unit,
) {
     val result = runner.stageResult

     // If the result is null, there's an error and only the basic information can be displayed
     if (result == null) {
         BasicResultListItem(runner, isClubView)
     } else {
         //If the result is complete, handle all the different information
         // Get the status code of the runner and their position
         val statusCode = runner.stageResult.statusCode.getStatusCode()
         val position = runner.stageResult.position
         BasicResultListItem(
             runner = runner,
             isClubView = isClubView,
             leadingContent = resultListItemLeadingContent(runner.isNc, statusCode, position),
             trailingContent = classicListItemTrailingContent(runner.isNc, result, statusCode, now, position),
             showTicketDrawer = showTicketDrawer,
         )
     }
 }