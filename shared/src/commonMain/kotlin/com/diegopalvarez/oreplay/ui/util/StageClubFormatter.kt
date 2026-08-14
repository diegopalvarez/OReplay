package com.diegopalvarez.oreplay.ui.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.diegopalvarez.oreplay.domain.model.StageClub
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_class
import oreplay.shared.generated.resources.no_club
import org.jetbrains.compose.resources.stringResource

@Composable
fun StageClubFormatter(
    stageClub: StageClub?,
    style: TextStyle = MaterialTheme.typography.labelSmall
){
    if(stageClub != null){
        Text(
            text = stageClub.shortName,
            style = style
        )
    }
    else{
        Text(
            text = stringResource(Res.string.no_club),
            style = style
        )
    }
}