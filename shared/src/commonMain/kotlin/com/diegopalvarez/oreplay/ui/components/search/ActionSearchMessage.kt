package com.diegopalvarez.oreplay.ui.components.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.action_search
import oreplay.shared.generated.resources.action_search_stage
import org.jetbrains.compose.resources.stringResource

@Composable
fun ActionSearchMessage(
    isEvent: Boolean = true,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(isEvent){
            Text(
                text = stringResource(Res.string.action_search),
                textAlign = TextAlign.Center,
            )
        }
        else{
            Text(
                text = stringResource(Res.string.action_search_stage),
                textAlign = TextAlign.Center,
            )
        }

    }
}