package com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.SplitIndividual
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.ui.util.display
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_split
import oreplay.shared.generated.resources.total_time
import org.jetbrains.compose.resources.stringResource

@Composable
fun rememberCellWidth(
    widestText: String,
): Dp {

    // If the widestString is empty, return the default size
    if(widestText.isEmpty()){
        return 116.dp
    }

    // Create the text measurer
    val textMeasurer = rememberTextMeasurer()

    // Get the local density
    val density = LocalDensity.current

    // Get the text styles
    val headerStyle = MaterialTheme.typography.bodyMedium.copy(
        fontWeight = FontWeight.Bold,
    )

    // Measure the widest string
    val widthPx = textMeasurer.measure(
        text = AnnotatedString(widestText),
        style = headerStyle,
    ).size.width


    // Convert the pixels to Dp and add padding
    return with(density){
        widthPx.toDp()
    } + 16.dp   // 8.dp of padding in each side
}