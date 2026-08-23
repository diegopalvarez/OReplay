package com.diegopalvarez.oreplay.feature.results.common.types.splits.components

import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.style.TextOverflow
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.results.common.types.splits.navigation.SplitsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.splits.navigation.SplitsTabConfiguration
import org.jetbrains.compose.resources.stringResource

@Composable
fun SplitsTabRow(
    component: SplitsComponent
) {
    // Subscribe to the active page
    val pages by component.pages.subscribeAsState()

    PrimaryTabRow(
        selectedTabIndex = pages.selectedIndex,
    ) {
        // Partials Tab
        Tab(
            selected = pages.selectedIndex == 0,
            onClick = {
                component.selectTab(0)
            },
            text = {
                Text(
                    text = stringResource(SplitsTabConfiguration.Partials.title),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        )

        // Accumulated Tab
        Tab(
            selected = pages.selectedIndex == 1,
            onClick = {
                component.selectTab(1)
            },
            text = {
                Text(
                    text = stringResource(SplitsTabConfiguration.Accumulated.title),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        )

    }
}