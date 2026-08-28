package com.diegopalvarez.oreplay.feature.results.common.types.results.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ScoreResultListItem
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.CommonResultComponent
import com.diegopalvarez.oreplay.feature.results.common.util.sortIndividualResults
import kotlin.time.Instant

@Composable
fun ScoreResultsScreen(
    component: CommonResultComponent
){
    // Subscribe to the list of results
    val results = component.results.subscribeAsState()

    // Get if the view is for a club or a class from the component
    val isClubView = component.isClubView()

    // Get if the event is live or not
    val isLive = component.isLive.subscribeAsState()

    var now: State<Instant>? = null
    if(isLive.value){
        now = component.now.collectAsStateWithLifecycle()
    }

    // Cast the list to ResultIndividual, since the classical results can't be in teams (at least for now)
    if(results.value.all { it is ResultIndividual }){
        val individualResults = results.value as List<ResultIndividual>

        // Sort the results
        val sortedResults = sortIndividualResults(individualResults)

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(sortedResults){ result ->
                ScoreResultListItem(result, now, isClubView, {runner -> component.showTicketModal(runner)})
            }
        }
    }
    else{
        // TODO - Look for a better option instead of exceptions
        throw IllegalArgumentException("The results of an Score Stage must be individual")
    }
}