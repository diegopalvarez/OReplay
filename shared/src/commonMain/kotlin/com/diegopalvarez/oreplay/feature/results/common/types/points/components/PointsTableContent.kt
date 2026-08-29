package com.diegopalvarez.oreplay.feature.results.common.types.points.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.repository.util.ScoreResultStats
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.SplitTime
import com.diegopalvarez.oreplay.feature.results.common.types.splits.components.ResultIndividualPosition
import com.diegopalvarez.oreplay.feature.results.common.types.splits.components.StatusIndicator
import com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.common.SplitComposable
import com.diegopalvarez.oreplay.feature.results.common.util.Optional
import com.diegopalvarez.oreplay.ui.components.FABLazyColumn
import com.diegopalvarez.oreplay.ui.util.RunnerClassFormatter
import com.diegopalvarez.oreplay.ui.util.StageClubFormatter
import com.diegopalvarez.oreplay.ui.util.display
import com.diegopalvarez.oreplay.ui.util.toPoints
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_split
import org.jetbrains.compose.resources.stringResource

@Composable
fun PointsTableContent(
    modifier: Modifier = Modifier,
    scrollState: ScrollState,
    runners: List<ResultIndividual>,
    visitedStats: Optional<ScoreResultStats>,
    columnWidth: Dp,
) {
    // Define the cell style
    val cellTextStyle = MaterialTheme.typography.bodyMedium

    FABLazyColumn(
        modifier = modifier
            .fillMaxSize(),
    ) {
        items(runners) { runner ->
            // Assert that stageResult isn't null, since they have been filtered out
            requireNotNull(runner.stageResult)

            // Each runner has two rows
            Column {
                // Runner Details Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 2.dp),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start)
                ) {
                    // Runner Position
                    ResultIndividualPosition(
                        isNC = runner.isNc,
                        statusCode = runner.stageResult.statusCode,
                        position = runner.stageResult.position,
                    )

                    // Runner Name and Details
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        // Runner Name
                        Text(
                            text = runner.fullName,
                        )

                        // Runner Club
                        StageClubFormatter(runner.runnerClub)
                    }
                }

                // Runner Results Row
                Row(
                    modifier = Modifier
                        .horizontalScroll(scrollState)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.tertiaryContainer)
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    // Points Bonus
                    if(runner.stageResult.pointsBonus != null){
                        // TODO - See when points can be null
                        Text(
                            text = runner.stageResult.pointsBonus.toPoints(),
                            style = cellTextStyle,
                            modifier = Modifier
                                .width(columnWidth)
                        )
                    }
                    else{
                        Text(
                            text = stringResource(Res.string.no_split),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .width(columnWidth)
                        )
                    }

                    // Points Penalty
                    if(runner.stageResult.pointsPenalty != null){
                        Text(
                            text = runner.stageResult.pointsPenalty.toPoints(),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .width(columnWidth + 10.dp)
                        )
                    }
                    else{
                        Text(
                            text = stringResource(Res.string.no_split),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .width(columnWidth)
                        )
                    }

                    // Total Points
                    if(runner.stageResult.pointsTotal != null){
                        Text(
                            text = runner.stageResult.pointsTotal.toPoints(),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .width(columnWidth)
                        )
                    }
                    else{
                        Text(
                            text = stringResource(Res.string.no_split),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .width(columnWidth)
                        )
                    }

                    // Total Time
                    Text(
                        text = runner.stageResult.timeSeconds.display(),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .width(columnWidth)
                    )

                    // Show the visited controls if they are available
                    when(visitedStats) {
                        Optional.None -> null
                        is Optional.Some -> VisitedControlsRow(runner.stageResult, visitedStats.value)
                    }

                }
            }
        }
    }
}