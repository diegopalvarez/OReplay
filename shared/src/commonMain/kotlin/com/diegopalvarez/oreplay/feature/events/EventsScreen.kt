package com.diegopalvarez.oreplay.feature.events

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberSearchBarState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.events.navigation.EventScreenContent
import com.diegopalvarez.oreplay.feature.events.navigation.EventScreenEvent
import com.diegopalvarez.oreplay.feature.events.navigation.EventsScreenComponent
import com.diegopalvarez.oreplay.ui.components.EventSearchBar
import com.diegopalvarez.oreplay.ui.components.EventsTabRow
import com.diegopalvarez.oreplay.ui.components.MainAppBar
import com.diegopalvarez.oreplay.ui.components.MainAppSearchResults
import com.diegopalvarez.oreplay.ui.components.MainModalDrawer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.app_name
import oreplay.shared.generated.resources.hello_world
import oreplay.shared.generated.resources.search_bar
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventsScreen(
    component: EventsScreenComponent
) {
    // Create Coroutine Scope
    val scope = rememberCoroutineScope { Dispatchers.Main }

    // Text state for the Search Bar
    val textFieldState = rememberTextFieldState()
    val searchAppBarState = rememberSearchBarState()

    // Input field
    val inputField: @Composable () -> Unit = {
        EventSearchBar(
            textFieldState = textFieldState,
            searchBarState = searchAppBarState,
            text = stringResource(Res.string.search_bar),
            onSearch = { search ->
                component.onEvent(EventScreenEvent.SearchEvent(search))
            }
        )
    }

    // State for the Modal Drawer
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    // Get the Search Results from the Component
    val searchResults by component.searchResults.subscribeAsState()

    MainModalDrawer(
        drawerState = drawerState,
        component = component,
    ) {
        Scaffold(
            topBar = {
                MainAppBar(
                    menuAction = {
                        scope.launch {
                            drawerState.open()
                        }
                    },
                    inputField = inputField,
                    searchAppBarState = searchAppBarState,
                )
            }
        ) { innerPadding ->

            // Tab Row
            EventsTabRow(
                contentPadding = innerPadding,
                component = component
            )

            // Actual Screen Content - Depends on the active screen
            EventScreenContent(component)

            // Expanded Search Results
            MainAppSearchResults(
                searchBarState = searchAppBarState,
                searchResults = searchResults,
                onResultClick = { event ->
                    component.onEvent(EventScreenEvent.ClickEvent(event))
                },
                inputField = inputField
            )
        }
    }
}