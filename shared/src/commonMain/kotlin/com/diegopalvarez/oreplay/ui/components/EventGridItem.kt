package com.diegopalvarez.oreplay.ui.components

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.diegopalvarez.oreplay.domain.model.Event

@Composable
fun EventGridItem(
    event: Event,
){
    Card(

    ) {
        Text(
            text = event.description
        )
    }
}