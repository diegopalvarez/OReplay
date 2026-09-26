package com.diegopalvarez.oreplay.feature.results.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.app.platform.Platform
import com.diegopalvarez.oreplay.app.platform.getPlatform
import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.feature.results.common.components.history.FABHistory
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import com.diegopalvarez.oreplay.ui.components.ErrorHelper
import com.diegopalvarez.oreplay.ui.components.NoDataScreen
import com.diegopalvarez.oreplay.ui.components.PullToRefresh
import com.diegopalvarez.oreplay.ui.components.SidePanelTitleBar
import com.diegopalvarez.oreplay.ui.components.TitlePageBar
import com.diegopalvarez.oreplay.ui.util.getScaffoldInsets
import com.diegopalvarez.oreplay.ui.util.isExpandedDevice
import com.diegopalvarez.oreplay.ui.util.offsetOn
import kotlinx.datetime.TimeZone
import org.koin.compose.koinInject

@Composable
fun ResultsScaffold(
    event: Event,
    stage: Stage,
    tabName: String,
    navigationAction: () -> Unit,
    component: AbstractResultsComponent
){
    // Create the scrollBehavior for the Page Bar
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    // Create the state for the class/club dialog
    val openChangeDialog = rememberSaveable { mutableStateOf(false) }

    // Subscribe to the type of platform
    val platform = getPlatform().collectAsState()

    /**
     * Timezone conversion warning display logic
     */
    // Inject the Preferences Manager
    val preferencesManager: PreferencesManager = koinInject()

    // Subscribe to the value of the timezone preference
    val convertTimezones = preferencesManager.convertTimezone.collectAsState()

    // Check if the timezones are different
    val isTimezoneDifferent = rememberSaveable { event.timezone.offsetOn(event.initialDate) != TimeZone.currentSystemDefault().offsetOn(event.initialDate) }

    // Check if the Icon Warning should be displayed
    val timezoneIconDisplay = isTimezoneDifferent && !(convertTimezones.value ?: true)

    /**
     * Subscribe to the results and get state indicators
     */

    val isInit = component.isInit.subscribeAsState()

    val isRefreshing = component.isRefreshing.subscribeAsState()

    val isError = component.isError.subscribeAsState()

    val errorType = component.errorType.subscribeAsState()

    val results = component.results.subscribeAsState()

    /**
     * Create the reload functionality and its snackbar
     */

    // Create PullToRefresh state
    val refreshState = rememberPullToRefreshState()

    // Create SnackBar State
    val snackbarHostState = remember { SnackbarHostState() }

    // Bind Helper to this Snackbar
    CombinedSnackbarHelper(
        state = snackbarHostState,
        isLoading = isRefreshing,
        isError = isError,
        errorType = errorType,
        isInit = isInit,
        convertTimezones = convertTimezones,
        isTimezoneDifferent = isTimezoneDifferent
    )

    // Get the Display Information to know what UI to display
    val isLargeDevice = isExpandedDevice()

    // Apply different modifiers depending on the device size
    val modifier = if(isLargeDevice) {
        if(platform.value == Platform.WEB || platform.value != Platform.WEB_TOUCHABLE) {
            Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
        }
        else{
            // If the device is mobile, there must only be a padding on the divider to not interfere with the status bar
            Modifier
                .padding(start = 8.dp, end = 0.dp, top = 0.dp, bottom = 0.dp)
        }

    } else Modifier


    Scaffold(
        topBar = {
            if(isLargeDevice) {
                SidePanelTitleBar(
                    title = tabName,
                    subtitle = stage.description.ifBlank { event.description },
                    navigationAction = {
                        navigationAction()
                    },
                    scrollBehavior = scrollBehavior,
                    displayTimezoneWarning = timezoneIconDisplay,
                    refreshAction = when(platform.value){
                        Platform.WEB -> component::reloadResults
                        else -> null
                    },
                    isRefreshing = isRefreshing.value,
                    component = component,
                    onOpenDialog = {
                        openChangeDialog.value = true
                    }
                )
            }
            else {
                TitlePageBar(
                    title = tabName,
                    subtitle = stage.description.ifBlank { event.description },
                    navigationAction = {
                        navigationAction()
                    },
                    scrollBehavior = scrollBehavior,
                    displayTimezoneWarning = timezoneIconDisplay,
                    refreshAction = when(platform.value){
                        Platform.WEB -> component::reloadResults
                        else -> null
                    },
                    isRefreshing = isRefreshing.value
                )
            }
        },
        bottomBar = {
            // Show only the Bottom Bar if the device isn't an Expanded Display
            if(!isLargeDevice) {
                ResultsNavBar(component)
            }
        },
        snackbarHost = { CombinedSnackbarHost(snackbarHostState, isError.value) },
        floatingActionButton = {
            // Show the FAB only if the device isn't an Expanded Display
            if(!isLargeDevice) {
                FABHistory(
                    component = component,
                    onOpenDialog = {
                        openChangeDialog.value = true
                    }
                )
            }
        },
        modifier = modifier,
        contentWindowInsets = getScaffoldInsets()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            // Create a Pull-to-Refresh box that includes all the results content
            PullToRefresh(
                isRefreshing = isRefreshing.value,
                onRefresh = component::reloadResults,
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
                // If the data hasn't been initialized, show a big error message
                if (!isInit.value) {
                    if (isError.value) {
                        ErrorHelper(errorType.value)
                    } else {
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
                } else {
                    if(results.value.isEmpty()){
                        NoDataScreen()
                    }
                    else{
                        // Actual content of the Tab, depending on which one is selected
                        ResultsTabContent(component)
                    }
                }
            }
        }

        // Show the dialog to change between classes and clubs
        when(openChangeDialog.value){
            true -> StageDetailsDialog(
                onDismissRequest = {
                    openChangeDialog.value = false
                },
                component = component
            )
            false -> Unit
        }

        // Show the Navigation Rail only if the display is an Expanded Display
        if(isLargeDevice){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
            ) {
                // Show the navigation rail
                ResultsNavigationToolbar(
                    component = component,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                )
            }
        }
    }
}