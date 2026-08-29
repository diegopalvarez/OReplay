package com.diegopalvarez.oreplay.feature.results.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsComponent
import com.diegopalvarez.oreplay.feature.results.stageClub.navigation.ClubResultsComponent
import com.diegopalvarez.oreplay.feature.stageDetails.components.ClubListItem

@Composable
fun StageDetailsDialog(
    onDismissRequest: () -> Unit,
    component: AbstractResultsComponent
) {
    Dialog(
        onDismissRequest = { onDismissRequest() }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            )
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // The list contents depend on the type of screen (class or club)
                when(component){
                    is ClassResultsComponent -> {
                        items(
                            items = component.stageClasses,
                            span = { item ->
                                if(item.shortName.length > 8){
                                    GridItemSpan(maxLineSpan)
                                }
                                else{
                                    GridItemSpan(1)
                                }
                            }
                        ){
                            DialogListItem(
                                displayName = it.shortName,
                                id = it.id,
                                navigationName = it.longName,
                                onClick = component::goToPage,
                                isClub = false,
                                isSelected = (it.id == component.stageClassID)
                            )
                        }
                    }
                    is ClubResultsComponent -> {
                        items(
                            items = component.stageClubs,
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ){
                            DialogListItem(
                                displayName = it.shortName,
                                id = it.id,
                                navigationName = it.shortName,
                                onClick = component::goToPage,
                                isClub = true,
                                isSelected = (it.id == component.stageClubID)
                            )
                        }
                    }
                }
            }
        }
    }
}