package com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.SplitIndividual
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.feature.results.common.types.splits.navigation.SplitsComponent
import com.diegopalvarez.oreplay.ui.components.NoDataScreen
import com.diegopalvarez.oreplay.ui.util.display
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_split
import org.jetbrains.compose.resources.stringResource

@Composable
fun SplitsTable(
    modifier: Modifier = Modifier,
    controls: List<SplitIndividual>,
    runners: List<ResultIndividual>,
    cellWidth: Dp,
) {
    // Create and remember the scroll state
    val scrollState = rememberScrollState()

    // Create the table
    if(runners.isEmpty()) {
        NoDataScreen()
    }
    else{
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            // Table Header
            SplitTableHeader(
                scrollState = scrollState,
                controls = controls,
                columnWidth = cellWidth
            )

            // Table Contents
            SplitTableContent(
                scrollState = scrollState,
                runners = runners,
                columnWidth = cellWidth
            )
        }
    }
}