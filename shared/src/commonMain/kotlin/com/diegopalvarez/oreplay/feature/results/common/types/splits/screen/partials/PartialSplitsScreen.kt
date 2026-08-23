package com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.partials

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.feature.results.common.types.splits.navigation.SplitsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.common.SplitsTable
import com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.common.rememberCellWidth
import com.diegopalvarez.oreplay.feature.results.common.util.filterResultsWithSplits
import com.diegopalvarez.oreplay.feature.results.common.util.hasFinished
import com.diegopalvarez.oreplay.feature.results.common.util.sortIndividualResults

@Composable
fun PartialSplitsScreen(
    component: SplitsComponent
) {
    // Subscribe to the list of results
    val results = component.results.subscribeAsState()

    // Subscribe to the widest string from the results
    val widestString = component.widestString.subscribeAsState()

    // TODO - Study and optimize screen freezing when changing to this tab
    // Compute the cell width for the widest string
    val cellWidth = rememberCellWidth(widestString.value)

    // Cast the list to ResultIndividual, since the splits are just for this type of results
    if(results.value.all { it is ResultIndividual }){
        val individualResults = results.value as List<ResultIndividual>

        // Filter all the results that have a complete stageResult with splits
        val splitResults = filterResultsWithSplits(individualResults.filter { hasFinished(it) })

        // Sort the results
        val sortedResults = sortIndividualResults(splitResults, null)

        // Show the table for Partials
        SplitsTable(
            controls = sortedResults.first().stageResult!!.splits,       // The stageResults are forced to be not null
            runners = sortedResults,
            cellWidth = cellWidth,
        )
    }
    else{
        // TODO - Look for a better option instead of exceptions
        throw IllegalArgumentException("The results of a Classical Stage must be individual")
    }
}