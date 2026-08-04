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
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberSearchBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
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
import oreplay.shared.generated.resources.arrow_back
import oreplay.shared.generated.resources.calendar
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
    val textField = component.searchQuery.collectAsState("")
    val searchAppBarState = rememberSearchBarState()

    // Input field in the Collapsed Position
    val collapsedInputField: @Composable () -> Unit = {
        EventSearchBar(
            textFieldState = textField,
            searchBarState = searchAppBarState,
            text = stringResource(Res.string.search_bar),
            onQueryChange = { query ->
                component.onQueryChange(query)
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
    val selectedDateRange = component.selectedDateRange.collectAsState()

    // Set up the state for the Date Picker
    val dateRangePickerState = rememberDateRangePickerState()


    // Input field in the Extended Position
    val extendedInputField: @Composable () -> Unit = {
        EventSearchBar(
            textFieldState = textField,
            searchBarState = searchAppBarState,
            text = stringResource(Res.string.search_bar),
            onQueryChange = { query ->
                component.onQueryChange(query)
            },
            leadingIcon = {
                IconButton(
                    onClick = {
                        scope.launch {
                            // Clear all the search fields
                            component.clearQuery()
                            component.setSelectedDate(Pair(null, null))
                            dateRangePickerState.setSelection(null, null)

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
    val searchResults by component.searchResults.collectAsState(null)

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

            Column(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                // Tab Row
                EventsTabRow(
                    component = component
                )

                // Actual Screen Content - Depends on the active screen
                EventScreenContent(
                    component = component,
                )

            }

            // Expanded Search Results
            MainAppSearchResults(
                component = component,
                searchBarState = searchAppBarState,
                dateRangePickerState = dateRangePickerState,
                searchResults = searchResults,
                onResultClick = { event ->
                    component.onEvent(EventScreenEvent.ClickEvent(event))
                },
                inputField = extendedInputField
            )
        }
    }
}