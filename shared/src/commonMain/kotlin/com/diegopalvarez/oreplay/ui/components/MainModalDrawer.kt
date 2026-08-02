package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.app_name
import oreplay.shared.generated.resources.language
import oreplay.shared.generated.resources.language_description
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainModalDrawer(
    drawerState: DrawerState,
    gesturesEnabled: Boolean = true,
    screenContent: @Composable () -> Unit,
) {
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    // First Item - App Name
                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = stringResource(Res.string.app_name),
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleLarge
                    )
                    HorizontalDivider()

                    // Second Item - Language Picker
                    NavigationDrawerItem(
                        label = { Text(stringResource(Res.string.language)) },
                        selected = false,
                        icon = { Icon(
                            painter = painterResource(Res.drawable.language),
                            contentDescription = stringResource(Res.string.language_description)
                        ) },
                        onClick = { }
                    )
                }
            }
        },
        drawerState = drawerState,
        gesturesEnabled = gesturesEnabled,
    ) {
        // Content of the actual Screen
        screenContent()
    }
}