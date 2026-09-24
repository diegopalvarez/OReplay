package com.diegopalvarez.oreplay.feature.stageResults.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.decompose.extensions.compose.experimental.panels.ChildPanels
import com.arkivanov.decompose.extensions.compose.experimental.panels.ChildPanelsAnimators
import com.arkivanov.decompose.extensions.compose.experimental.panels.HorizontalChildPanelsLayout
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.PredictiveBackParams
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.materialPredictiveBackAnimatable
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsComponent
import com.diegopalvarez.oreplay.feature.results.stageClass.screens.ClassResultsScreen
import com.diegopalvarez.oreplay.feature.results.stageClub.navigation.ClubResultsComponent
import com.diegopalvarez.oreplay.feature.results.stageClub.screens.ClubResultsScreen
import com.diegopalvarez.oreplay.feature.stageDetails.StageDetailsScreen
import com.diegopalvarez.oreplay.feature.stageResults.navigation.StagePanelsComponent
import com.diegopalvarez.oreplay.feature.stageResults.navigation.StagePanelsEvent
import com.diegopalvarez.oreplay.feature.stageResults.util.ChildPanelsModeChangedEffect

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun StageResultsScreen(
    component: StagePanelsComponent
) {
    // Get the active detail from the component
    val panels by component.panels.subscribeAsState()

    // Bind the function to change the display mode
    ChildPanelsModeChangedEffect(component::setMode)

    ChildPanels(
        panels = panels,
        layout = remember {
            HorizontalChildPanelsLayout(
                dualWeights = Pair(1F, 2F)
            )
        },
        mainChild = {
            StageDetailsScreen(
                event = component.pageEvent,
                stage = component.stage,
                component = it.instance
            )
        },
        detailsChild = {
            when(val details = it.instance) {
                is ClassResultsComponent -> {
                    ClassResultsScreen(
                        pageEvent = details.pageEvent,
                        stage = details.stage,
                        stageClassName = details.stageClass.longName,
                        component = details
                    )
                }
                is ClubResultsComponent -> {
                    ClubResultsScreen(
                        pageEvent = details.pageEvent,
                        stage = details.stage,
                        stageClubName = details.stageClub.shortName,
                        component = details
                    )
                }

                else -> {
                    EmptyDetailScreen()
                }
            }
        },
        secondPanelPlaceholder = {
            EmptyDetailScreen()
        },
        animators = ChildPanelsAnimators(
            single = scale(), dual = fade() to fade(),
        ),
        predictiveBackParams = {
            PredictiveBackParams(
                backHandler = component.backHandler,
                onBack = {
                    component.onEvent(StagePanelsEvent.CloseDetailsPanel)
                },
                animatable = ::materialPredictiveBackAnimatable
            )
        },
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceContainer)

    )
}
