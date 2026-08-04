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
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
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
    contentPadding: PaddingValues
) {
    // Subscribe to the list of Live Events
    val liveEventList = component.liveEventList.subscribeAsState()

    // Subscribe to the isRefreshing variable
    val isRefreshing = component.isRefreshing.subscribeAsState()

    // Subscribe to the Error Indicator
    val isError = component.isError.subscribeAsState()

    // Subscribe to the Error Type
    val errorType = component.errorType.subscribeAsState()

    // Subscribe to isInit
    val isInit = component.isInit.subscribeAsState()

    // Create PullToRefresh state
    val refreshState = rememberPullToRefreshState()

    // Create SnackBar State
    val snackbarHostState = remember { SnackbarHostState() }

    // Bind Helper to this Snackbar
    SnackbarHelper(
        state = snackbarHostState,
        isError = isError,
        errorType = errorType,
        isInit = isInit,
    )

    // Create Pull-To-Refresh box for the Live Events
    PullToRefreshBox(
        isRefreshing = isRefreshing.value,
        onRefresh = component::onRefresh,
        state = refreshState,
        modifier = Modifier
            .padding(contentPadding),
        indicator = {
            Indicator(
                modifier = Modifier.align(Alignment.TopCenter),
                isRefreshing = isRefreshing.value,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                state = refreshState
            )
        }
    ){
        // Content of the actual screen

        // If the data hasn't been initialized, show a big error message
        if(!isInit.value && isError.value){
            ErrorHelper(errorType.value)
        }
        else{
            EventGrid(
                eventList = liveEventList,
                notFoundMessage = stringResource(Res.string.no_live_events),
                button = {
                    Button(
                        onClick = { /* TODO - Navigate to Future Events */ }
                    ){
                        Text(
                            text = stringResource(Res.string.see_future_events),
                            fontStyle = MaterialTheme.typography.labelSmall.fontStyle,
                        )
                    }
                }
            )
        }

        // SnackBar for Error Messages
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp),
            snackbar = { data ->
                Snackbar(
                    dismissAction = {
                        IconButton(
                            onClick = { data.dismiss() }
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.close),
                                contentDescription = stringResource(Res.string.dismiss)
                            )
                        }
                    }
                ) {
                    Text(data.visuals.message)
                }
            }
        )
    }
}