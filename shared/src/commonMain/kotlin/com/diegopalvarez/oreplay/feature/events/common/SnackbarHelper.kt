package com.diegopalvarez.oreplay.feature.events.common

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
import oreplay.shared.generated.resources.snackbar_unknown_error
import org.jetbrains.compose.resources.getString

@Composable
fun SnackbarHelper(
    state: SnackbarHostState,
    isError: State<Boolean>,
    isInit: State<Boolean>,
    errorType: State<RepositoryError>
) {
    // Use a LaunchedEffect for suspended UI functions
    LaunchedEffect(isError.value, errorType.value, isInit.value) {
        if(isInit.value && isError.value){
            state.showSnackbar(
                message = when(errorType.value){
                    RepositoryError.NETWORK -> getString(Res.string.snackbar_network_error)
                    RepositoryError.INTERNAL -> getString(Res.string.snackbar_internal_error)
                    RepositoryError.SERVER -> getString(Res.string.snackbar_server_error)
                    RepositoryError.NOT_IMPLEMENTED -> getString(Res.string.snackbar_app_error)
                    RepositoryError.UNKNOWN -> getString(Res.string.snackbar_unknown_error)
                },
                duration = SnackbarDuration.Long
            )
        }
    }
}