package com.diegopalvarez.oreplay.feature.eventStages.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
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
import oreplay.shared.generated.resources.open
import oreplay.shared.generated.resources.open_website
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
                .padding(16.dp)
        ) {
            // Event Description
            Text(
                text = event.description,
                style = MaterialTheme.typography.titleLarge,
            )

            // Event Organizer
            Text(
                text = event.organizer.name,
                style = MaterialTheme.typography.bodyLarge,
            )

            // Event Dates
            Text(
                text =  if(event.initialDate != event.finalDate){
                            "${event.initialDate.display()} - ${event.finalDate.display()}"
                        }
                        else{
                            event.initialDate.display()
                        },
                style = MaterialTheme.typography.labelLargeEmphasized,
            )

            // Event Website Link
            if(event.website != null){
                // Create the URI handler to open links
                val localURIHandler = LocalUriHandler.current

                Button(
                    onClick = {
                        localURIHandler.openUri(event.website)
                    },
                    modifier = Modifier
                        .align(Alignment.End)
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