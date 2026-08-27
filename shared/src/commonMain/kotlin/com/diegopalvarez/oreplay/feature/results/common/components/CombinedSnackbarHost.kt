package com.diegopalvarez.oreplay.feature.results.common.components

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.ui.components.RepositoryErrorSnackbar
import com.diegopalvarez.oreplay.ui.components.TimezoneErrorSnackbar

@Composable
fun CombinedSnackbarHost(
    snackbarHostState: SnackbarHostState,
    isError: Boolean,
) {
    if(!isError) {
        // Snackbar to display the timezone conversion warning
        TimezoneErrorSnackbar(snackbarHostState)
    }
    else{
        // Snackbar to display that the results couldn't be updated
        RepositoryErrorSnackbar(snackbarHostState)
    }
}