package com.diegopalvarez.oreplay.feature.results.common.types.points

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.domain.model.Result

class PointsComponent(
    componentContext: ComponentContext,
    val results: Value<List<Result>>
): ComponentContext by componentContext {
}