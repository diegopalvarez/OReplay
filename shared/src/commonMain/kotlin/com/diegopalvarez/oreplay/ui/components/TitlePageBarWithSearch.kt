package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.arrow_back
import oreplay.shared.generated.resources.back
import oreplay.shared.generated.resources.clock
import oreplay.shared.generated.resources.generic_stage
import oreplay.shared.generated.resources.refresh
import oreplay.shared.generated.resources.search
import oreplay.shared.generated.resources.search_description
import oreplay.shared.generated.resources.timezone_warning
import oreplay.shared.generated.resources.timezone_warning_icon
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TitlePageBarWithSearch(
    title: String,
    subtitle: String? = null,
    navigationAction: () -> Unit,
    searchAction: () -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior,
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if(title.isNotBlank()){
                    Text(
                        text = title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleLarge,
                    )
                    if(subtitle != null && title != subtitle) {
                        Text(
                            text = subtitle,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.titleSmall,
                        )
                    }
                }
                else if (subtitle != null) {
                    Text(
                        text = subtitle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
                else{
                    Text(
                        text = stringResource(Res.string.generic_stage),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleLarge,
                    )
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
            IconButton(
                onClick = searchAction
            ) {
                Icon(
                    painter = painterResource(Res.drawable.search),
                    contentDescription = stringResource(Res.string.search_description),
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}