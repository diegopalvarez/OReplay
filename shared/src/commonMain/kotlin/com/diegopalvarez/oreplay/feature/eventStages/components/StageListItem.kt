package com.diegopalvarez.oreplay.feature.eventStages.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.ui.util.StageTypeToText
import com.diegopalvarez.oreplay.ui.util.display
import kotlinx.coroutines.launch
import kotlinx.datetime.TimeZone

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun StageListItem(
    stage: Stage,
    onStageClick: (Stage) -> Unit,
    timezone: TimeZone,
) {
    SegmentedListItem(
        shapes = ListItemDefaults.shapes(),
        enabled = true,
        leadingContent = null,
        trailingContent = null,
        overlineContent = null,
        supportingContent = null,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 2.dp),
        onClick = {
            onStageClick(stage)
        },
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    ){
        Column {
            if(stage.description.isBlank()){
                StageTypeToText(stage.stageType)
            }
            else{
                Text(
                    text = stage.description,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            if(stage.start != null){
                Row {
                    Text(
                        text = stage.start.display(timezone),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }

        }
    }
}