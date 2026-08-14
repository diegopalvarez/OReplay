package com.diegopalvarez.oreplay.feature.results.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
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
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.feature.eventStages.components.TimezoneErrorSnackbarHelper
import com.diegopalvarez.oreplay.feature.events.common.SnackbarHelper
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsEvent
import com.diegopalvarez.oreplay.ui.components.ErrorHelper
import com.diegopalvarez.oreplay.ui.components.EventGrid
import com.diegopalvarez.oreplay.ui.components.TimezoneErrorSnackbar
import com.diegopalvarez.oreplay.ui.components.TitlePageBar
import kotlinx.datetime.TimeZone
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.close
import oreplay.shared.generated.resources.dismiss
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
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

    /**
     * Timezone conversion warning display logic
     */
    // Inject the Preferences Manager
    val preferencesManager: PreferencesManager = koinInject()

    // Subscribe to the value of the timezone preference
    val convertTimezones = preferencesManager.convertTimezone.collectAsState()

    // Check if the timezones are different
    val isTimezoneDifferent = rememberSaveable { event.timezone != TimeZone.currentSystemDefault() }

    // Check if the Icon Warning should be displayed
    val timezoneIconDisplay = isTimezoneDifferent && !(convertTimezones.value ?: true)

    /**
     * Subscribe to the results and get state indicators
     */

    val isInit = component.isInit.subscribeAsState()

    val isRefreshing = component.isRefreshing.subscribeAsState()

    val isError = component.isError.subscribeAsState()

    val errorType = component.errorType.subscribeAsState()

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

    Scaffold(
        topBar = {
            TitlePageBar(
                title = tabName,
                subtitle = stage.description.ifBlank { event.description },
                navigationAction = {
                    navigationAction()
                },
                scrollBehavior = scrollBehavior,
                displayTimezoneWarning = timezoneIconDisplay,
            )
        },
        bottomBar = { ResultsNavBar(component) },
        snackbarHost = { CombinedSnackbarHost(snackbarHostState, isError.value) }

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            // Create a Pull-to-Refresh box that includes all the results content
            PullToRefreshBox(
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
                    // Actual content of the Tab, depending on which one is selected
                    ResultsTabContent(component)
                }
            }
        }
    }
}