package com.diegopalvarez.oreplay.feature.events.screens.futureEvents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.events.common.EventScreen
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.future_events_title
import oreplay.shared.generated.resources.no_future_events
import oreplay.shared.generated.resources.no_live_events
import org.jetbrains.compose.resources.stringResource

@Composable
fun FutureEventsScreen(
    component: FutureEventsComponent,
) {
    EventScreen(
        component = component,
        notFoundMessage = Res.string.no_future_events
    )
}