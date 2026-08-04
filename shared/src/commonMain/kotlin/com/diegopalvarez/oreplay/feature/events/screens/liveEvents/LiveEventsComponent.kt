package com.diegopalvarez.oreplay.feature.events.screens.liveEvents

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.repository.EventRepository
import com.diegopalvarez.oreplay.feature.events.common.AbstractEventComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LiveEventsComponent(
    componentContext: ComponentContext,
    private val repository: EventRepository
): AbstractEventComponent(componentContext) {
    // Function to fetch the events from the Repository
    override suspend fun fetchEvents(){
        repository.getLiveEvents()
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

    // Function to go to Future Events
    fun goToFutureEvents(){
    }
}