package com.diegopalvarez.oreplay.feature.stageDetails.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExpandedFullScreenSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.SearchBarState
import androidx.compose.material3.SearchBarValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.feature.stageDetails.navigation.StageDetailsComponent
import com.diegopalvarez.oreplay.feature.stageDetails.screens.classes.StageClassesComponent
import com.diegopalvarez.oreplay.ui.components.search.ActionSearchMessage
import com.diegopalvarez.oreplay.ui.components.search.EmptySearchMessage
import com.diegopalvarez.oreplay.ui.components.search.LoadingSearchMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.arrow_back
import oreplay.shared.generated.resources.back
import oreplay.shared.generated.resources.close
import oreplay.shared.generated.resources.close_search
import oreplay.shared.generated.resources.dismiss
import oreplay.shared.generated.resources.search
import oreplay.shared.generated.resources.search_bar
import oreplay.shared.generated.resources.search_description
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClassClubSearchBar(
    searchBarState: SearchBarState,
    component: StageDetailsComponent,
    ) {
    // Declare Coroutine Scope
    val scope = rememberCoroutineScope { Dispatchers.Main }

    // Subscribe to the Search Query
    val searchQuery = component.searchQuery.collectAsState()

    // Subscribe to the List of Results
    val searchResults = component.searchResults.collectAsState()

    ExpandedFullScreenSearchBar(
        state = searchBarState,
        inputField = {
            SearchBarDefaults.InputField(
                query = searchQuery.value,
                onQueryChange = { component.onQueryChange(it) },
                onSearch = {},
                expanded = (searchBarState.currentValue == SearchBarValue.Expanded),
                onExpandedChange = {
                    scope.launch {
                        if (it) {
                            searchBarState.animateToExpanded()
                        } else {
                            searchBarState.animateToCollapsed()
                        }
                    }
                },
                placeholder = { Text(stringResource(Res.string.search_bar)) },
                leadingIcon = {
                    IconButton(
                        onClick = {
                            scope.launch {
                                searchBarState.animateToCollapsed()
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.arrow_back),
                            contentDescription = stringResource(Res.string.back),
                        )
                    }
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            component.clearQuery()
                        }
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.close),
                            contentDescription = stringResource(Res.string.close_search),
                        )
                    }
                },
            )
        },

        ) {
        // Display search results in a scrollable column
        val results = searchResults.value
        if(results == null) {
            // Prompt to make a Search
            ActionSearchMessage(isEvent = false)
        }
        else{
            if(results.isEmpty()){
                // No results
                EmptySearchMessage(isEvent = false)
            }
            else{
                // Show the list of results
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(results) { item ->
                        SearchListItem(item)
                    }
                }
            }
        }
    }
}