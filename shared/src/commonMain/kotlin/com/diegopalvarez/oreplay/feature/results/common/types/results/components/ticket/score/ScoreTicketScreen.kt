package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.score

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.repository.util.ScoreResultStats
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.ScoreResultsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.ScoreTabConfiguration
import com.diegopalvarez.oreplay.feature.results.common.util.Optional
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ScoreTicketScreen(
    result: StageResult,
    visitedStats: Optional<ScoreResultStats>,
    component: ScoreResultsComponent,
) {
    // Subscribe to the selected tab
    val pages by component.pages.subscribeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Navigation Tab
        PrimaryTabRow(
            selectedTabIndex = pages.selectedIndex,
        ) {
            // Score Results Tab
            Tab(
                selected = (pages.selectedIndex == 0),
                onClick = {
                    component.selectTab(0)
                },
                icon = {
                    Icon(
                        painter = painterResource(ScoreTabConfiguration.ScoreTab.icon),
                        contentDescription = stringResource(ScoreTabConfiguration.ScoreTab.iconDescription),
                    )
                }
            )

            // Table Results Tab
            Tab(
                selected = (pages.selectedIndex == 1),
                onClick = {
                    component.selectTab(1)
                },
                icon = {
                    Icon(
                        painter = painterResource(ScoreTabConfiguration.TableTab.icon),
                        contentDescription = stringResource(ScoreTabConfiguration.TableTab.iconDescription),
                    )
                }
            )
        }

        // Actual content of the tabs
        ScoreTicketHost(component, result, visitedStats)
    }
}