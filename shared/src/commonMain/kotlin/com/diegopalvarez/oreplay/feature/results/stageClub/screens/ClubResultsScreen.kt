package com.diegopalvarez.oreplay.feature.results.stageClub.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Stage
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsComponent
import com.diegopalvarez.oreplay.feature.results.stageClub.navigation.ClubResultsComponent

@Composable
fun ClubResultsScreen(
    pageEvent: Event,
    stage: Stage,
    stageClass: StageClub,
    component: ClubResultsComponent
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Club Results:")
    }
}