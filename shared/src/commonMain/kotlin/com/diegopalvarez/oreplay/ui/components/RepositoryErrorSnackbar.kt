package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.close
import oreplay.shared.generated.resources.dismiss
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun RepositoryErrorSnackbar(
    snackbarHostState: SnackbarHostState,
) {
    SnackbarHost(
        hostState = snackbarHostState,
        modifier = Modifier
            //.align(Alignment.BottomCenter)
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