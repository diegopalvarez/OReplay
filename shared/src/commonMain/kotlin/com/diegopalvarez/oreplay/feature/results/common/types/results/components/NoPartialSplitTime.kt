package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.ui.util.display
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_split
import org.jetbrains.compose.resources.stringResource
import kotlin.time.Duration

@Composable
fun NoPartialSplitTime(
    total: Duration?,
    modifier: Modifier = Modifier,
) {
    val style = MaterialTheme.typography.labelLarge

    var alignment = Alignment.Start

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = alignment,
        modifier = modifier
            .padding(horizontal = 8.dp)
    ) {
        if(total != null){
            Text(
                text = total.display(),
                style = style,
            )
        }
        else{
            Text(
                text = stringResource(Res.string.no_split),
                style = style,
            )
            // The text is center-aligned
            alignment = Alignment.CenterHorizontally
        }
    }
}