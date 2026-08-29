package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.common

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.diegopalvarez.oreplay.domain.model.ResultClass

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ClassLink(
    stageClass: ResultClass,
    isClubView: Boolean,
    goToPage: (String, String) -> Unit,
){
    if(isClubView){
        TextButton(
            onClick = {
                goToPage(stageClass.id, stageClass.longName)
            }
        ){
            Text(
                text = stageClass.shortName,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
    else{
        Text(
            text = stageClass.shortName,
            style = MaterialTheme.typography.titleMedium,
        )
    }

}