package com.diegopalvarez.oreplay.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.diegopalvarez.oreplay.ui.util.AppBarTitle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.arrow_back
import oreplay.shared.generated.resources.back
import oreplay.shared.generated.resources.search
import oreplay.shared.generated.resources.search_description
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitlePageBarWithSearch(
    title: String,
    subtitle: String? = null,
    navigationAction: () -> Unit,
    searchBarState: SearchBarState,
    scrollBehavior: TopAppBarScrollBehavior,
) {
    // Create a Coroutine Scope for the UI
    val scope = rememberCoroutineScope({ Dispatchers.Main })

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            AppBarTitle(title, subtitle)
        },
        navigationIcon = {
            IconButton(
                onClick = navigationAction
            ) {
                Icon(
                    painter = painterResource(Res.drawable.arrow_back),
                    contentDescription = stringResource(Res.string.back),
                )
            }
        },
        actions = {
            IconButton(
                onClick = {
                    scope.launch {
                        searchBarState.animateToExpanded()
                    }

                }
            ) {
                Icon(
                    painter = painterResource(Res.drawable.search),
                    contentDescription = stringResource(Res.string.search_description),
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}