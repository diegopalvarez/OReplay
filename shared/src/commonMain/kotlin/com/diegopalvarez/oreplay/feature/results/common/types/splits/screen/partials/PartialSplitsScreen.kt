package com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.partials

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
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ResultListItem
import com.diegopalvarez.oreplay.feature.results.common.types.splits.navigation.SplitsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.common.SplitsTable
import com.diegopalvarez.oreplay.feature.results.common.util.filterResultsWithSplits
import com.diegopalvarez.oreplay.feature.results.common.util.hasFinished
import com.diegopalvarez.oreplay.feature.results.common.util.sortIndividualResults
import kotlin.time.Instant

@Composable
fun PartialSplitsScreen(
    component: SplitsComponent
) {
    // Subscribe to the list of results
    val results = component.results.subscribeAsState()


    // Cast the list to ResultIndividual, since the splits are just for this type of results
    if(results.value.all { it is ResultIndividual }){
        val individualResults = results.value as List<ResultIndividual>

        // Sort the results
        val sortedResults = sortIndividualResults(individualResults, null)

        // Filter all the results that have a complete stageResult with splits
        val splitResults = filterResultsWithSplits(sortedResults.filter { hasFinished(it) })

        // Show the table for Partials
        SplitsTable(
            controls = splitResults.first().stageResult!!.splits,       // The stageResults are forced to be not null
            runners = splitResults
        )
    }
    else{
        // TODO - Look for a better option instead of exceptions
        throw IllegalArgumentException("The results of a Classical Stage must be individual")
    }
}