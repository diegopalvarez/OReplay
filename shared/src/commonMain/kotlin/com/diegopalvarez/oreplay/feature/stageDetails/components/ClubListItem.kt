package com.diegopalvarez.oreplay.feature.stageDetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.ui.util.StageTypeToText
import com.diegopalvarez.oreplay.ui.util.display

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ClubListItem(
    club: StageClub,
    onClick: (StageClub) -> Unit,
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
            onClick(club)
        },
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    ){
        Text(
            text = club.shortName,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}