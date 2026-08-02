package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.AppBarWithSearch
import androidx.compose.material3.ExpandedFullScreenSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.SearchBarState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSearchBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.menu
import oreplay.shared.generated.resources.search
import oreplay.shared.generated.resources.search_description
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppSearchResults(
    searchBarState: SearchBarState,
    searchResults: List<String>,
    onResultClick: (String) -> Unit,
    inputField: @Composable () -> Unit
) {
    // Create Coroutine Scope for the search bar animation
    val scope = rememberCoroutineScope({ Dispatchers.Main })

    ExpandedFullScreenSearchBar(
        state = searchBarState,
        inputField = inputField
    ) {
        LazyColumn {
            items(count = searchResults.size) { index ->
                val resultText = searchResults[index]
                ListItem(
                    headlineContent = { Text(resultText) },
                    supportingContent = { Text(resultText) },
                    leadingContent = null,
                    colors = ListItemDefaults.colors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .clickable {
                            onResultClick(resultText)
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