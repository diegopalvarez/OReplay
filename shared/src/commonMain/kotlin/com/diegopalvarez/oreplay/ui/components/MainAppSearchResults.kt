package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExpandedFullScreenSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.SearchBarState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.feature.events.navigation.EventsScreenComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppSearchResults(
    component: EventsScreenComponent,
    searchBarState: SearchBarState,
    searchResults: List<Event>,
    onResultClick: (Event) -> Unit,
    inputField: @Composable () -> Unit
) {
    // Create Coroutine Scope for the search bar animation
    val scope = rememberCoroutineScope({ Dispatchers.Main })

    // Variable to show or hide the Date Picker
    val showDatePicker = component.showDatePicker.subscribeAsState()

    // Set up the state for the Date Picker
    val dateRangePickerState = rememberDateRangePickerState()

    ExpandedFullScreenSearchBar(
        state = searchBarState,
        inputField = inputField
    ) {
        // Date Picker Modal
        if(showDatePicker.value) {
            SearchDatePicker(
                dateRangePickerState = dateRangePickerState,
                onDateRangeSelected = {
                    component.setSelectedDate(it)
                    component.showDatePicker(false)
                },
                onDismiss = {
                    // Remove the selection from both the Backend and the Composable
                    component.setSelectedDate(Pair(null, null))
                    dateRangePickerState.setSelection(null, null)

                    // Stop showing the date picker
                    component.showDatePicker(false)
                }
            )
        }

        // Search Results
        LazyColumn {
            items(count = searchResults.size) { index ->
                val event = searchResults[index]
                ListItem(
                    headlineContent = { Text(event.description) },
                    supportingContent = { Text(event.organizer.name) },
                    leadingContent = null,
                    colors = ListItemDefaults.colors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .clickable {
                            onResultClick(event)
                            scope.launch {
                                searchBarState.animateToCollapsed()
                            }
                        }
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                )
            }
        }
    }

}