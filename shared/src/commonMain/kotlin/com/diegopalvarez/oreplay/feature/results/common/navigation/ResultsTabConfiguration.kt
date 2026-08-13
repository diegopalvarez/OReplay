package com.diegopalvarez.oreplay.feature.results.common.navigation

import androidx.compose.ui.graphics.painter.Painter
import kotlinx.serialization.Serializable
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.clock
import oreplay.shared.generated.resources.leg
import oreplay.shared.generated.resources.legs_title
import oreplay.shared.generated.resources.result
import oreplay.shared.generated.resources.results_title
import oreplay.shared.generated.resources.split
import oreplay.shared.generated.resources.splits_title
import oreplay.shared.generated.resources.start_times_title
import oreplay.shared.generated.resources.stats
import oreplay.shared.generated.resources.stats_title
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

@Serializable
sealed class ResultsTabConfiguration {
    abstract val title: StringResource
    abstract val icon: DrawableResource

    @Serializable
    data object StartTimes : ResultsTabConfiguration() {
        override val title = Res.string.start_times_title
        override val icon = Res.drawable.clock
    }

    @Serializable
    data object Results : ResultsTabConfiguration() {
        override val title = Res.string.results_title
        override val icon = Res.drawable.result
    }

    @Serializable
    data object Splits : ResultsTabConfiguration() {
        override val title = Res.string.splits_title
        override val icon = Res.drawable.split
    }

    @Serializable
    data object Legs : ResultsTabConfiguration() {
        override val title = Res.string.legs_title
        override val icon = Res.drawable.leg
    }

    @Serializable
    data object Statistics : ResultsTabConfiguration() {
        override val title = Res.string.stats_title
        override val icon = Res.drawable.stats
    }
}