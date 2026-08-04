package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.events.navigation.EventsScreenComponent
import com.diegopalvarez.oreplay.feature.events.navigation.EventTabConfiguration
import oreplay.shared.generated.resources.Res
import org.jetbrains.compose.resources.stringResource

@Composable
fun EventsTabRow(
    component: EventsScreenComponent
) {
    // Subscribe to the Active Tab
    val pages by component.pages.subscribeAsState()

    PrimaryTabRow(
        selectedTabIndex = pages.selectedIndex,
    ){
        // Create MANUALLY a tab for each page

        // Past Events
        Tab(
            selected = pages.selectedIndex == 0,
            onClick = {
                component.selectTab(0)
            },
            text = {
                Text(
                    text = stringResource(EventTabConfiguration.PastEvents.title),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        )

        // Live Events
        Tab(
            selected = pages.selectedIndex == 1,
            onClick = {
                component.selectTab(1)
            },
            text = {
                Text(
                    text = stringResource(EventTabConfiguration.LiveEvents.title),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        )

        // Future Events
        Tab(
            selected = pages.selectedIndex == 2,
            onClick = {
                component.selectTab(2)
            },
            text = {
                Text(
                    text = stringResource(EventTabConfiguration.FutureEvents.title),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        )
    }
}