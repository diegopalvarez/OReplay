package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButtonMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.add
import oreplay.shared.generated.resources.add_icon
import oreplay.shared.generated.resources.category
import oreplay.shared.generated.resources.class_icon
import oreplay.shared.generated.resources.club
import oreplay.shared.generated.resources.club_icon
import oreplay.shared.generated.resources.dropdown
import oreplay.shared.generated.resources.dropdown_icon
import oreplay.shared.generated.resources.menu
import oreplay.shared.generated.resources.see_more
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun HistoryDropdownMenu(
    component: AbstractResultsComponent,
    onOpenDialog: () -> Unit,
){
    // Create the state for the dropdown menu
    var isExpanded by remember { mutableStateOf(false) }

    // Get the list of items in the history
    val items = component.stageHistory.getHistory()

    Box {
        // Button to show the dropdown menu
        IconButton(
            onClick = { isExpanded = !isExpanded },
        ) {
            Icon(
                painter = painterResource(Res.drawable.dropdown),
                contentDescription = stringResource(Res.string.dropdown_icon),
            )
        }

        // Dropdown menu
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }
        ) {
            // Add the rest of elements of the history
            items.forEach { item ->
                when (item) {
                    is StageClass -> {
                        DropdownMenuItem(
                            onClick = {
                                component.goToPage(item)
                            },
                            text = {
                                Text(item.shortName)
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(Res.drawable.category),
                                    contentDescription = stringResource(Res.string.class_icon),
                                )
                            },
                        )
                    }

                    is StageClub -> {
                        DropdownMenuItem(
                            onClick = {
                                component.goToPage(item)
                            },
                            text = {
                                Text(item.shortName)
                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(Res.drawable.club),
                                    contentDescription = stringResource(Res.string.club_icon),
                                )
                            },
                        )
                    }
                }
            }

            // Add the menu item to show the whole category menu
            DropdownMenuItem(
                text = {
                    Text(
                        text = stringResource(Res.string.see_more)
                    )
                },
                onClick = onOpenDialog,
                leadingIcon = {
                    Icon(
                        painter = painterResource(Res.drawable.add),
                        contentDescription = stringResource(Res.string.add_icon),
                    )
                }
            )
        }
    }
}