package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DateRangePickerState
import androidx.compose.material3.ExpandedFullScreenSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarState
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.feature.events.navigation.EventsScreenComponent
import com.diegopalvarez.oreplay.ui.components.search.ActionSearchMessage
import com.diegopalvarez.oreplay.ui.components.search.EmptySearchMessage
import com.diegopalvarez.oreplay.ui.components.search.LoadingSearchMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.action_search
import oreplay.shared.generated.resources.no_results_search
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MainAppSearchResults(
    component: EventsScreenComponent,
    dateRangePickerState: DateRangePickerState,
    searchBarState: SearchBarState,
    searchResults: List<Event>?,
    onResultClick: (Event) -> Unit,
    inputField: @Composable () -> Unit
) {
    // Create Coroutine Scope for the search bar animation
    val scope = rememberCoroutineScope({ Dispatchers.Main })

    // Variable to show or hide the Date Picker
    val showDatePicker = component.showDatePicker.subscribeAsState()

    // Variable to know if the search is being processed
    val isSearching = component.isSearching.subscribeAsState()

    // TODO - Seaching by Date Interval doesn't seem to be supported
    // TODO - Check if so, and remove it from the UI :(

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
        if(isSearching.value){
            LoadingSearchMessage()
        }
        else {
            if(searchResults == null){
                ActionSearchMessage()
            }
            else{
                if(searchResults.isEmpty()){
                    EmptySearchMessage()
                }
                else{
                    LazyColumn {
                        items(count = searchResults.size) { index ->
                            val event = searchResults[index]
                            SegmentedListItem(
                                shapes = ListItemDefaults.shapes(),
                                enabled = true,
                                leadingContent = null,
                                trailingContent = null,
                                overlineContent = null,
                                supportingContent = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 2.dp),
                                onClick = {
                                    onResultClick(event)
                                    scope.launch {
                                        searchBarState.animateToCollapsed()
                                    }
                                }
                            ){
                                Column {
                                    Text(
                                        text =event.description,
                                        color = MaterialTheme.colorScheme.onSurface
                                        )
                                    Text(
                                        text = event.organizer.name,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        style = MaterialTheme.typography.bodySmall,
                                    )
                                }
                                Text(event.description)
                            }
                        }
                    }
                }
            }

        }

    }

}