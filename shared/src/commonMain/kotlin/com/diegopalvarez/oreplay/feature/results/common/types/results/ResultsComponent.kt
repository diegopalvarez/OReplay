package com.diegopalvarez.oreplay.feature.results.common.types.results

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.domain.model.Result
import com.diegopalvarez.oreplay.domain.types.StageType

class ResultsComponent(
    componentContext: ComponentContext,
    val results: Value<List<Result>>,
    private val stageType: StageType
): ComponentContext by componentContext {
    // Function to get the stage type
    fun getStageType(): StageType {
        return stageType
    }
}