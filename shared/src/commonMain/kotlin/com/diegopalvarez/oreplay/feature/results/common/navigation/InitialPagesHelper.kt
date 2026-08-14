package com.diegopalvarez.oreplay.feature.results.common.navigation

import com.arkivanov.decompose.router.pages.Pages
import com.diegopalvarez.oreplay.domain.types.StageType

fun initialPagesHelper(
    isClubResults: Boolean,
    hasStarted: Boolean,
    stageType: StageType
): Pages<ResultsTabConfiguration> {

    // The main page is the Results tab, except if the event hasn't started. In that case, it's the start times list

    // There must be two different logic branches for class and club results. Club results will never have splits and stats tabs, since they can't directly compare results

    if(!isClubResults) {
        // CLASS RESULTS
        return when(stageType) {
            StageType.CLASSIC -> {
                // Stage with all screens
                Pages(
                    items = listOf(
                        ResultsTabConfiguration.StartTimes,
                        ResultsTabConfiguration.Results,
                        ResultsTabConfiguration.Splits,
                        ResultsTabConfiguration.Statistics
                    ),
                    selectedIndex = if(hasStarted) 1 else 0
                )
            }
            StageType.MASS_START -> TODO("Implement in the whole app")
            StageType.CHASE_START -> TODO("Implement in the whole app")
            StageType.OVERALL -> {
                // Stage with only the Overall Results
                // TODO - Do not show navigation bar
                Pages(
                    items = listOf(
                        ResultsTabConfiguration.Results
                    ),
                    selectedIndex = 0       // The main tab can only be the results tab
                )
            }
            StageType.RELAY -> {
                // Stage without statistics (yet) and start times. The splits are actually Legs
                Pages(
                    items = listOf(
                        ResultsTabConfiguration.Results,
                        ResultsTabConfiguration.Legs,
                    ),
                    selectedIndex = 0       // The main tab can only be the results tab
                )
            }
            StageType.SCORE -> {
                // Score races don't have start time, since it's a mass start. They also don't have stats (yet) and the splits are POINTS
                // TODO - Check if they can have start time
                Pages(
                    items = listOf(
                        ResultsTabConfiguration.Results,
                        ResultsTabConfiguration.Points,
                    ),
                    selectedIndex = 0       // The main tab can only be the results tab
                )
            }
            StageType.RAID -> TODO("Implement in the whole app")
            StageType.TRAIL -> TODO("Implement in the whole app")
            StageType.ONE_MAN_RELAY -> {
                // Classic race but without splits, since the courses must not be equal among the same class. For the same reason, it doesn't have statistics
                Pages(
                    items = listOf(
                        ResultsTabConfiguration.StartTimes,
                        ResultsTabConfiguration.Results,
                    ),
                    selectedIndex = if(hasStarted) 1 else 0
                )
            }
            StageType.RANKING -> TODO("Implement in the whole app")
        }
    }
    else{
        // CLUB RESULTS
        return when(stageType) {
            StageType.CLASSIC -> {
                // Classic Results without Splits and Stats
                Pages(
                    items = listOf(
                        ResultsTabConfiguration.StartTimes,
                        ResultsTabConfiguration.Results,
                    ),
                    selectedIndex = if(hasStarted) 1 else 0
                )
            }
            StageType.MASS_START -> TODO("Implement in the whole app")
            StageType.CHASE_START -> TODO("Implement in the whole app")
            StageType.OVERALL -> {
                // Same as Class Overall
                // TODO - Do not show navigation bar
                Pages(
                    items = listOf(
                        ResultsTabConfiguration.Results
                    ),
                    selectedIndex = 0       // The main tab can only be the results tab
                )
            }
            StageType.RELAY -> {
                // Relay Results without splits (Legs)
                Pages(
                    items = listOf(
                        ResultsTabConfiguration.Results,
                    ),
                    selectedIndex = 0       // The main tab can only be the results tab
                )
            }
            StageType.SCORE -> {
                // Score Results without Splits (Points)
                // TODO - Check if they can have start time
                Pages(
                    items = listOf(
                        ResultsTabConfiguration.Results,
                    ),
                    selectedIndex = 0       // The main tab can only be the results tab
                )
            }
            StageType.RAID -> TODO("Implement in the whole app")
            StageType.TRAIL -> TODO("Implement in the whole app")
            StageType.ONE_MAN_RELAY -> {
                // Same as One Man Relay
                Pages(
                    items = listOf(
                        ResultsTabConfiguration.StartTimes,
                        ResultsTabConfiguration.Results,
                    ),
                    selectedIndex = if(hasStarted) 1 else 0
                )
            }
            StageType.RANKING -> TODO("Implement in the whole app")
        }
    }
}