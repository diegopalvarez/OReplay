package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AppBarWithSearch
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.unit.dp
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.menu
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    menuAction: () -> Unit,
    searchAppBarState: SearchBarState,
    inputField: @Composable () -> Unit
) {

    AppBarWithSearch(
        modifier = Modifier
            .semantics { traversalIndex = 0f },
        state = searchAppBarState,
        inputField = inputField,
        navigationIcon = {
            IconButton(
                onClick = menuAction
            ) {
                Icon(
                    painter = painterResource(Res.drawable.menu),
                    contentDescription = "Menu",
                )
            }
        },
        actions = {
            Spacer(Modifier.width(48.dp))
        }
        // TODO - Decide and apply colors
        // TODO - Investigate Scroll Behaviour
    )
}