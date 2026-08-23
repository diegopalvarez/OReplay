package com.diegopalvarez.oreplay.feature.results.common.types.splits.screen.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.diegopalvarez.oreplay.domain.model.SplitIndividual
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.SplitTime

@Composable
fun SplitComposable(
    split: SplitIndividual,
    isAccumulated: MutableState<Boolean>,
    modifier: Modifier,
) {
    if(isAccumulated.value) {
        // Accumulated Split View
        SplitTime(
            total = split.accumulated,
            partial = split.accumulatedDifference,
            position = split.accumulatedPosition,
            modifier = modifier,
        )
    }
    else{
        // Partial Split View
        SplitTime(
            total = split.partial,
            partial = split.partialDifference,
            position = split.partialPosition,
            modifier = modifier,
        )
    }
}