package com.diegopalvarez.oreplay.feature.events.screens.liveEvents

import com.arkivanov.decompose.ComponentContext

class LiveEventsComponent(
    componentContext: ComponentContext,
): ComponentContext by componentContext {
    init {
        println("LiveEventsComponent")
    }
}