package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.accumulated
import oreplay.shared.generated.resources.control
import oreplay.shared.generated.resources.partial
import org.jetbrains.compose.resources.stringResource

@Composable
fun ClassicTicketTableHeader(){
    val style = MaterialTheme.typography.titleMedium
    val weight =FontWeight.Bold

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceContainerHigh)
            .padding(horizontal = 8.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        // Control
        Text(
            text = stringResource(Res.string.control),
            style = style,
            fontWeight = weight,
            modifier = Modifier
                .weight(0.75f)
                .padding(horizontal = 8.dp)
        )

        // Partial
        Text(
            text = stringResource(Res.string.partial),
            style = style,
            fontWeight = weight,
            modifier = Modifier
                .weight(1.125f)
                .padding(horizontal = 8.dp)
        )

        // Accumulated
        Text(
            text = stringResource(Res.string.accumulated),
            style = style,
            fontWeight = weight,
            modifier = Modifier
                .weight(1.125f)
                .padding(horizontal = 8.dp)
        )
    }
}