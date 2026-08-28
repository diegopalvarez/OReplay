package com.diegopalvarez.oreplay.feature.results.common.types.splits.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.results.common.types.splits.navigation.SplitsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.common.SplitsTable
import com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.common.rememberCellWidth
import com.diegopalvarez.oreplay.feature.results.common.util.Optional
import com.diegopalvarez.oreplay.ui.components.NoDataScreen
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_splits

@Composable
fun SplitsContent(
    component: SplitsComponent
) {
    // Subscribe to the selected tab
    val pages = component.pages.subscribeAsState()

    // Subscribe to the list of results
    val results = component.sortedResults.subscribeAsState()

    // Subscribe to the widest string from the results
    val widestString = component.widestString.subscribeAsState()

    // TODO - Study and optimize screen freezing when changing to this tab
    // Compute the cell width for the widest string
    val cellWidth = rememberCellWidth(widestString.value)

    // Change the splits view depending on the selected tab
    val isAccumulated = rememberSaveable{ mutableStateOf(false) }

    when(val child = pages.value.items[pages.value.selectedIndex].instance) {
        is SplitsComponent.SplitsTabChild.Partials -> isAccumulated.value = false
        is SplitsComponent.SplitsTabChild.Accumulated -> isAccumulated.value = true
        null -> TODO()
    }

    when(val list = results.value){
        Optional.None -> {
            // The results haven't been loaded yet, show a loading spinner
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }
        is Optional.Some -> {
            if(list.value.isNotEmpty()) {
                SplitsTable(
                    controls = list.value.first().stageResult!!.splits,       // The stageResults are forced to be not null
                    runners = list.value,
                    cellWidth = cellWidth,
                    isAccumulated = isAccumulated,
                )
            }
            else{
                // If the results have been processed but are empty, show a No Data Screen
                NoDataScreen(Res.string.no_splits)
            }
        }
    }
}