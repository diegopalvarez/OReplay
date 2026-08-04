package com.diegopalvarez.oreplay.feature.events.common

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.domain.model.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class AbstractEventComponent(
    componentContext: ComponentContext,
): ComponentContext by componentContext {
    // Coroutine Scope
    val scope = CoroutineScope(Dispatchers.Default)

    // List of Live Events
    protected val _eventList = MutableValue<List<Event>>(emptyList())
    val eventList: Value<List<Event>> = _eventList

    // Variable to state if there's an error
    protected val _isError = MutableValue(false)
    val isError: Value<Boolean> = _isError

    protected val _errorType = MutableValue<RepositoryError>(RepositoryError.UNKNOWN)
    val errorType: Value<RepositoryError> = _errorType

    // Variable to store if the component has been initialized
    protected val _isInit = MutableValue(false)
    val isInit: Value<Boolean> = _isInit

    // Variable to control the refresh state
    protected val _isRefreshing = MutableValue(false)
    val isRefreshing: Value<Boolean> = _isRefreshing

    // Function to update the refresh state
    fun onRefresh() {
        _isRefreshing.value = true

        // Fetch the events again
        scope.launch {
            fetchEvents()
        }
    }

    // Function to fetch the events from the Repository
    abstract suspend fun fetchEvents()
}