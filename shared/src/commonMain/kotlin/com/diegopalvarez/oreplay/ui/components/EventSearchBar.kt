package com.diegopalvarez.oreplay.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.SearchBarState
import androidx.compose.material3.SearchBarValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventSearchBar(
    textFieldState: State<String>,
    searchBarState: SearchBarState,
    text: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onQueryChange: (String) -> Unit
) {
    // Create Coroutine Scope for the search bar animation
    val scope = rememberCoroutineScope({ Dispatchers.Main })

    SearchBarDefaults.InputField(
        query = textFieldState.value,
        onQueryChange = { onQueryChange(it) },
        onSearch = {
            // Search doesn't need a custom function, it only displays the results
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
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
    )

}