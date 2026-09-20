package com.diegopalvarez.oreplay.feature.stageResults.navigation

import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.domain.wrappers.ResultHistory
import kotlinx.serialization.Serializable

@Serializable
sealed class StageResultsConfiguration {
    @Serializable
    data class ClassResultsScreen(val event: Event, val stage: Stage, val stageClass: StageClass, val stageHistory: ResultHistory): StageResultsConfiguration()

    @Serializable
    data class ClubResultsScreen(val event: Event, val stage: Stage, val stageClub: StageClub, val stageHistory: ResultHistory): StageResultsConfiguration()
}