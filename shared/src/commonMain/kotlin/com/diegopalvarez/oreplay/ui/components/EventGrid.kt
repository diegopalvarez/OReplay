package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
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
    notFoundMessage: String,
    button: @Composable () -> Unit,
    nextPage: Long,
    nextPageFunction: () -> Unit,
    isNextPageLoading: State<Boolean>,
) {
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
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(eventList.value){ event ->
                EventGridItem(event)
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