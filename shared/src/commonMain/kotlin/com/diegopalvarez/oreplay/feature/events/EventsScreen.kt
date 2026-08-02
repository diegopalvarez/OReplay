package com.diegopalvarez.oreplay.feature.events

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberSearchBarState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.diegopalvarez.oreplay.feature.events.navigation.EventsScreenComponent
import com.diegopalvarez.oreplay.ui.components.EventSearchBar
import com.diegopalvarez.oreplay.ui.components.MainAppBar
import com.diegopalvarez.oreplay.ui.components.MainAppSearchResults
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
    // Text state for the Search Bar
    val textFieldState = rememberTextFieldState()
    val searchAppBarState = rememberSearchBarState()

    // Input field
    val inputField: @Composable () -> Unit = {
        EventSearchBar(
            textFieldState = textFieldState,
            searchBarState = searchAppBarState,
            text = stringResource(Res.string.search_bar),
            onSearch = {}
        )
    }

    Scaffold(
        topBar = {
            MainAppBar(
                menuAction = { },
                inputField = inputField,
                searchAppBarState = searchAppBarState,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(
                text = stringResource(Res.string.hello_world),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        // Expanded Search Results
        MainAppSearchResults(
            searchBarState = searchAppBarState,
            searchResults = emptyList(),
            onResultClick = { },
            inputField = inputField
        )
    }
}