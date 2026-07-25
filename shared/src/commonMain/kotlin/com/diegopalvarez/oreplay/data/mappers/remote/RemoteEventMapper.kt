package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.mappers.util.getInstant
import com.diegopalvarez.oreplay.data.mappers.util.getLocalDate
import com.diegopalvarez.oreplay.data.mappers.util.getTimezone
import com.diegopalvarez.oreplay.data.remote.dto.events.RemoteEvent
import com.diegopalvarez.oreplay.data.remote.dto.events.RemoteEventResponse
import com.diegopalvarez.oreplay.domain.model.Event
import kotlin.Long

private fun getEvent(remoteEvent: RemoteEvent): Event{
    return Event(
        id = remoteEvent.id,
        isHidden = remoteEvent.isHidden,
        description = remoteEvent.description,
        picture = remoteEvent.picture,
        website = remoteEvent.website,
        scope = remoteEvent.scope,
        location = remoteEvent.location,
        countryCode = remoteEvent.countryCode,
        initialDate = getLocalDate(remoteEvent.initialDate),
        finalDate = getLocalDate(remoteEvent.finalDate),
        timezone = getTimezone(remoteEvent.timezone),
        federation = remoteEvent.federationID,
        created = getInstant(remoteEvent.created),
        modified = getInstant(remoteEvent.modified),
        organizer = getOrganizer(remoteEvent.organizer),
        selfLink = remoteEvent.links.self.href
        // The stages are missing and must be added when parsed
    )
}

/**
 * Function to parse the response from getting a list of events
 * @param remoteEventResponse response gotten from the API
 * @return Triple formed with the list of events, number of results and link to the next page of results (or null if it doesn't exist).
 * The list of events doesn't include stages, since they must be parsed separately
 */
fun getEventList(remoteEventResponse: RemoteEventResponse): Triple<List<Event>, Long, Long?>{
    val eventList = remoteEventResponse.data.map(::getEvent)
    val next: Long? = remoteEventResponse.links.next?.href
        ?.substringAfterLast("=")
        ?.removeSuffix("\"")
        ?.toLong()
    return Triple(eventList, remoteEventResponse.total, next)
}