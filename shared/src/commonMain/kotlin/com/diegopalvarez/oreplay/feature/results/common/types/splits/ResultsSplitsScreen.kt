package com.diegopalvarez.oreplay.feature.results.common.types.splits

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.diegopalvarez.oreplay.feature.results.common.types.splits.components.SplitsContent
import com.diegopalvarez.oreplay.feature.results.common.types.splits.components.SplitsTabRow
import com.diegopalvarez.oreplay.feature.results.common.types.splits.navigation.SplitsComponent

@Composable
fun ResultsSplitsScreen(
    component: SplitsComponent
) {
    // Create tabs for the different splits
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Tabs
        SplitsTabRow(component)

        // Content of the page
        SplitsContent(component)
    }
}