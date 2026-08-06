package com.diegopalvarez.oreplay.feature.stageDetails.navigation

import com.diegopalvarez.oreplay.feature.events.navigation.EventTabConfiguration
import kotlinx.serialization.Serializable
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.classes_title
import oreplay.shared.generated.resources.clubs_title
import oreplay.shared.generated.resources.future_events_title
import oreplay.shared.generated.resources.live_events_title
import oreplay.shared.generated.resources.past_events_title
import org.jetbrains.compose.resources.StringResource

@Serializable
sealed class StageDetailsTabConfiguration {
    abstract val title: StringResource

    @Serializable
    data object Classes : StageDetailsTabConfiguration() {
        override val title = Res.string.classes_title
    }

    @Serializable
    data object Clubs : StageDetailsTabConfiguration() {
        override val title = Res.string.clubs_title
    }
}