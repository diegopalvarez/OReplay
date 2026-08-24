package com.diegopalvarez.oreplay.feature.results.common.types.legs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.results.common.types.legs.components.LegsContent
import com.diegopalvarez.oreplay.feature.results.common.types.legs.components.LegsTabRow
import com.diegopalvarez.oreplay.feature.results.common.types.splits.components.SplitsContent
import com.diegopalvarez.oreplay.feature.results.common.types.splits.components.SplitsTabRow
import com.diegopalvarez.oreplay.ui.components.NoDataScreen

@Composable
fun ResultsLegScreen(
    component: LegsComponent
) {
    // Subscribe to the results
    val results = component.results.subscribeAsState()

    // Create tabs for the different legs of this relay
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Tabs
        LegsTabRow(component)

        if(results.value.isNotEmpty()){
            // Content of the page
            LegsContent(component)
        }
        else{
            NoDataScreen()
        }


    }
}