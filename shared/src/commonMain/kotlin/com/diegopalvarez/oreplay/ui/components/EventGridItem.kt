package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.ui.util.display
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.event
import oreplay.shared.generated.resources.event_date
import oreplay.shared.generated.resources.event_organizer
import oreplay.shared.generated.resources.person
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun EventGridItem(
    event: Event,
    onEventClick: (Event) -> Unit,
){
    Card(
        modifier = Modifier
            .fillMaxHeight()
            .aspectRatio(1.2f),
        onClick = {
            onEventClick(event)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
            // Event Name
            Text(
                text = event.description,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )


            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                // Event Organizer
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Icon(
                        painter = painterResource(Res.drawable.person),
                        contentDescription = stringResource(Res.string.event_organizer),
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        style = MaterialTheme.typography.bodyMedium,
                        text =  event.organizer.name
                    )
                }

                // Event Dates
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Icon(
                        painter = painterResource(Res.drawable.event),
                        contentDescription = stringResource(Res.string.event_date),
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        style = MaterialTheme.typography.labelMediumEmphasized,
                        text =  if(event.initialDate != event.finalDate){
                            "${event.initialDate.display()} - ${event.finalDate.display()}"
                        }
                        else{
                            event.initialDate.display()
                        }
                    )
                }
            }
        }
    }
}