package com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.common

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.SplitTime
import com.diegopalvarez.oreplay.feature.results.common.types.splits.components.ResultIndividualPosition
import com.diegopalvarez.oreplay.feature.results.common.types.splits.components.StatusIndicator
import com.diegopalvarez.oreplay.ui.util.RunnerClassFormatter

@Composable
fun SplitTableContent(
    modifier: Modifier = Modifier,
    scrollState: ScrollState,
    runners: List<ResultIndividual>,
    columnWidth: Dp,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
    ) {
        items(runners) { runner ->
            // Assert that stageResult isn't null, since they have been filtered out
            requireNotNull(runner.stageResult)

            // Each runner has two rows
            Column{
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
                        RunnerClassFormatter(runner.runnerClass)
                    }
                }

                // Runner Results Row
                Row(
                    modifier = Modifier
                        .horizontalScroll(scrollState)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.tertiaryContainer),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    // Total Stage Time
                    if(runner.stageResult.position > 0){
                        SplitTime(
                            total = runner.stageResult.timeSeconds,
                            partial = runner.stageResult.timeBehind,
                            position = null,
                            modifier = Modifier
                                .width(columnWidth)
                        )
                    }
                    else{
                        StatusIndicator(
                            statusCode = runner.stageResult.statusCode,
                            isNC = runner.isNc,
                            modifier = Modifier
                                .width(columnWidth)
                        )
                    }

                    // Runner splits
                    runner.stageResult.splits.forEachIndexed { index, control ->     // The stageResults are filtered to be not null
                        SplitTime(
                            total = control.partial,
                            partial = control.partialDifference,
                            position = control.partialPosition,
                            modifier = Modifier
                                .width(columnWidth)
                        )
                    }
                }
            }
        }
    }
}