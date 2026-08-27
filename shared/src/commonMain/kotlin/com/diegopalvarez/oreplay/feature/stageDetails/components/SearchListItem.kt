package com.diegopalvarez.oreplay.feature.stageDetails.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.feature.stageDetails.common.SearchResultWrapper
import com.diegopalvarez.oreplay.feature.stageDetails.navigation.StageDetailsComponent
import com.diegopalvarez.oreplay.feature.stageDetails.navigation.StageDetailsEvent
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.category
import oreplay.shared.generated.resources.class_icon
import oreplay.shared.generated.resources.club
import oreplay.shared.generated.resources.club_icon
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SearchListItem(
    item: SearchResultWrapper,
    component: StageDetailsComponent
) {
    SegmentedListItem(
        shapes = ListItemDefaults.shapes(),
        leadingContent ={
            if(item.isClass){
                Icon(
                    painter = painterResource(Res.drawable.category),
                    contentDescription = stringResource(Res.string.class_icon),
                )
            }
            else{
                Icon(
                    painter = painterResource(Res.drawable.club),
                    contentDescription = stringResource(Res.string.club_icon),
                )
            }
        },
        supportingContent = {
            if(item.isClass){
                Text(
                    text = item.classResult!!.longName,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 2.dp),
        onClick = {
            if(item.isClass){
                component.onEvent(StageDetailsEvent.ClickClass(item.classResult!!))
            }
            else{
                component.onEvent(StageDetailsEvent.ClickClub(item.clubResult!!))
            }
        },
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    ){
        if(item.isClass){
            Text(
                text = item.classResult!!.shortName,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
        else{
            Text(
                text = item.clubResult!!.shortName,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}