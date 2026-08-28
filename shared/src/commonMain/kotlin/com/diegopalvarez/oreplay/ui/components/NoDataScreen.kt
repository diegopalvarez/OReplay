package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.info
import oreplay.shared.generated.resources.no_info
import oreplay.shared.generated.resources.no_info_icon
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun NoDataScreen(
    message: StringResource = Res.string.no_info
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ThemeImage(
            painter = painterResource(Res.drawable.info),
            contentDescription = stringResource(Res.string.no_info_icon),
            modifier = Modifier
                .width(100.dp),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = stringResource(message),
            textAlign = TextAlign.Center,
        )
    }
}