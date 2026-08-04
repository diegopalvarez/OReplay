package com.diegopalvarez.oreplay.feature.events.screens.futureEvents

import com.arkivanov.decompose.ComponentContext
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.domain.repository.EventRepository
import com.diegopalvarez.oreplay.feature.events.common.AbstractEventComponent
import kotlinx.coroutines.launch

class FutureEventsComponent(
    componentContext: ComponentContext,
    private val repository: EventRepository
): AbstractEventComponent(componentContext) {
    // Function to fetch the events from the Repository
    override suspend fun fetchEvents(){
        repository.getFutureEvents()
            .onSuccess {
                _isError.value = false
                _eventList.value = it.first
                _isInit.value = true
            }
            .onError {
                _isError.value = true
                _errorType.value = it
            }
        _isRefreshing.value = false
    }


    // The init function should be in the Implementation of the abstract class to avoid errors
    init {
        // Load the events from the Repository
        scope.launch {
            fetchEvents()
        }
    }
}