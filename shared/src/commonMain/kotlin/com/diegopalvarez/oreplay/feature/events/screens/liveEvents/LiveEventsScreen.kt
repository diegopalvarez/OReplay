package com.diegopalvarez.oreplay.feature.events.screens.liveEvents

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.feature.events.common.EventScreen
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_live_events
import oreplay.shared.generated.resources.see_future_events
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LiveEventsScreen(
    component: LiveEventsComponent,
    onEventClick: (Event) -> Unit,
    goToFutureEvents: () -> Unit,
) {
    EventScreen(
        component = component,
        notFoundButton = {
            Button(
                onClick = goToFutureEvents,
            ){
                Text(
                    text = stringResource(Res.string.see_future_events),
                    style = MaterialTheme.typography.labelSmall,
                )
            }
        },
        notFoundMessage = Res.string.no_live_events,
        nextPageFunction = component::onNextPage,
        onEventClick = onEventClick,
    )
}