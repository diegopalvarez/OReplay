package com.diegopalvarez.oreplay.feature.events

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberSearchBarState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import oreplay.shared.generated.resources.arrow_back
import oreplay.shared.generated.resources.calendar
import oreplay.shared.generated.resources.hello_world
import oreplay.shared.generated.resources.search
import oreplay.shared.generated.resources.search_bar
import oreplay.shared.generated.resources.search_description
import org.jetbrains.compose.resources.painterResource
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

    // Input field in the Collapsed Position
    val collapsedInputField: @Composable () -> Unit = {
        EventSearchBar(
            textFieldState = textFieldState,
            searchBarState = searchAppBarState,
            text = stringResource(Res.string.search_bar),
            onSearch = { search ->
                component.onEvent(EventScreenEvent.SearchEvent(search))
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(Res.drawable.search),
                    contentDescription = stringResource(Res.string.search_description),
                )
            }
        )
    }

    Icon(
        painter = painterResource(Res.drawable.search),
        contentDescription = stringResource(Res.string.search_description),
    )

    // Date Picker Selected date for the Calendar Icon
    val selectedDateRange = component.selectedDateRange.subscribeAsState()

    // Input field in the Extended Position
    val extendedInputField: @Composable () -> Unit = {
        EventSearchBar(
            textFieldState = textFieldState,
            searchBarState = searchAppBarState,
            text = stringResource(Res.string.search_bar),
            onSearch = { search ->
                component.onEvent(EventScreenEvent.SearchEvent(search))
            },
            leadingIcon = {
                IconButton(
                    onClick = {
                        scope.launch {
                            searchAppBarState.animateToCollapsed()
                        }
                    }
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.arrow_back),
                        contentDescription = stringResource(Res.string.search_description),
                    )
                }
            },
            trailingIcon = {
                if(selectedDateRange.value.first == null && selectedDateRange.value.second == null){
                    IconButton(
                        onClick = {
                            component.showDatePicker(true)
                        },
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.calendar),
                            contentDescription = stringResource(Res.string.search_description)
                        )
                    }
                }
                else {
                    IconButton(
                        onClick = {
                            component.showDatePicker(true)
                        },
                        shape = IconButtonDefaults.mediumSelectedSquareShape,
                        colors = IconButtonDefaults.filledIconButtonColors()
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.calendar),
                            contentDescription = stringResource(Res.string.search_description)
                        )
                    }
                }
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
                    inputField = collapsedInputField,
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
                component = component,
                searchBarState = searchAppBarState,
                searchResults = searchResults,
                onResultClick = { event ->
                    component.onEvent(EventScreenEvent.ClickEvent(event))
                },
                inputField = extendedInputField
            )
        }
    }
}