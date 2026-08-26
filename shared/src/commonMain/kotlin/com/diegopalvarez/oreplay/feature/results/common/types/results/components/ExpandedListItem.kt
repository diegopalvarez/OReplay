package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.OverallResult
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.generic_stage
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ExpandedListParent(
    part: OverallResult,
    isNC: Boolean,
    trailingContent: @Composable (OverallResult, Boolean) -> Unit,
) {
    ListItem(
        onClick = { },
        enabled = true,
        leadingContent = null,
        trailingContent = {
            // Result for this stage
            trailingContent(part, isNC)
        },
        overlineContent =   if(part.contributory != null && !part.contributory) {
                                {
                                    DroppedText()
                                }
                            } else null,
        supportingContent = null,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        ),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
    ) {
        // Name of this stage part
        if(part.stage != null) {
            Text(
                text = part.stage.description,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        else{
            Text(
                text = "${stringResource(Res.string.generic_stage)} ${part.stageOrder}",
            )
        }

    }
}