package com.diegopalvarez.oreplay.feature.results.common.types.startTimes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.ResultTeam
import com.diegopalvarez.oreplay.feature.results.common.types.startTimes.components.StartTimeItemIndividual
import com.diegopalvarez.oreplay.feature.results.common.types.startTimes.components.StartTimeItemTeam
import com.diegopalvarez.oreplay.ui.components.NoDataScreen
import kotlinx.datetime.TimeZone
import org.koin.compose.koinInject

@Composable
fun ResultsStartTimesScreen(
    component: StartTimesComponent
) {
    // Subscribe to the list of results from the component
    val runnerList = component.results.subscribeAsState()

    // Get the event timezone from the component
    val eventTimezone = component.getEventTimezone()

    // Check if the timezone for the start time must be converted
    var timezone = TimeZone.currentSystemDefault()

    // Inject the preference manager and see if there's a need to convert the timezone
    val preferenceManager: PreferencesManager = koinInject()
    val timezonePreference = preferenceManager.convertTimezone.collectAsState()
    val convertTimezones = timezonePreference.value ?: true

    // If the preference it's to not choose the timezone, and they're different, keep the event one
    // In every other case, just use the local
    if(!convertTimezones && eventTimezone != timezone) {
        timezone = eventTimezone
    }

    // Get if the results are from a class from the component
    val isClubView = component.isClubView()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        if(runnerList.value.isEmpty()) {
            // In case of an empty list, show a message
            item {
                Box(
                    modifier = Modifier
                        .fillParentMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    NoDataScreen()
                }
            }
        }
        else if(runnerList.value.all { it is ResultIndividual}){
            // Sort the list of runners
            val sortedRunners = (runnerList.value as List<ResultIndividual>)        // TODO - See if there's any other way to do this
                .sortedWith (
                    compareBy<ResultIndividual> { it.stageResult?.startTime == null }
                        .thenBy { it.stageResult?.startTime }
                )

            items(sortedRunners) { runner ->
                StartTimeItemIndividual(runner, timezone = timezone, isClubView)
            }
        }
        else if(runnerList.value.all { it is ResultTeam }){
            // Sort the list of runners
            val sortedRunners = (runnerList.value as List<ResultTeam>)        // TODO - See if there's any other way to do this
                .sortedWith (
                    compareBy<ResultTeam> { it.stageResult?.startTime == null }
                        .thenBy { it.stageResult?.startTime }
                )

            items(sortedRunners) { runner ->
                StartTimeItemTeam(runner, timezone = timezone, isClubView)
            }
        }
    }
}