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
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.unit.dp
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.menu
import oreplay.shared.generated.resources.menu_icon
import oreplay.shared.generated.resources.reload
import oreplay.shared.generated.resources.reload_icon
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    menuAction: () -> Unit,
    reloadAction: (() -> Unit)? = null,
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
                    contentDescription = stringResource(Res.string.menu_icon),
                )
            }
        },
        actions = {
            if(reloadAction != null) {
                IconButton(
                    onClick = reloadAction
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.reload),
                        contentDescription = stringResource(Res.string.reload_icon),
                    )
                }
            }
            else{
                Spacer(Modifier.width(48.dp))
            }
        },
        // TODO - Decide and apply colors
        // TODO - Investigate Scroll Behaviour
    )
}