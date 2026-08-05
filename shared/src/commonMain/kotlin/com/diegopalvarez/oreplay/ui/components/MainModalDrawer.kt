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
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.feature.events.navigation.EventScreenEvent
import com.diegopalvarez.oreplay.feature.events.navigation.EventsScreenComponent
import kotlinx.coroutines.Dispatchers
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.app_name
import oreplay.shared.generated.resources.language
import oreplay.shared.generated.resources.language_description
import oreplay.shared.generated.resources.timezone_switch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import org.koin.core.component.KoinComponent

@Composable
fun MainModalDrawer(
    drawerState: DrawerState,
    gesturesEnabled: Boolean = true,
    component: EventsScreenComponent,
    screenContent: @Composable () -> Unit,
) {
    // Language dialog state
    val openLanguageDialog = remember { mutableStateOf(false) }

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
                        icon = { Icon(
                            painter = painterResource(Res.drawable.language),
                            contentDescription = stringResource(Res.string.language_description)
                        ) },
                        onClick = {
                            openLanguageDialog.value = !openLanguageDialog.value
                        }
                    )

                    // Third Item - Timezone Translator
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
        // Language Picker Dialog, in case it's open
        if (openLanguageDialog.value) {
            LanguagePickerDialog(
                onDismissRequest = { openLanguageDialog.value = false },
                onConfirmation = { language ->
                    component.onEvent(EventScreenEvent.ChangeLanguage(language))
                },
                currentSelected = component.getCurrentLanguage()
            )
        }

        // Content of the actual Screen
        screenContent()
    }
}