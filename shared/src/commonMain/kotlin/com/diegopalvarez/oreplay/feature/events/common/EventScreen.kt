package com.diegopalvarez.oreplay.feature.events.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.ui.components.ErrorHelper
import com.diegopalvarez.oreplay.ui.components.EventGrid
import com.diegopalvarez.oreplay.ui.components.RepositoryErrorSnackbar
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun EventScreen(
    component: AbstractEventComponent,
    notFoundButton: @Composable () -> Unit = {},
    notFoundMessage: StringResource,
    nextPageFunction: () -> Unit,
    onEventClick: (Event) -> Unit,
) {
    // Subscribe to the list of Live Events
    val liveEventList = component.eventList.subscribeAsState()

    // Subscribe to the isRefreshing variable
    val isRefreshing = component.isRefreshing.subscribeAsState()

    // Subscribe to the Error Indicator
    val isError = component.isError.subscribeAsState()

    // Subscribe to the Error Type
    val errorType = component.errorType.subscribeAsState()

    // Subscribe to isInit
    val isInit = component.isInit.subscribeAsState()

    // Subscribe to nextPage
    val nextPage = component.nextPage.subscribeAsState()

    // Subscribe to the loading state of the nextPage
    val isNextPageLoading = component.nextPageLoading.subscribeAsState()

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
        indicator = {
            Indicator(
                modifier = Modifier.align(Alignment.TopCenter),
                isRefreshing = isRefreshing.value,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                state = refreshState
            )
        }
    ) {
        // Content of the actual screen

        // If the data hasn't been initialized, show a big error message
        if(!isInit.value) {
            if(isError.value) {
                ErrorHelper(errorType.value)
            }
            else{
                // Show loading spinner
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
        }
        else {
            EventGrid(
                eventList = liveEventList,
                onEventClick = onEventClick,
                notFoundMessage = stringResource(notFoundMessage),
                button = notFoundButton,
                nextPage = nextPage.value,
                nextPageFunction = nextPageFunction,
                isNextPageLoading = isNextPageLoading,
            )
        }

        // SnackBar for Error Messages
        RepositoryErrorSnackbar(snackbarHostState)
    }
}