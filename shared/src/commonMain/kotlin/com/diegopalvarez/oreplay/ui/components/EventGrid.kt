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
import com.diegopalvarez.oreplay.feature.events.common.getExpandedGridSize
import com.diegopalvarez.oreplay.ui.util.isExpandedDevice

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
    // Determine the number of elements in each grid row depending on the device
    val isLargeDevice = isExpandedDevice()

    val gridSize = if(isLargeDevice) {
        getExpandedGridSize()
    }
    else{
        2
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
    ){
        // Calculate the minimum width
        val horizontalPadding = 16.dp
        val itemSpacing = 16.dp
        val aspectRatio = 1.2f

        val cardWidth = (maxWidth - horizontalPadding*2 - itemSpacing) / gridSize

        val minCardHeight = cardWidth / aspectRatio

        // Content of the screen
        if(eventList.value.isEmpty()){
            ScrollableLazyColumn(
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
            ScrollableLazyGrid(
                columns = GridCells.Fixed(1),
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                // Divide the events in groups
                items(eventList.value.chunked(gridSize)){ events ->
                    EventGridRow(
                        events,
                        onEventClick,
                        minCardHeight,
                        gridSize,
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