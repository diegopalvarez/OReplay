package com.diegopalvarez.oreplay.feature.eventStages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.feature.eventStages.components.EventDetailsSummary
import com.diegopalvarez.oreplay.feature.eventStages.components.EventStagesList
import com.diegopalvarez.oreplay.feature.eventStages.components.TimezoneErrorSnackbarHelper
import com.diegopalvarez.oreplay.feature.eventStages.navigation.EventStagesComponent
import com.diegopalvarez.oreplay.feature.eventStages.navigation.EventStagesEvent
import com.diegopalvarez.oreplay.ui.components.ErrorHelper
import com.diegopalvarez.oreplay.ui.components.TimezoneErrorSnackbar
import com.diegopalvarez.oreplay.ui.components.TitlePageBar
import kotlinx.datetime.TimeZone
import org.koin.compose.koinInject

@Composable
fun EventStagesScreen(
    event: Event,
    component: EventStagesComponent,
) {
    // Create the scrollBehavior for the Page Bar
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    // Get the list of Event Stages from the Component
    val eventStages = component.stagesList.subscribeAsState()

    // Variable to know if the stages have been loaded
    val isLoaded = component.isLoaded.subscribeAsState()

    // Variable to know if there has been an error
    val isError = component.isError.subscribeAsState()

    // Variable to know the error type in case it happened
    val errorType = component.errorType.subscribeAsState()

    // Create SnackBar State
    val snackbarHostState = remember { SnackbarHostState() }

    // Inject the Preferences Manager
    val preferencesManager: PreferencesManager = koinInject()

    // Subscribe to the value of the timezone preference
    val convertTimezones = preferencesManager.convertTimezone.collectAsState()

    // Check if the timezones are different
    val isTimezoneDifferent = rememberSaveable { event.timezone != TimeZone.currentSystemDefault() }

    // Bind Timezone Error Snackbar Helper
    TimezoneErrorSnackbarHelper(
        state = snackbarHostState,
        isTimezoneError = isError,
        isLoaded = isLoaded,
        isError = isError,
        convertTimezones = convertTimezones,
        isTimezoneDifferent = isTimezoneDifferent
    )

    // Check if the timezone warning icon should be displayed
    val shouldBeDisplayed = rememberSaveable { mutableStateOf(false) }

    if(convertTimezones.value == false && isTimezoneDifferent) {
        shouldBeDisplayed.value = true
    }

    Scaffold(
        topBar = {
            TitlePageBar(
                title = event.description,
                navigationAction = {
                    component.onEvent(EventStagesEvent.GoBack)
                },
                scrollBehavior = scrollBehavior,
                displayTimezoneWarning = shouldBeDisplayed.value,
            )
        },
        snackbarHost = {
            // SnackBar for Timezone Error
            TimezoneErrorSnackbar(snackbarHostState)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            if(!isLoaded.value) {
                // If the stages are loading, show Progress Indicator
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    CircularProgressIndicator()
                }
            }
            else{
                // Actual Page Content
                if(isError.value){
                    ErrorHelper(
                        errorType = errorType.value
                    )
                }
                else{
                    Column {
                        // Event Summary
                        EventDetailsSummary(
                            event = event,
                            padding = innerPadding
                        )

                        // List of stages
                        EventStagesList(
                            stagesList = eventStages.value,
                            eventTimezone = event.timezone,
                            convertTimezones = convertTimezones.value ?: true,
                            onStageClick = { stage ->
                                component.onEvent(EventStagesEvent.ClickStage(stage))
                            }
                        )
                    }
                }
            }
        }

    }
}