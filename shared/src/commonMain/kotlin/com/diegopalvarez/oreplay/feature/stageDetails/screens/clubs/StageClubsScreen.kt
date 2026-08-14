package com.diegopalvarez.oreplay.feature.stageDetails.screens.clubs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.diegopalvarez.oreplay.feature.stageDetails.components.ClassListItem
import com.diegopalvarez.oreplay.feature.stageDetails.components.ClubListItem
import com.diegopalvarez.oreplay.ui.components.ErrorHelper
import com.diegopalvarez.oreplay.ui.components.NoDataScreen

@Composable
fun StageClubsScreen(
    component: StageClubsComponent
){
    // TODO - Avoid code repetition

    // Subscribe to the list of Classes
    val clubList = component.list.subscribeAsState()

    // Subscribe to the loading state
    val isLoaded = component.isLoaded.subscribeAsState()

    // Subscribe to the error state
    val isError = component.isError.subscribeAsState()

    // Subscribe to the type of error received
    val errorType = component.errorType.subscribeAsState()

    if(!isLoaded.value){
        // If the data hasn't loaded yet, show a progress indicator
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }
    else{
        if(isError.value){
            ErrorHelper(errorType.value)
        }
        else if(clubList.value.isEmpty()){
            NoDataScreen()
        }
        else{
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(clubList.value){
                    ClubListItem(
                        club = it,
                        onClick = { stageClub ->
                            component.onClubClick(stageClub)
                        }
                    )
                }
            }
        }
    }
}