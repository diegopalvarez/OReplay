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
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import com.diegopalvarez.oreplay.feature.results.common.navigation.categories.CategoryTabComponent
import com.diegopalvarez.oreplay.feature.results.stageClass.navigation.ClassResultsComponent
import com.diegopalvarez.oreplay.feature.results.stageClub.navigation.ClubResultsComponent
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.classes_title
import oreplay.shared.generated.resources.clubs_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun StageDetailsDialogContent(
    component: AbstractResultsComponent,
    onDismissRequest: () -> Unit,
) {
    // Subscribe to the selected tab from the component
    val pages = component.dialogPages.subscribeAsState()

    // List of items
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // The list contents depend on the type of screen (class or club)
        when(val child = pages.value.items[pages.value.selectedIndex].instance){
            is AbstractResultsComponent.CategoryTabChild.ClassTab -> {
                items(
                    items = component.stageHistory.classList,
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
                        item = it,
                        onClick = { item ->
                            onDismissRequest()
                            component.goToPage(item)
                        },
                        isSelected = (it == child.component.current)
                    )
                }
            }
            is AbstractResultsComponent.CategoryTabChild.ClubTab -> {
                items(
                    items = component.stageHistory.clubList,
                    span = {
                        GridItemSpan(maxLineSpan)
                    }
                ){
                    DialogListItem(
                        displayName = it.shortName,
                        item = it,
                        onClick = { item ->
                            onDismissRequest()
                            component.goToPage(item)
                        },
                        isSelected = (it == child.component.current)
                    )
                }
            }

            else -> TODO("This shouldn't be a possibility")
        }
    }
}