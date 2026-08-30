package com.diegopalvarez.oreplay.feature.eventStages.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.ui.util.display
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.event
import oreplay.shared.generated.resources.event_date
import oreplay.shared.generated.resources.event_organizer
import oreplay.shared.generated.resources.open
import oreplay.shared.generated.resources.open_website
import oreplay.shared.generated.resources.person
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun EventDetailsSummary(
    event: Event,
    padding: PaddingValues,
){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .aspectRatio(2f),
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
        ) {
            // Event Description at the top of the card
            Text(
                text = event.description,
                style = MaterialTheme.typography.titleLarge,
            )

            // Rest of the information at the bottom
            Column{
                // Event Organizer
                IconRow(
                    text = event.organizer.name,
                    style = MaterialTheme.typography.bodyLarge,
                    icon = Res.drawable.person,
                    iconDescription = Res.string.event_organizer
                )

                // Event Dates
                IconRow(
                    text =  if(event.initialDate != event.finalDate){
                        "${event.initialDate.display()} - ${event.finalDate.display()}"
                    }
                    else{
                        event.initialDate.display()
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    icon = Res.drawable.event,
                    iconDescription = Res.string.event_date
                )

                // Event Website Link
                if(event.website != null){
                    // Create the URI handler to open links
                    val localURIHandler = LocalUriHandler.current

                    Button(
                        onClick = {
                            localURIHandler.openUri(event.website)
                        }
                    ){
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = stringResource(Res.string.open_website),
                            )
                            Icon(
                                painter = painterResource(Res.drawable.open),
                                contentDescription = stringResource(Res.string.open_website),
                            )
                        }
                    }
                }
            }

        }

    }
}