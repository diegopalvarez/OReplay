package com.diegopalvarez.oreplay.feature.results.common.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.change
import oreplay.shared.generated.resources.change_icon
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ChangeClassClubButton(
    onClick: () -> Unit
) {
    SmallFloatingActionButton(
        onClick = {
            onClick()
        },
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.secondary,
    ) {
        Icon(
            painter = painterResource(Res.drawable.change),
            contentDescription = stringResource(Res.string.change_icon),
        )
    }
}