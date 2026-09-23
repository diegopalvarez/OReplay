package com.diegopalvarez.oreplay.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.ui.util.AppBarTitle
import com.diegopalvarez.oreplay.ui.util.SmallAppBarTitle
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.clock
import oreplay.shared.generated.resources.close
import oreplay.shared.generated.resources.close_icon
import oreplay.shared.generated.resources.refresh
import oreplay.shared.generated.resources.timezone_warning
import oreplay.shared.generated.resources.timezone_warning_icon
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SidePanelTitleBar(
    title: String,
    subtitle: String? = null,
    navigationAction: () -> Unit,
    refreshAction: (() -> Unit)? = null,
    scrollBehavior: TopAppBarScrollBehavior,
    displayTimezoneWarning: Boolean = false,
    isRefreshing: Boolean = false,
) {
    // Create the icon rotation
    val rotation = remember { Animatable(0f) }

    LaunchedEffect(isRefreshing) {
        if (isRefreshing) {
            while (true) {
                rotation.animateTo(
                    targetValue = rotation.value + 360f,
                    animationSpec = tween(
                        durationMillis = 1000,
                        easing = LinearEasing,
                    )
                )
            }
        }
        else{
            // Reset the rotation value
            rotation.snapTo(0f)
        }
    }

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),   // TODO - Make the text be completely centered and the icon on the side
            ) {
                SmallAppBarTitle(title, subtitle)
                if(displayTimezoneWarning) {
                    // Add a warning tooltip to Top Bar
                    TooltipBox(
                        positionProvider = TooltipDefaults.rememberTooltipPositionProvider(
                            positioning = TooltipAnchorPosition.Below
                        ),
                        tooltip = {
                            PlainTooltip { Text(stringResource(Res.string.timezone_warning)) }
                        },
                        state = rememberTooltipState()
                    ){
                        Icon(
                            painter = painterResource(Res.drawable.clock),
                            contentDescription = stringResource(Res.string.timezone_warning_icon),
                        )
                    }
                }
            }

        },
        navigationIcon = {
            IconButton(
                onClick = navigationAction
            ) {
                Icon(
                    painter = painterResource(Res.drawable.close),
                    contentDescription = stringResource(Res.string.close_icon),
                )
            }
        },
        actions = {
            if(refreshAction != null) {
                IconButton(
                    onClick = refreshAction,
                    enabled = !isRefreshing,
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.refresh),
                        contentDescription = stringResource(Res.string.refresh),
                        modifier = Modifier.rotate(rotation.value)      // Keep rotating while loading
                    )
                }
            }
        },
        scrollBehavior = scrollBehavior,
        expandedHeight = 56.dp
    )
}