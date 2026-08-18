package com.diegopalvarez.oreplay.feature.results.common.types.results.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.types.StageType
import com.diegopalvarez.oreplay.feature.results.common.util.Optional

class TableTabComponent(
    componentContext: ComponentContext,
    ticketRunner: Value<Optional<ResultIndividual>>,
    stageType: StageType,
): ComponentContext by componentContext {
}