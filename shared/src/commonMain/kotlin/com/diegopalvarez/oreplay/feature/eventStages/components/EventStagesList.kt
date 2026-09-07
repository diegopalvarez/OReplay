package com.diegopalvarez.oreplay.feature.eventStages.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.ui.components.NoDataScreen
import kotlinx.datetime.TimeZone

@Composable
fun EventStagesList(
    eventTimezone: TimeZone,
    stagesList: List<Stage>,
    convertTimezones: Boolean,
    onStageClick: (Stage) -> Unit,
){

    if(stagesList.isEmpty()) {
        // Show the screen for no data
        NoDataScreen()
    }
    else{
        var timezone = TimeZone.currentSystemDefault()

        // If the preference it's to not choose the timezone, and they're different, keep the event one
        // In every other case, just use the local
        if(!convertTimezones && eventTimezone != timezone) {
            timezone = eventTimezone
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp,),
        ){
            items(stagesList) { stage ->
                StageListItem(
                    stage = stage,
                    onStageClick = { onStageClick(stage) },
                    timezone = timezone
                )
            }
        }
    }

}