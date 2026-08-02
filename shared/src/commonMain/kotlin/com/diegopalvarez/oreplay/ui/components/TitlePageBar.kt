package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.Image
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.arrow_back
import oreplay.shared.generated.resources.back
import oreplay.shared.generated.resources.refresh
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TitlePageBar(
    text: String,
    navigationAction: () -> Unit,
    refreshAction: () -> Unit,
    scrollBehaviour: TopAppBarScrollBehavior
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                text = text,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        navigationIcon = {
            IconButton(
                onClick = navigationAction
            ) {
                Icon(
                    painter = painterResource(Res.drawable.arrow_back),
                    contentDescription = stringResource(Res.string.back),
                )
            }
        },
        actions = {
            IconButton(
                onClick = refreshAction
            ) {
                Icon(
                    painter = painterResource(Res.drawable.refresh),
                    contentDescription = stringResource(Res.string.refresh),
                )
            }
        },
        scrollBehavior = scrollBehaviour
    )
}