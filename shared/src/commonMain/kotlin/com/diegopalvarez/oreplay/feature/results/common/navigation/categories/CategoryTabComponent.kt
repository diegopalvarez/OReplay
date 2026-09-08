package com.diegopalvarez.oreplay.feature.results.common.navigation.categories

import com.arkivanov.decompose.ComponentContext
import com.diegopalvarez.oreplay.domain.model.StageCategory
import com.diegopalvarez.oreplay.domain.wrappers.ResultHistory

class CategoryTabComponent(
    componentContext: ComponentContext,
    val history: ResultHistory,
    val current: StageCategory
): ComponentContext by componentContext {
}