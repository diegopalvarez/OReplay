package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.SearchBarState
import androidx.compose.material3.SearchBarValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isTraversalGroup
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
fun EventSearchBar(
    textFieldState: TextFieldState,
    searchBarState: SearchBarState,
    text: String,
    onSearch: (String) -> Unit,
) {
    // Create Coroutine Scope for the search bar animation
    val scope = rememberCoroutineScope({ Dispatchers.Main })

    SearchBarDefaults.InputField(
        query = textFieldState.text.toString(),
        onQueryChange = { textFieldState.edit { replace(0, length, it) } },
        onSearch = {
            // Invoke the search function and close the expanded search bar
            onSearch(textFieldState.text.toString())
            scope.launch {
                searchBarState.animateToCollapsed()
            }
        },
        expanded = (searchBarState.currentValue == SearchBarValue.Expanded),
        onExpandedChange = {
            scope.launch {
                if (it) {
                    searchBarState.animateToExpanded()
                } else {
                    searchBarState.animateToCollapsed()
                }
            } },
        placeholder = { Text(text = text) },
        leadingIcon = {
            Icon(
                painter = painterResource(Res.drawable.search),
                contentDescription = stringResource(Res.string.search_description),
            )
        }
    )

}