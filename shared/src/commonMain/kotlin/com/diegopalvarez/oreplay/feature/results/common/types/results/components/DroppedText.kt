package com.diegopalvarez.oreplay.feature.results.common.types.results.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.dropped
import org.jetbrains.compose.resources.stringResource

@Composable
fun DroppedText(){
    // TODO - Consider adding the pill-shaped container
    /**
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                shape = RoundedCornerShape(percent = 50)
            )
            .padding(horizontal = 4.dp, vertical = 2.dp)
    )
    */
    Text(stringResource(Res.string.dropped))
}