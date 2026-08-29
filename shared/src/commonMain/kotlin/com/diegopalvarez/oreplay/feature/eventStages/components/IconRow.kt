package com.diegopalvarez.oreplay.feature.eventStages.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.event_organizer
import oreplay.shared.generated.resources.person
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun IconRow(
    text: String,
    style: TextStyle,
    icon: DrawableResource,
    iconDescription: StringResource,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Icon(
            painter = painterResource(icon),
            contentDescription = stringResource(iconDescription),
        )
        Text(
            style = style,
            text = text,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}