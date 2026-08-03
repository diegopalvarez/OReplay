package com.diegopalvarez.oreplay.domain.repository

import com.diegopalvarez.oreplay.core.util.RepositoryError
import com.diegopalvarez.oreplay.core.util.Result
import com.diegopalvarez.oreplay.data.mappers.remote.getEventList
import com.diegopalvarez.oreplay.data.remote.api.OReplayAPI
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.repository.util.handleNetworkError
import kotlinx.datetime.LocalDate
import org.koin.core.component.KoinComponent

class EventRepository(
    val api: OReplayAPI
): KoinComponent {

    /**
     * Repository function that gets the PAST EVENTS from all data sources and returns domain model objects
     * @param page Optionally, allows to search a page of results
     * @return RepositoryError if the search fails. In case of success, a Triple containing the list of past events, the number of results and the number of the next page of results (if it exists)
     */
    suspend fun getPastEvents(page: Long? = null): Result<Triple<List<Event>, Long, Long?>, RepositoryError> {
        val remoteEvents = api.getEvents("past", page)

        return when(remoteEvents) {
            is Result.Success -> {
                Result.Success(getEventList(remoteEvents.data))
            }
            is Result.Error -> {
                // TODO - Implement cache as fallback
                Result.Error(handleNetworkError(remoteEvents.error))
            }
        }
    }

    /**
     * Repository function that gets the LIVE EVENTS from all data sources and returns domain model objects
     * @param page Optionally, allows to search a page of results
     * @return RepositoryError if the search fails. In case of success, a Triple containing the list of live events, the number of results and the number of the next page of results (if it exists)
     */
    suspend fun getLiveEvents(page: Long? = null): Result<Triple<List<Event>, Long, Long?>, RepositoryError> {
        val remoteEvents = api.getEvents("live", page)

        return when(remoteEvents) {
            is Result.Success -> {
                Result.Success(getEventList(remoteEvents.data))
            }
            is Result.Error -> {
                // TODO - Implement cache as fallback
                Result.Error(handleNetworkError(remoteEvents.error))
            }
        }
    }

    /**
     * Repository function that gets the FUTURE EVENTS from all data sources and returns domain model objects
     * @param page Optionally, allows to search a page of results
     * @return RepositoryError if the search fails. In case of success, a Triple containing the list of future events, the number of results and the number of the next page of results (if it exists)
     */
    suspend fun getFutureEvents(page: Long? = null): Result<Triple<List<Event>, Long, Long?>, RepositoryError> {
        val remoteEvents = api.getEvents("future", page)

        return when(remoteEvents) {
            is Result.Success -> {
                Result.Success(getEventList(remoteEvents.data))
            }
            is Result.Error -> {
                // TODO - Implement cache as fallback
                Result.Error(handleNetworkError(remoteEvents.error))
            }
        }
    }

    /**
     * Repository function that gets the EVENTS THAT MATCH THE GIVEN FILTERS from all data sources and returns domain model objects
     * @param description Name of the event searched
     * @param rangeStart Minimum searched final date for the events, lower limit of the range. If null, it searches all events in the past
     * @param rangeEnd Maximum searched initial date for the events, upper limit of the range. If null, it searches all events in the future
     * @return RepositoryError if the search fails. In case of success, only the list of matching events, since 10 (the limit) is a good number of search results to display
     */
    suspend fun searchEvents(description: String?, rangeStart: LocalDate?, rangeEnd: LocalDate?): Result<List<Event>, RepositoryError> {
        val remoteEvents = api.getEventsFiltered(
            description = description,
            initialDate = rangeEnd,
            finalDate = rangeStart
            )

        return when(remoteEvents) {
            is Result.Success -> {
                Result.Success(getEventList(remoteEvents.data).first)
            }
            is Result.Error -> {
                // TODO - Implement cache as fallback
                Result.Error(handleNetworkError(remoteEvents.error))
            }
        }
    }
}