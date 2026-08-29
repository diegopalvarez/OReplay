package com.diegopalvarez.oreplay.feature.results.common.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun DialogListItem(
    displayName: String,
    id: String,
    navigationName: String,
    isClub: Boolean,
    onClick: (id: String, name: String, isClub: Boolean) -> Unit,
    isSelected: Boolean,
) {
    // List item shapes
    val shapes = ListItemDefaults.shapes()

    ListItem(
        shapes = shapes,
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {
            onClick(id, navigationName, isClub)
        },
        colors = ListItemDefaults.colors(
            containerColor =    if(isSelected){
                                    MaterialTheme.colorScheme.tertiaryContainer
                                }
                                else{
                                    MaterialTheme.colorScheme.surfaceVariant
                                },
        ),
    ){
        Text(
            text = displayName,
            color = if(isSelected){
                        MaterialTheme.colorScheme.onTertiaryContainer
                    }
                    else{
                        MaterialTheme.colorScheme.onSurfaceVariant
                    },
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}