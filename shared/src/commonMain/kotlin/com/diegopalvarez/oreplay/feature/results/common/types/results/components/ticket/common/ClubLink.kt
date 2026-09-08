package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.common

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.diegopalvarez.oreplay.domain.model.StageCategory
import com.diegopalvarez.oreplay.domain.model.StageClub

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ClubLink(
    stageClub: StageClub,
    isClubView: Boolean,
    goToPage: (StageCategory) -> Unit,
){
    if(!isClubView){
        TextButton(
            onClick = {
                goToPage(stageClub)
            }
        ){
            Text(
                text = stageClub.shortName,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
    else{
        Text(
            text = stageClub.shortName,
            style = MaterialTheme.typography.titleMedium,
        )
    }

}