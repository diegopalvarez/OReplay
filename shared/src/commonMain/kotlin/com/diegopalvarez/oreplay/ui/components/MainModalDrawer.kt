package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import com.diegopalvarez.oreplay.feature.events.navigation.EventScreenEvent
import com.diegopalvarez.oreplay.feature.events.navigation.EventsScreenComponent
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.app_name
import oreplay.shared.generated.resources.language
import oreplay.shared.generated.resources.language_description
import oreplay.shared.generated.resources.reload
import oreplay.shared.generated.resources.reload_description
import oreplay.shared.generated.resources.reload_interval
import oreplay.shared.generated.resources.timezone_switch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject

@Composable
fun MainModalDrawer(
    drawerState: DrawerState,
    gesturesEnabled: Boolean = true,
    component: EventsScreenComponent,
    screenContent: @Composable () -> Unit,
) {
    // Combined dialog state
    val openDialog = remember { mutableStateOf<DrawerDialog?>(null) }

    // Get the timezone status
    val preferenceManager: PreferencesManager = koinInject()

    val timezoneSelected = preferenceManager.convertTimezone.collectAsState()

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
                        icon = {
                            Icon(
                                painter = painterResource(Res.drawable.language),
                                contentDescription = stringResource(Res.string.language_description)
                            )
                        },
                        onClick = {
                            openDialog.value = DrawerDialog.LANGUAGE
                        }
                    )

                    // Third Item - Refresh Interval Picker
                    NavigationDrawerItem(
                        label = { Text(stringResource(Res.string.reload_interval)) },
                        selected = false,
                        icon = {
                            Icon(
                                painter = painterResource(Res.drawable.reload),
                                contentDescription = stringResource(Res.string.reload_description)
                            )
                        },
                        onClick = {
                            openDialog.value = DrawerDialog.REFRESH
                        }
                    )

                    // Fourth Item - Timezone Translator
                    NavigationDrawerItem(
                        label = { Text(stringResource(Res.string.timezone_switch)) },
                        selected = false,
                        badge = {
                            // Switch to change the state
                            Switch(
                                checked = timezoneSelected.value ?: true,
                                onCheckedChange = {
                                    preferenceManager.toggleTimezonePreference()
                                }
                            )
                        },
                        onClick = {
                            // Also change the switch if the whole item is clicked
                            preferenceManager.toggleTimezonePreference()
                        }
                    )
                }
            }
        },
        drawerState = drawerState,
        gesturesEnabled = gesturesEnabled,
    ) {

        // Handle the different Dialogs
        when(openDialog.value) {
            DrawerDialog.LANGUAGE -> {
                LanguagePickerDialog(
                    onDismissRequest = { openDialog.value = null },
                    onConfirmation = { language ->
                        component.onEvent(EventScreenEvent.ChangeLanguage(language))
                    },
                    currentSelected = component.getCurrentLanguage()
                )
            }
            DrawerDialog.REFRESH -> {
                RefreshDialog(
                    onDismissRequest = { openDialog.value = null },
                    onConfirmation = { interval ->
                        component.onEvent(EventScreenEvent.ChangeRefreshInterval(interval))
                    },
                    currentInterval = component.currentReloadInterval.collectAsState()
                )
            }
            null -> Unit
        }

        // Content of the actual Screen
        screenContent()
    }
}