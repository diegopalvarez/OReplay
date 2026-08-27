package com.diegopalvarez.oreplay.feature.results.common.components

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import com.diegopalvarez.oreplay.core.util.RepositoryError
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.snackbar_app_error
import oreplay.shared.generated.resources.snackbar_internal_error
import oreplay.shared.generated.resources.snackbar_network_error
import oreplay.shared.generated.resources.snackbar_results_app_error
import oreplay.shared.generated.resources.snackbar_results_internal_error
import oreplay.shared.generated.resources.snackbar_results_network_error
import oreplay.shared.generated.resources.snackbar_results_server_error
import oreplay.shared.generated.resources.snackbar_results_unknown_error
import oreplay.shared.generated.resources.snackbar_server_error
import oreplay.shared.generated.resources.snackbar_timezone_error
import oreplay.shared.generated.resources.snackbar_unknown_error
import org.jetbrains.compose.resources.getString

@Composable
fun CombinedSnackbarHelper(
    state: SnackbarHostState,
    isLoading: State<Boolean>,      // Adding isLoading as a state for the Launch Effect triggers the snackbar after the consecutive failed reloads
    isError: State<Boolean>,
    isInit: State<Boolean>,
    convertTimezones: State<Boolean?>,
    isTimezoneDifferent: Boolean,
    errorType: State<RepositoryError>
) {
    val hasShownTimezoneSnackbar = rememberSaveable{ mutableStateOf(false) }

    // Use a LaunchedEffect for suspended UI functions
    LaunchedEffect(isError.value, errorType.value, isInit.value, isLoading.value, convertTimezones.value, isTimezoneDifferent) {
        val convertPreference = convertTimezones.value ?: true
        if(isInit.value && !isLoading.value)
            if(isError.value) {
                state.showSnackbar(
                    message = when (errorType.value) {
                        RepositoryError.NETWORK -> getString(Res.string.snackbar_results_network_error)
                        RepositoryError.INTERNAL -> getString(Res.string.snackbar_results_internal_error)
                        RepositoryError.SERVER -> getString(Res.string.snackbar_results_server_error)
                        RepositoryError.NOT_IMPLEMENTED -> getString(Res.string.snackbar_results_app_error)
                        RepositoryError.UNKNOWN -> getString(Res.string.snackbar_results_unknown_error)
                    },
                    duration = SnackbarDuration.Long
                )
            }
            // This only shows the timezone warning when the snackbar is invoked but there's no error, which will just be when loading the screen for the first time
            else if (!hasShownTimezoneSnackbar.value && convertPreference && isTimezoneDifferent) {
                state.showSnackbar(
                    message = getString(Res.string.snackbar_timezone_error),
                    duration = SnackbarDuration.Long,
                    withDismissAction = true
                )

                // After showing the timezone snackbar for the first time, it's not shown again
                hasShownTimezoneSnackbar.value = true
            }
    }
}