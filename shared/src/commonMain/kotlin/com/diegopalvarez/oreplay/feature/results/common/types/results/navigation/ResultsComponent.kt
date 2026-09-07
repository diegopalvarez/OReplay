package com.diegopalvarez.oreplay.feature.results.common.types.results.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Result
import com.diegopalvarez.oreplay.domain.model.ResultClass
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageCategory
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.types.StageType

class ResultsComponent(
    componentContext: ComponentContext,
    val regularResults: Value<List<Result>>,
    private val event: Event,
    private val stage: Stage,
    private val stageType: StageType,
    private val isClubView: Boolean,
    private val isStageLive: Value<Boolean>,
    goToPage: (StageCategory) -> Unit,
    mapResultClass: (ResultClass) -> StageClass?,
): CommonResultComponent(
    componentContext = componentContext,
    results = regularResults,
    event = event,
    stage = stage,
    stageType = stageType,
    isClubView = isClubView,
    isLive = isStageLive,
    goToPage = goToPage,
    mapResultClass = mapResultClass
) {

}