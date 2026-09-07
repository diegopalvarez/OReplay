package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.Event

@Composable
fun EventGrid(
    eventList: State<List<Event>>,
    onEventClick: (Event) -> Unit,
    notFoundMessage: String,
    button: @Composable () -> Unit,
    nextPage: Long,
    nextPageFunction: () -> Unit,
    isNextPageLoading: State<Boolean>,
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
    ){
        // Calculate the minimum width
        val horizontalPadding = 16.dp
        val itemSpacing = 16.dp
        val aspectRatio = 1.2f

        val cardWidth = (maxWidth - horizontalPadding*2 - itemSpacing) / 2

        val minCardHeight = cardWidth / aspectRatio

        // Content of the screen
        if(eventList.value.isEmpty()){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                item{
                    Text(
                        text = notFoundMessage,
                        textAlign = TextAlign.Center,
                    )
                }

                item {
                    button()
                }
            }
        }
        else{
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                // Divide the events in groups of 2
                items(eventList.value.chunked(2)){ events ->
                    EventGridRow(
                        events,
                        onEventClick,
                        minCardHeight
                    )
                }

                // Add as a las element a Load More button
                if(nextPage != -1L){
                    item(
                        span = { GridItemSpan(maxLineSpan)}
                    ){
                        NextPageButton(
                            loadFunction = nextPageFunction,
                            isNextPageLoading = isNextPageLoading,
                        )
                    }

                }
            }
        }
    }


}