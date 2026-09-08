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
    // Subscribe to the selected tab from the component
    val selectedDestination = component.dialogPages.subscribeAsState()

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
            // Tab Row
            SecondaryTabRow(
                selectedTabIndex = selectedDestination.value.selectedIndex
            ) {
                // Classes Tab
                Tab(
                    selected = selectedDestination.value.selectedIndex == 0,
                    onClick = {
                        component.selectDialogTab(0)
                    },
                    text = {
                        Text(
                            stringResource(Res.string.classes_title)
                        )
                    }
                )

                // Classes Tab
                Tab(
                    selected = selectedDestination.value.selectedIndex == 1,
                    onClick = {
                        component.selectDialogTab(1)
                    },
                    text = {
                        Text(
                            stringResource(Res.string.clubs_title)
                        )
                    }
                )
            }

            StageDetailsDialogContent(component, onDismissRequest)
        }
    }
}