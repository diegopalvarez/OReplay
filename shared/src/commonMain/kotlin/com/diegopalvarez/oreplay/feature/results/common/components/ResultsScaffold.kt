package com.diegopalvarez.oreplay.feature.results.common.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.feature.eventStages.components.TimezoneErrorSnackbarHelper
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsEvent
import com.diegopalvarez.oreplay.ui.components.TimezoneErrorSnackbar
import com.diegopalvarez.oreplay.ui.components.TitlePageBar
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

    /**
     * Timezone conversion warning display logic
     */
    // Inject the Preferences Manager
    val preferencesManager: PreferencesManager = koinInject()

    // Subscribe to the value of the timezone preference
    val convertTimezones = preferencesManager.convertTimezone.collectAsState()

    // Check if the timezone warning icon should be displayed
    var shouldBeDisplayed = false

    if(convertTimezones.value == false && event.timezone != TimeZone.currentSystemDefault()) {
        shouldBeDisplayed = true
    }

    // Create SnackBar State
    val snackbarHostState = remember { SnackbarHostState() }

    // Bind Timezone Error Snackbar Helper
    /** TODO - Add Timezone error when the data is fetched
    TimezoneErrorSnackbarHelper(
        state = snackbarHostState,
        isTimezoneError = isError,
        isLoaded = isLoaded,
        isError = isError,
        convertTimezones = convertTimezones
    )
     */

    Scaffold(
        topBar = {
            TitlePageBar(
                title = tabName,
                subtitle = stage.description.ifBlank { event.description },
                navigationAction = {
                    navigationAction()
                },
                scrollBehavior = scrollBehavior,
                displayTimezoneWarning = shouldBeDisplayed,
            )
        },
        bottomBar = { ResultsNavBar(component) },
        snackbarHost = { TimezoneErrorSnackbar(snackbarHostState) }

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            // The content of the screen depends on the selected tab
            ResultsTabContent(component)
        }
    }
}