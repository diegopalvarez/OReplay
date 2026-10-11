package com.diegopalvarez.oreplay.feature.results.common.util

import androidx.compose.material3.ListItemColors
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun resultColor(isUpdate: Boolean): ListItemColors {
    return when(isUpdate){
        true -> ListItemDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                )
        false -> ListItemDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                )
    }
}

@Composable
fun teamResultColor(isUpdate: Boolean): ListItemColors {
    return when(isUpdate){
        true -> ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
        )
        false -> ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSurface,
        )
    }
}