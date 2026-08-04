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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

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

    // Variable to control the next page of results available
    protected val _nextPage = MutableValue(-1L)
    val nextPage: Value<Long> = _nextPage

    // Variable to control if the next page of results is loading
    protected val _nextPageLoading = MutableValue(false)
    val nextPageLoading: Value<Boolean> = _nextPageLoading

    // Function to update the refresh state
    fun onRefresh() {
        _isRefreshing.value = true

        // Fetch the events again
        scope.launch {
            fetchEvents()
            // It should happen here, after the suspended function finalizes
            _isRefreshing.value = false
        }
    }

    // Function to get next page of results
    fun onNextPage() {
        _nextPageLoading.value = true

        // Fetch the events again
        scope.launch {
            fetchNextPage()
            // It should happen here, after the suspended function finalizes
            _nextPageLoading.value = false
        }
    }

    // Function to fetch the events from the Repository
    abstract suspend fun fetchEvents()

    // Function to load the next page of events from the Repository
    abstract suspend fun fetchNextPage()
}