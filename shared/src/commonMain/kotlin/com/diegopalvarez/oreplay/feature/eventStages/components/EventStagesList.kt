package com.diegopalvarez.oreplay.feature.eventStages.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.Stage
import kotlinx.datetime.TimeZone

@Composable
fun EventStagesList(
    eventTimezone: TimeZone,
    stagesList: List<Stage>
){
    // Variable to show the modal or not
    val showWarning = remember { mutableStateOf(false) }

    // If the TimeZones are different, show message
    if(eventTimezone != TimeZone.currentSystemDefault()){
        showWarning.value = true
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ){
        items(stagesList) { stage ->
            StageListItem(
                stage = stage,
                onStageClick = {}
            )
        }
    }
}