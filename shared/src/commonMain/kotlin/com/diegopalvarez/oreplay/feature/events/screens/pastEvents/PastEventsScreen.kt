package com.diegopalvarez.oreplay.feature.events.screens.pastEvents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.past_events_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun PastEventsScreen(
    component: PastEventsComponent
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(stringResource(Res.string.past_events_title))
    }
}