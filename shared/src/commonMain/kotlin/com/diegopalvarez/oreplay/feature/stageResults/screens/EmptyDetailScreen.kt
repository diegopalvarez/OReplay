package com.diegopalvarez.oreplay.feature.stageResults.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.select_category
import org.jetbrains.compose.resources.stringResource

@Composable
fun EmptyDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(Res.string.select_category),
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}