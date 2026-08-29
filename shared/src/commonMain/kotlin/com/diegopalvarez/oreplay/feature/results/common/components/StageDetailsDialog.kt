package com.diegopalvarez.oreplay.feature.results.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsComponent
import com.diegopalvarez.oreplay.feature.results.stageClub.navigation.ClubResultsComponent
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.classes_title
import oreplay.shared.generated.resources.clubs_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun StageDetailsDialog(
    onDismissRequest: () -> Unit,
    component: AbstractResultsComponent
) {
    Dialog(
        onDismissRequest = { onDismissRequest() },
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
            // Title
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                // Title
                if(component is ClassResultsComponent) {
                    Text(
                        text = stringResource(Res.string.classes_title),
                        modifier = Modifier
                            .padding(vertical = 16.dp)
                    )
                }
                else{
                    Text(
                        text = stringResource(Res.string.clubs_title),
                        modifier = Modifier
                            .padding(vertical = 16.dp)
                    )
                }

            }

            // List of items
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(bottom = 16.dp, start = 16.dp, end = 16.dp),
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
                                onClick = { id, name, isClub ->
                                    onDismissRequest()
                                    component.goToPage(id, name, isClub)
                                },
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
                                onClick = { id, name, isClub ->
                                    onDismissRequest()
                                    component.goToPage(id, name, isClub)
                                },
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