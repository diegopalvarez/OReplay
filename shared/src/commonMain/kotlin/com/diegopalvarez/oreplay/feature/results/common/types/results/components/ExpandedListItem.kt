package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.Overall
import com.diegopalvarez.oreplay.domain.model.OverallResult
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.types.UploadType
import com.diegopalvarez.oreplay.ui.util.RunnerClassFormatter
import com.diegopalvarez.oreplay.ui.util.StageClubFormatter
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.collapse_arrow
import oreplay.shared.generated.resources.collapse_icon
import oreplay.shared.generated.resources.expand_arrow
import oreplay.shared.generated.resources.expand_icon
import oreplay.shared.generated.resources.generic_stage
import org.jetbrains.compose.resources.painterResource
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