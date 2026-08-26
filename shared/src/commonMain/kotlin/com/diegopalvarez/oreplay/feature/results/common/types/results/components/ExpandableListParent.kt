package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.Overall
import com.diegopalvarez.oreplay.domain.model.OverallResult
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.ui.util.RunnerClassFormatter
import com.diegopalvarez.oreplay.ui.util.StageClubFormatter
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.collapse_arrow
import oreplay.shared.generated.resources.collapse_icon
import oreplay.shared.generated.resources.expand_arrow
import oreplay.shared.generated.resources.expand_icon
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ExpandableListParent(
    runner: ResultIndividual,
    isClubView: Boolean,
    overallResult: Overall,
    trailingContent: @Composable (OverallResult, Boolean) -> Unit,
) {
    // Create the expanded state
    var expanded by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        // Overall item header
        SegmentedListItem(
            shapes = ListItemDefaults.shapes(),
            onClick = {
                expanded = !expanded
            },
            leadingContent = resultListItemLeadingContent(runner.isNc, overallResult.overallTotal.statusCode, overallResult.overallTotal.position),
            trailingContent = {
                // Row with the total result and an arrow
                Row(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Final result
                    trailingContent(overallResult.overallTotal, runner.isNc)

                    // Show arrow to indicate if it's expanded or expandable
                    if(expanded) {
                        // Icon to collapse
                        Icon(
                            painter = painterResource(Res.drawable.collapse_arrow),
                            contentDescription = stringResource(Res.string.collapse_icon),
                        )
                    }
                    else{
                        // Icon to expand
                        Icon(
                            painter = painterResource(Res.drawable.expand_arrow),
                            contentDescription = stringResource(Res.string.expand_icon),
                        )
                    }
                }

            },
            overlineContent = null,
            supportingContent = {
                // Name of the class or the club of the runner as a supporting content for the name
                if (isClubView) {
                    // Name of the class if it's club view
                    RunnerClassFormatter(runner.runnerClass)

                } else {
                    // Name of the club if it's the class view
                    StageClubFormatter(runner.runnerClub)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 2.dp, bottom = 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            colors = ListItemDefaults.colors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
        ) {
            // Content Visible when collapsed and expanded
            Text(
                text = runner.fullName,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        // Overall item details, just visible when selected
        AnimatedVisibility(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            visible = expanded,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                for(item in overallResult.overallParts){
                    ExpandedListParent(
                        part = item,
                        isNC = runner.isNc,
                        trailingContent = trailingContent
                    )
                }
            }
        }
    }
}