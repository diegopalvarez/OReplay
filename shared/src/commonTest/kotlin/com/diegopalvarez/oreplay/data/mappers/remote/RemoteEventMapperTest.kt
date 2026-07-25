package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.mappers.util.getInstant
import com.diegopalvarez.oreplay.data.mappers.util.getLocalDate
import com.diegopalvarez.oreplay.data.mappers.util.getTimezone
import com.diegopalvarez.oreplay.data.remote.dto.events.RemoteEvent
import com.diegopalvarez.oreplay.data.remote.dto.events.RemoteEventResponse
import com.diegopalvarez.oreplay.data.remote.dto.events.RemoteOrganizer
import com.diegopalvarez.oreplay.data.remote.dto.links.RemoteLink
import com.diegopalvarez.oreplay.data.remote.dto.links.RemotePageListLinks
import com.diegopalvarez.oreplay.data.remote.dto.links.RemoteSelfLink
import com.diegopalvarez.oreplay.domain.model.Organizer
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class RemoteEventMapperTest {

    /**
     * Tests for GetEventList
     * These tests will indirectly also test the private function GetEvent
     */

    @Test
    fun `GetEventList - List of Complete Events`() {
        val remoteEvent = RemoteEvent(
            id = "70366547-ee34-4b76-9a64-ff66ca9cd977",
            isHidden = false,
            description = "Trofeo Concello de O Grove",
            picture = "https://cdn.oreplay.com/event-1.png",
            website = "https://fegado.es/events/view/i140g1ltxp6n/",
            scope = "r.h",
            location = "Pontevedra",
            countryCode = "ES",
            initialDate = "2026-06-27",
            finalDate = "2026-06-28",
            timezone = "Europe/Madrid",
            federationID = "fed-1",
            created = "2026-06-26T19:52:23.118+00:00",
            modified = "2026-06-26T19:58:29.735+00:00",
            organizerID = "72943f5d-2232-4dc2-852d-84a856c1f6b2",
            organizer = RemoteOrganizer(
                id = "72943f5d-2232-4dc2-852d-84a856c1f6b2",
                name = "AROMON",
                country = "Spain",
                region = "Galicia"
            ),
            links = RemoteSelfLink(
                self = RemoteLink(
                    href = "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977"
                )
            )
        )

        val response = RemoteEventResponse(
            data = listOf(remoteEvent),
            total = 1L,
            limit = 10L,
            links = RemotePageListLinks(
                self = RemoteLink(href = "https://www.oreplay.es/api/v1/events?page=1"),
                next = RemoteLink(href = "https://www.oreplay.es/api/v1/events?page=2")
            )
        )

        val (events, total, next) = getEventList(response)

        // Test the Triple of returned values
        assertEquals(1, events.size)
        assertEquals(1L, total)
        assertEquals(2, next)

        // Test one of the events returned
        val mapped = events.first()
        assertEquals("70366547-ee34-4b76-9a64-ff66ca9cd977", mapped.id)
        assertEquals(false, mapped.isHidden)
        assertEquals("Trofeo Concello de O Grove", mapped.description)
        assertEquals("https://cdn.oreplay.com/event-1.png", mapped.picture)
        assertEquals("https://fegado.es/events/view/i140g1ltxp6n/", mapped.website)
        assertEquals("r.h", mapped.scope)
        assertEquals("Pontevedra", mapped.location)
        assertEquals("ES", mapped.countryCode)
        assertEquals(getLocalDate("2026-06-27"), mapped.initialDate)
        assertEquals(getLocalDate("2026-06-28"), mapped.finalDate)
        assertEquals(getTimezone("Europe/Madrid"), mapped.timezone)
        assertEquals("fed-1", mapped.federation)
        assertEquals(getInstant("2026-06-26T19:52:23.118+00:00"), mapped.created)
        assertEquals(getInstant("2026-06-26T19:58:29.735+00:00"), mapped.modified)

        // The organizer is tested in its own Test Suite
        assertTrue(mapped.organizer is Organizer)

        assertEquals("https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977", mapped.selfLink)

        // Mapper comment indicates stages are intentionally not parsed here
        assertNull(mapped.stages)
    }

    @Test
    fun `GetEventList - Empty list of events`() {
        val response = RemoteEventResponse(
            data = emptyList(),
            total = 0L,
            limit = 10L,
            links = RemotePageListLinks(
                self = RemoteLink(href = "https://www.oreplay.es/api/v1/events?page=1")
            )
        )

        val (events, total, next) = getEventList(response)

        assertTrue(events.isEmpty())
        assertEquals(0L, total)
        assertNull(next)
    }
}