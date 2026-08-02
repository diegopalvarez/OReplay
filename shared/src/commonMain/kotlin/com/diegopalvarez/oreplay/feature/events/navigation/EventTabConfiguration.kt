package com.diegopalvarez.oreplay.feature.events.navigation

import kotlinx.serialization.Serializable
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.future_events_title
import oreplay.shared.generated.resources.live_events_title
import oreplay.shared.generated.resources.past_events_title
import org.jetbrains.compose.resources.StringResource

@Serializable
sealed class EventTabConfiguration {
    abstract val title: StringResource

    @Serializable
    data object PastEvents : EventTabConfiguration() {
        override val title = Res.string.past_events_title
    }

    @Serializable
    data object LiveEvents : EventTabConfiguration() {
        override val title = Res.string.live_events_title
    }

    @Serializable
    data object FutureEvents : EventTabConfiguration() {
        override val title = Res.string.future_events_title
    }
}