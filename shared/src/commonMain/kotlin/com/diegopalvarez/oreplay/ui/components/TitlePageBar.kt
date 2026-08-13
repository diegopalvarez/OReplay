package com.diegopalvarez.oreplay.ui.components

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.ui.util.AppBarTitle
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.arrow_back
import oreplay.shared.generated.resources.back
import oreplay.shared.generated.resources.clock
import oreplay.shared.generated.resources.refresh
import oreplay.shared.generated.resources.timezone_warning
import oreplay.shared.generated.resources.timezone_warning_icon
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TitlePageBar(
    title: String,
    subtitle: String? = null,
    navigationAction: () -> Unit,
    hasRefresh: Boolean = false,
    refreshAction: () -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior,
    displayTimezoneWarning: Boolean = false,
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            ) {
                AppBarTitle(title, subtitle)
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
                    painter = painterResource(Res.drawable.arrow_back),
                    contentDescription = stringResource(Res.string.back),
                )
            }
        },
        actions = {
            if(hasRefresh) {
                IconButton(
                    onClick = refreshAction
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.refresh),
                        contentDescription = stringResource(Res.string.refresh),
                    )
                }
            }
        },
        scrollBehavior = scrollBehavior
    )
}