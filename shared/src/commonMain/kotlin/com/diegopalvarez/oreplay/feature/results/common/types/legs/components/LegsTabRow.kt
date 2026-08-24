package com.diegopalvarez.oreplay.feature.results.common.types.legs.components

import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.style.TextOverflow
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.results.common.types.legs.LegsComponent
import com.diegopalvarez.oreplay.feature.results.common.types.splits.navigation.SplitsTabConfiguration
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.leg
import org.jetbrains.compose.resources.stringResource

@Composable
fun LegsTabRow(
    component: LegsComponent
) {
    // Subscribe to the active page
    val pages by component.pages.subscribeAsState()

    if(pages.items.isNotEmpty()) {
        PrimaryTabRow(
            selectedTabIndex = pages.selectedIndex,
        ) {
            // Create a tab for each of the tabs
            for(pageIndex in pages.items.indices) {
                Tab(
                    selected = pages.selectedIndex == pageIndex,
                    onClick = {
                        component.selectTab(pageIndex)
                    },
                    text = {
                        Text(
                            text = "${stringResource(Res.string.leg)} ${pages.items[pageIndex].configuration.legNumber}",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                )
            }
        }
    }
}