package com.diegopalvarez.oreplay.feature.results.common.types.results

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.domain.model.Result

class ResultsComponent(
    componentContext: ComponentContext,
    val results: Value<List<Result>>
): ComponentContext by componentContext {
}