package com.diegopalvarez.oreplay.feature.results.common.types.splits.navigation

import kotlinx.serialization.Serializable
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.accumulated_tab
import oreplay.shared.generated.resources.partial_tab
import org.jetbrains.compose.resources.StringResource

@Serializable
sealed class SplitsTabConfiguration {
    abstract val title: StringResource

    @Serializable
    data object Partials : SplitsTabConfiguration() {
        override val title = Res.string.partial_tab
    }

    @Serializable
    data object Accumulated : SplitsTabConfiguration() {
        override val title = Res.string.accumulated_tab
    }
}