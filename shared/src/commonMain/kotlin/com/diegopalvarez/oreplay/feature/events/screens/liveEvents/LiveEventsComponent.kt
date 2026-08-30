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
import com.diegopalvarez.oreplay.feature.events.navigation.RefreshTrigger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class LiveEventsComponent(
    componentContext: ComponentContext,
    private val repository: EventRepository,
    private val errorRefresh: SharedFlow<RefreshTrigger>,
    private val triggerRefresh: (RefreshTrigger) -> Unit
): AbstractEventComponent(componentContext) {
    // Function to fetch the events from the Repository
    override suspend fun fetchEvents(){
        repository.getLiveEvents()
            .onSuccess {
                // If it was an error, trigger a reload for all screens
                if(_isError.value){
                    triggerRefresh(RefreshTrigger.LIVE)
                }

                _isError.value = false
                _eventList.value = it.first
                _isInit.value = true

                // Check if there are more results that haven't been loaded
                val nextPage: Long? = it.third
                if(nextPage != null){
                    // There's a new page of results
                    _nextPage.value = nextPage
                }
                else{
                    _nextPage.value = -1
                }
            }
            .onError {
                _isError.value = true
                _errorType.value = it
            }
    }

    // The init function should be in the Implementation of the abstract class to avoid errors
    init {
        // Load the events from the Repository
        scope.launch {
            fetchEvents()
        }

        // Subscribe to the reload trigger
        scope.launch {
            errorRefresh.collect {
                if(it != RefreshTrigger.LIVE){
                    onRefresh()
                }
            }
        }
    }

    // Function to load the next page of events
    override suspend fun fetchNextPage() {
        repository.getLiveEvents(page = nextPage.value)
            .onSuccess {
                _isError.value = false
                val newList = _eventList.value.toMutableList()
                newList.addAll(it.first)

                _eventList.value = newList
                _isInit.value = true

                // Check if there are more results that haven't been loaded
                val nextPage: Long? = it.third
                if(nextPage != null){
                    // There's a new page of results
                    _nextPage.value = nextPage
                }
                else{
                    _nextPage.value = -1
                }
            }
            .onError {
                _isError.value = true
                _errorType.value = it
            }
    }
}