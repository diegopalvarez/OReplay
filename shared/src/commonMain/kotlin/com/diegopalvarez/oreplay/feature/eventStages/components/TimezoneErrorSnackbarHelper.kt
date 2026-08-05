package com.diegopalvarez.oreplay.feature.eventStages.components

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import com.diegopalvarez.oreplay.core.util.RepositoryError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.snackbar_app_error
import oreplay.shared.generated.resources.snackbar_internal_error
import oreplay.shared.generated.resources.snackbar_network_error
import oreplay.shared.generated.resources.snackbar_server_error
import oreplay.shared.generated.resources.snackbar_timezone_error
import oreplay.shared.generated.resources.snackbar_unknown_error
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource

@Composable
fun TimezoneErrorSnackbarHelper(
    state: SnackbarHostState,
    isTimezoneError: State<Boolean>,
    isLoaded: State<Boolean>,
    isError: State<Boolean>,
    convertTimezones: State<Boolean?>
) {
    // Use a LaunchedEffect for suspended UI functions
    LaunchedEffect(isTimezoneError.value, isLoaded.value, isError.value.not(), convertTimezones.value) {
        val convertPreference = convertTimezones.value ?: true
        if(!isError.value && isLoaded.value && convertPreference) {
            state.showSnackbar(
                message = getString(Res.string.snackbar_timezone_error),
                duration = SnackbarDuration.Long,
                withDismissAction = true
            )
        }
    }
}