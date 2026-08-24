package com.diegopalvarez.oreplay.feature.results.common.types.points

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.domain.model.Result
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.repository.util.ScoreResultStats
import com.diegopalvarez.oreplay.feature.results.common.util.Optional
import com.diegopalvarez.oreplay.feature.results.common.util.filterResultsWithSplits
import com.diegopalvarez.oreplay.feature.results.common.util.hasFinished
import com.diegopalvarez.oreplay.feature.results.common.util.sortIndividualResults

class PointsComponent(
    componentContext: ComponentContext,
    val results: Value<List<Result>>,
    val visitedStatsMap: Value<Optional<Map<String, ScoreResultStats>>>
): ComponentContext by componentContext {
    /**
     * Expose a variable with just the individual results for the score
     */
    private val _individualResults = MutableValue<List<ResultIndividual>>(emptyList())
    val individualResults: Value<List<ResultIndividual>> = _individualResults

    // Subscribe to the results to update the filters on each change
    init {
        filterResults()

        results.subscribe {
            filterResults()
        }
    }

    private fun filterResults(){
        val individualResults = results.value.filterIsInstance<ResultIndividual>()
        val splitResults = filterResultsWithSplits(individualResults.filter { hasFinished(it) })

        // Sort the results
        val sortedResults = sortIndividualResults(splitResults, null)
        _individualResults.value = sortedResults
    }

    /**
     * Function to get the visited stats for the class of the runner in the ticker
     */
    fun getVisitedStats(classID: String?): Optional<ScoreResultStats>{
        when(val stats = visitedStatsMap.value){
            Optional.None -> return Optional.None
            is Optional.Some -> if(classID != null){
                val result = stats.value[classID]
                return if(result != null) {
                    Optional.Some(result)
                } else{
                    Optional.None
                }
            }
            else{
                return Optional.None
            }
        }
    }
}