package com.diegopalvarez.oreplay.feature.results.common.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.style.TextOverflow
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ResultsNavBar(
    component: AbstractResultsComponent
) {
    // Subscribe to the Active Tab
    val pages by component.pages.subscribeAsState()

    // If there's only one page for the given event, there should not be a bottom bar
    if(pages.items.size > 1){
        NavigationBar(
            windowInsets = NavigationBarDefaults.windowInsets
        ) {
            for(i in pages.items.indices) {
                val configuration = pages.items[i].configuration
                NavigationBarItem(
                    selected = pages.selectedIndex == i,
                    onClick = {
                        component.selectTab(i)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(configuration.icon),
                            contentDescription = stringResource(configuration.iconDescription),
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(configuration.title),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                )
            }
        }
    }
    else{
        // If there's just one Tab, there should not be a Navigation Bar
        {}
    }
}