package com.diegopalvarez.oreplay.feature.events.screens.futureEvents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.future_events_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun FutureEventsScreen(
    component: FutureEventsComponent
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(stringResource(Res.string.future_events_title))
    }
}