package com.diegopalvarez.oreplay.feature.events.screens.liveEvents

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.events.common.ErrorHelper
import com.diegopalvarez.oreplay.feature.events.common.EventScreen
import com.diegopalvarez.oreplay.feature.events.common.SnackbarHelper
import com.diegopalvarez.oreplay.ui.components.EventGrid
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.close
import oreplay.shared.generated.resources.dismiss
import oreplay.shared.generated.resources.no_live_events
import oreplay.shared.generated.resources.see_future_events
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LiveEventsScreen(
    component: LiveEventsComponent,
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
        nextPageFunction = component::onNextPage
    )
}