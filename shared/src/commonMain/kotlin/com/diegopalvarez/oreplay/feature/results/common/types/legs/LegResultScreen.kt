package com.diegopalvarez.oreplay.feature.results.common.types.legs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.results.common.types.legs.components.LegListItem
import com.diegopalvarez.oreplay.feature.results.common.types.legs.navigation.LegResultComponent
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ResultListItem
import com.diegopalvarez.oreplay.ui.components.NoDataScreen
import kotlin.time.Instant

@Composable
fun LegResultScreen(
    component: LegResultComponent
) {
    // Subscribe to the results of the leg
    val legResults = component.legResults.subscribeAsState()

    // Get if the event is live or not
    val isLive = component.isLive()

    var now: State<Instant>? = null
    if(isLive){
        now = component.now.collectAsStateWithLifecycle()
    }

    if(legResults.value.isNotEmpty()){
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(legResults.value){ result ->
                LegListItem(result, now)
            }
        }
    }
    else{
        NoDataScreen()
    }
}