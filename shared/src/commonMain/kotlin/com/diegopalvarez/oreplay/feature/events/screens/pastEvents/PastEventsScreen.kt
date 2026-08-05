package com.diegopalvarez.oreplay.feature.events.screens.pastEvents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.feature.events.common.EventScreen
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_future_events
import oreplay.shared.generated.resources.no_past_events
import oreplay.shared.generated.resources.past_events_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun PastEventsScreen(
    component: PastEventsComponent,
    onEventClick: (Event) -> Unit
) {
    EventScreen(
        component = component,
        notFoundMessage = Res.string.no_past_events,
        nextPageFunction = component::onNextPage,
        onEventClick = onEventClick,
    )
}