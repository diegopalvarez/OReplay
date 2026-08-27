package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TextFieldWithName(
    name: StringResource,
    value: String,
    style: TextStyle = MaterialTheme.typography.titleMedium,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
    ) {
        // Name in Bold
        Text(
            text = "${stringResource(name)}:",
            style = style,
            fontWeight = FontWeight.Bold,
        )

        // Value
        Text(
            text = value,
            style = style,
        )
    }
}