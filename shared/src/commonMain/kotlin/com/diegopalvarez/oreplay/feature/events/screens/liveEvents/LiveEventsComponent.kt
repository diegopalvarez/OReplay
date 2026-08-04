package com.diegopalvarez.oreplay.feature.events.screens.liveEvents

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.repository.EventRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource

class LiveEventsComponent(
    componentContext: ComponentContext,
    private val repository: EventRepository
): ComponentContext by componentContext {

    // Coroutine Scope
    val scope = CoroutineScope(Dispatchers.Default)

    // List of Live Events
    private val _liveEventList = MutableValue<List<Event>>(emptyList())
    val liveEventList: Value<List<Event>> = _liveEventList

    // Variable to state if there's an error
    private val _isError = MutableValue(false)
    val isError: Value<Boolean> = _isError

    private val _errorType = MutableValue<RepositoryError>(RepositoryError.UNKNOWN)
    val errorType: Value<RepositoryError> = _errorType

    // Variable to store if the component has been initialized
    private val _isInit = MutableValue(false)
    val isInit: Value<Boolean> = _isInit

    init {
        // Load the events from the Repository
        scope.launch {
            fetchEvents()
        }
    }

    // Variable to control the refresh state
    private val _isRefreshing = MutableValue(false)
    val isRefreshing: Value<Boolean> = _isRefreshing

    // Function to update the refresh state
    fun onRefresh() {
        _isRefreshing.value = true

        // TODO - Handle if I want to keep the old results or just diplay an error
        // Fetch the events again
        scope.launch {
            fetchEvents()
        }
    }

    // Function to fetch the events from the Repository
    suspend fun fetchEvents(){
        repository.getLiveEvents()
            .onSuccess {
                _isError.value = false
                _liveEventList.value = it.first
                _isInit.value = true
            }
            .onError {
                _isError.value = true
                _errorType.value = it
            }
        _isRefreshing.value = false
    }
}