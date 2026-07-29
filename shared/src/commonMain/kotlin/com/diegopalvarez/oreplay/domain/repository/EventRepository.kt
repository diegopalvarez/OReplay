package com.diegopalvarez.oreplay.domain.repository

import com.diegopalvarez.oreplay.core.util.NetworkError
import com.diegopalvarez.oreplay.core.util.Result
import com.diegopalvarez.oreplay.core.util.onError
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.data.mappers.remote.getEventList
import com.diegopalvarez.oreplay.data.remote.api.OReplayAPI
import com.diegopalvarez.oreplay.domain.model.Event
import kotlinx.datetime.LocalDate
import org.koin.core.component.KoinComponent

class EventRepository(
    val api: OReplayAPI
): KoinComponent {

    /**
     * Repository function that gets the PAST EVENTS from all data sources and returns domain model objects
     * @param page Optionally, allows to search a page of results
     * @return NetworkError if the search fails. In case of success, a Triple containing the list of past events, the number of results and the number of the next page of results (if it exists)
     */
    suspend fun getPastEvents(page: Long? = null): Result<Triple<List<Event>, Long, Long?>, NetworkError> {
        val remoteEvents = api.getEvents("past", page)

        return when(remoteEvents) {
            is Result.Success -> {
                Result.Success(getEventList(remoteEvents.data))
            }
            is Result.Error -> {
                // TODO - Implement cache as fallback
                Result.Error(remoteEvents.error)
            }
        }
    }

    /**
     * Repository function that gets the LIVE EVENTS from all data sources and returns domain model objects
     * @param page Optionally, allows to search a page of results
     * @return NetworkError if the search fails. In case of success, a Triple containing the list of live events, the number of results and the number of the next page of results (if it exists)
     */
    suspend fun getLiveEvents(page: Long? = null): Result<Triple<List<Event>, Long, Long?>, NetworkError> {
        val remoteEvents = api.getEvents("live", page)

        return when(remoteEvents) {
            is Result.Success -> {
                Result.Success(getEventList(remoteEvents.data))
            }
            is Result.Error -> {
                // TODO - Implement cache as fallback
                Result.Error(remoteEvents.error)
            }
        }
    }

    /**
     * Repository function that gets the FUTURE EVENTS from all data sources and returns domain model objects
     * @param page Optionally, allows to search a page of results
     * @return NetworkError if the search fails. In case of success, a Triple containing the list of future events, the number of results and the number of the next page of results (if it exists)
     */
    suspend fun getFutureEvents(page: Long? = null): Result<Triple<List<Event>, Long, Long?>, NetworkError> {
        val remoteEvents = api.getEvents("future", page)

        return when(remoteEvents) {
            is Result.Success -> {
                Result.Success(getEventList(remoteEvents.data))
            }
            is Result.Error -> {
                // TODO - Implement cache as fallback
                Result.Error(remoteEvents.error)
            }
        }
    }

    /**
     * Repository function that gets the EVENTS THAT MATCH THE GIVEN FILTERS from all data sources and returns domain model objects
     * @param description Name of the event searched
     * @param initialDate First date of the interval of the search. If null, it searches all events in the past
     * @param finalDate Last date of the interval of the search. If null, it searches all events in the future
     * @return NetworkError if the search fails. In case of success, a Triple containing the list of matching events, the number of results and the number of the next page of results (if it exists)
     */
    suspend fun searchEvents(description: String?, initialDate: LocalDate?, finalDate: LocalDate?): Result<Triple<List<Event>, Long, Long?>, NetworkError> {
        val remoteEvents = api.getEventsFiltered(
            description = description,
            initialDate = initialDate,
            finalDate = finalDate
            )

        return when(remoteEvents) {
            is Result.Success -> {
                Result.Success(getEventList(remoteEvents.data))
            }
            is Result.Error -> {
                // TODO - Implement cache as fallback
                Result.Error(remoteEvents.error)
            }
        }
    }
}