package com.diegopalvarez.oreplay.feature.results.common.navigation

import androidx.compose.ui.graphics.painter.Painter
import kotlinx.serialization.Serializable
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.clock
import oreplay.shared.generated.resources.leg
import oreplay.shared.generated.resources.legs_icon
import oreplay.shared.generated.resources.legs_title
import oreplay.shared.generated.resources.result
import oreplay.shared.generated.resources.results_icon
import oreplay.shared.generated.resources.results_title
import oreplay.shared.generated.resources.split
import oreplay.shared.generated.resources.splits_icon
import oreplay.shared.generated.resources.splits_title
import oreplay.shared.generated.resources.start_times_icon
import oreplay.shared.generated.resources.start_times_title
import oreplay.shared.generated.resources.stats
import oreplay.shared.generated.resources.stats_icon
import oreplay.shared.generated.resources.stats_title
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

@Serializable
sealed class ResultsTabConfiguration {
    abstract val title: StringResource
    abstract val icon: DrawableResource
    abstract val iconDescription: StringResource

    @Serializable
    data object StartTimes : ResultsTabConfiguration() {
        override val title = Res.string.start_times_title
        override val icon = Res.drawable.clock
        override val iconDescription = Res.string.start_times_icon
    }

    @Serializable
    data object Results : ResultsTabConfiguration() {
        override val title = Res.string.results_title
        override val icon = Res.drawable.result
        override val iconDescription = Res.string.results_icon
    }

    @Serializable
    data object Splits : ResultsTabConfiguration() {
        override val title = Res.string.splits_title
        override val icon = Res.drawable.split
        override val iconDescription = Res.string.splits_icon
    }

    @Serializable
    data object Legs : ResultsTabConfiguration() {
        override val title = Res.string.legs_title
        override val icon = Res.drawable.leg
        override val iconDescription = Res.string.legs_icon
    }

    @Serializable
    data object Statistics : ResultsTabConfiguration() {
        override val title = Res.string.stats_title
        override val icon = Res.drawable.stats
        override val iconDescription = Res.string.stats_icon
    }
}