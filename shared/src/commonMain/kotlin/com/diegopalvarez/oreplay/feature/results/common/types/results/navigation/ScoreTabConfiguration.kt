package com.diegopalvarez.oreplay.feature.results.common.types.results.navigation

import kotlinx.serialization.Serializable
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.points
import oreplay.shared.generated.resources.points_icon
import oreplay.shared.generated.resources.table
import oreplay.shared.generated.resources.table_icon
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

@Serializable
sealed class ScoreTabConfiguration {
    abstract val icon: DrawableResource
    abstract val iconDescription: StringResource

    @Serializable
    data object TableTab : ScoreTabConfiguration() {
        override val icon = Res.drawable.table
        override val iconDescription = Res.string.table_icon
    }

    @Serializable
    data object ScoreTab : ScoreTabConfiguration() {
        override val icon = Res.drawable.points
        override val iconDescription = Res.string.points_icon
    }
}