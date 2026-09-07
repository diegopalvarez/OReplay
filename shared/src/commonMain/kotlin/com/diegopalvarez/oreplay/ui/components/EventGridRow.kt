package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.Event

@Composable
fun EventGridRow(
    events: List<Event>,
    onEventClick: (Event) -> Unit,
    minCardHeight: Dp,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        events.forEach { event ->
            EventGridItem(
                event = event,
                onEventClick = onEventClick,
                modifier = Modifier
                    .weight(1f)
                    .heightIn(min = minCardHeight)
                    .fillMaxHeight()
            )
        }

        // If this row only has one event, add a spacer
        if(events.size == 1){
            Spacer(
                modifier = Modifier
                .weight(1f)
                    .fillMaxHeight()
            )
        }
    }
}