package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.close
import oreplay.shared.generated.resources.deactivate
import oreplay.shared.generated.resources.dismiss
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject

@Composable
fun TimezoneErrorSnackbar(
    snackbarHostState: SnackbarHostState,
) {
    // Inject the Preferences Manager
    val preferencesManager: PreferencesManager = koinInject()

    SnackbarHost(
        hostState = snackbarHostState,
        modifier = Modifier
            .padding(horizontal = 16.dp),
        snackbar = { data ->
            Snackbar(
                dismissAction = {
                    IconButton(
                        onClick = { data.dismiss() }
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.close),
                            contentDescription = stringResource(Res.string.dismiss)
                        )
                    }
                },
                action = {
                    Button(
                        onClick = {
                            // Change the preference and dismiss the Snackbar
                            preferencesManager.toggleTimezonePreference()
                            data.dismiss()
                        }
                    ){
                        Text(stringResource(Res.string.deactivate))
                    }
                }
            ) {
                Text(
                    text = data.visuals.message,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                )
            }
        }
    )
}