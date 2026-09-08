package com.diegopalvarez.oreplay.feature.results.common.components.history

import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonMenu
import androidx.compose.material3.FloatingActionButtonMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleFloatingActionButton
import androidx.compose.material3.ToggleFloatingActionButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub
import com.diegopalvarez.oreplay.domain.wrappers.ResultHistory
import com.diegopalvarez.oreplay.feature.results.common.navigation.AbstractResultsComponent
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.add
import oreplay.shared.generated.resources.add_icon
import oreplay.shared.generated.resources.category
import oreplay.shared.generated.resources.change
import oreplay.shared.generated.resources.change_icon
import oreplay.shared.generated.resources.class_icon
import oreplay.shared.generated.resources.close
import oreplay.shared.generated.resources.close_icon
import oreplay.shared.generated.resources.club
import oreplay.shared.generated.resources.club_icon
import oreplay.shared.generated.resources.see_more
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun FABHistory(
    component: AbstractResultsComponent,
    onOpenDialog: () -> Unit
){
    // Store if the menu is expanded or not
    var expanded by remember { mutableStateOf(false) }

    // Get the list of items in the history
    val items = component.stageHistory.getHistory()

    // Create the FAB menu
    FloatingActionButtonMenu(
        modifier = Modifier
            .offset(x = 16.dp, y = 16.dp),        // TODO - Find a better way to space the FAB Menu
        expanded = expanded,
        button = {
            // Create the actual FAB that displays when closed
            ToggleFloatingActionButton(
                checked = expanded,
                onCheckedChange = {
                    // If the history is empty, show the dialog directly
                    if(items.isEmpty()){
                        onOpenDialog()
                    }
                    else{
                        // Update the expanded state
                        expanded = it
                    }
                },
                containerColor = ToggleFloatingActionButtonDefaults.containerColor(
                    initialColor = MaterialTheme.colorScheme.secondaryContainer,
                    finalColor = MaterialTheme.colorScheme.secondary,
                )
            ) {
                // Change the Icon displayed depending on the state
                Icon(
                    painter = painterResource(
                        if(expanded) Res.drawable.close else Res.drawable.change
                    ),
                    contentDescription = stringResource(
                        if(expanded) Res.string.close_icon else Res.string.change_icon
                    ),
                    tint = if(expanded) {
                        MaterialTheme.colorScheme.onSecondary
                    }
                    else{
                        MaterialTheme.colorScheme.onSecondaryContainer
                    }
                )
            }
        }
    ) {
        // Add the item to show the whole dialog
        FloatingActionButtonMenuItem(
            onClick = {
                onOpenDialog()
            },
            text = {
                Text(stringResource(Res.string.see_more))
            },
            icon = {
                // Show the icon to select a different class or club
                Icon(
                    painter = painterResource(Res.drawable.add),
                    contentDescription = stringResource(Res.string.add_icon),
                )
            },
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )

        // Content of the menu
        items.reversed().forEach { item ->
            when (item) {
                is StageClass -> {
                    FloatingActionButtonMenuItem(
                        onClick = {
                            component.goToPage(item)
                        },
                        text = {
                            Text(item.shortName)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(Res.drawable.category),
                                contentDescription = stringResource(Res.string.class_icon),
                            )
                        },
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    )
                }
                is StageClub -> {
                    FloatingActionButtonMenuItem(
                        onClick = {
                            component.goToPage(item)
                        },
                        text = {
                            Text(item.shortName)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(Res.drawable.club),
                                contentDescription = stringResource(Res.string.club_icon),
                            )
                        },
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    )
                }
            }

        }
    }
}