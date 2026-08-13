package com.diegopalvarez.oreplay.feature.results.stageClass.navigation

import com.arkivanov.decompose.ComponentContext
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.feature.eventStages.navigation.EventStagesEvent
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent

class ClassResultsComponent(
    componentContext: ComponentContext,
    val pageEvent: Event,
    val stage: Stage,
    val stageClass: StageClass,
    private val onGoBack: () -> Unit
): AbstractResultsComponent(
    componentContext = componentContext,
    onGoBack = onGoBack,
    event = pageEvent,
    stage = stage,
    isClubResults = false
) {
    fun onEvent(event: ClassResultsEvent) {
        when(event) {
            ClassResultsEvent.GoBack -> {
                onGoBack()
            }
        }
    }
}