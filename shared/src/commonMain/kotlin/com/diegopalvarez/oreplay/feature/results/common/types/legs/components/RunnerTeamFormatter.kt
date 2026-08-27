package com.diegopalvarez.oreplay.feature.results.common.types.legs.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.StageClub
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_club
import org.jetbrains.compose.resources.stringResource

@Composable
fun RunnerTeamFormatter(
    stageClub: StageClub?,
    teamName: String,
    style: TextStyle = MaterialTheme.typography.labelSmall
){
    if(stageClub != null){
        Text(
            text = "$teamName (${stageClub.shortName})",
            style = style
        )
    }
    else {
        Text(
            text = teamName,
            style = style
        )
    }
}