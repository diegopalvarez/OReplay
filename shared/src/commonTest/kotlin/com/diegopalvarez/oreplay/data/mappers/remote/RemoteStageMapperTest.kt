package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.mappers.util.getInstant
import com.diegopalvarez.oreplay.data.remote.dto.events.RemoteOrganizer
import com.diegopalvarez.oreplay.data.remote.dto.links.RemoteLink
import com.diegopalvarez.oreplay.data.remote.dto.links.RemoteSelfLink
import com.diegopalvarez.oreplay.data.remote.dto.stages.RemoteEventDetails
import com.diegopalvarez.oreplay.data.remote.dto.stages.RemoteEventDetailsResponse
import com.diegopalvarez.oreplay.data.remote.dto.stages.RemoteStage
import com.diegopalvarez.oreplay.data.remote.dto.stages.RemoteStageLinks
import com.diegopalvarez.oreplay.data.remote.dto.stages.RemoteStageType
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class RemoteStageMapperTest {
    /**
     * Tests for GetStages
     * Functionality for the private function GetStage is also indirectly tested inside GetStages
     */
    @Test
    fun `GetStages - Valid List of Stages`() {
        val remoteStage = RemoteStage(
            id = "86e6b0da-dc15-4211-9825-a72e190138f3",
            description = "Media",
            start = "2026-06-26T22:00:00.000+00:00",
            stageType = RemoteStageType(
                id = "29d5050b-4769-4be5-ace4-7e5973f68e3c",
                description = "Classic"
            ),
            lastLogs = emptyList(),
            links = RemoteStageLinks(
                self = RemoteLink(href = "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977/stages/86e6b0da-dc15-4211-9825-a72e190138f3"),
                results = RemoteLink(href = "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977/stages/86e6b0da-dc15-4211-9825-a72e190138f3/results/"),
                classes = RemoteLink(href = "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977/stages/86e6b0da-dc15-4211-9825-a72e190138f3/classes/")
            )
        )

        val response = RemoteEventDetailsResponse(
            details = RemoteEventDetails(
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
                stages = listOf(remoteStage),
                federation = null,
                links = RemoteSelfLink(
                    self = RemoteLink(href = "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977"))
            )
        )

        val result = getStages(response)

        assertEquals(1, result.size)
        val mapped = result.first()

        assertEquals("86e6b0da-dc15-4211-9825-a72e190138f3", mapped.id)
        assertEquals("Media", mapped.description)
        assertEquals(getInstant("2026-06-26T22:00:00.000+00:00"), mapped.start)
        assertEquals("29d5050b-4769-4be5-ace4-7e5973f68e3c", mapped.stageType)
        // classes/clubs are intentionally not mapped in this mapper
        assertNull(mapped.classes)
        assertNull(mapped.clubs)
    }

    @Test
    fun `GetStages - Valid Null Start`() {
        val remoteStage = RemoteStage(
            id = "86e6b0da-dc15-4211-9825-a72e190138f3",
            description = "Media",
            start = null,
            stageType = RemoteStageType(
                id = "29d5050b-4769-4be5-ace4-7e5973f68e3c",
                description = "Classic"
            ),
            lastLogs = emptyList(),
            links = RemoteStageLinks(
                self = RemoteLink(href = "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977/stages/86e6b0da-dc15-4211-9825-a72e190138f3"),
                results = RemoteLink(href = "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977/stages/86e6b0da-dc15-4211-9825-a72e190138f3/results/"),
                classes = RemoteLink(href = "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977/stages/86e6b0da-dc15-4211-9825-a72e190138f3/classes/")
            )
        )

        val response = RemoteEventDetailsResponse(
            details = RemoteEventDetails(
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
                stages = listOf(remoteStage),
                federation = null,
                links = RemoteSelfLink(
                    self = RemoteLink(href = "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977"))
            )
        )

        val result = getStages(response)

        assertEquals(1, result.size)
        val mapped = result.first()

        assertEquals("86e6b0da-dc15-4211-9825-a72e190138f3", mapped.id)
        assertEquals("Media", mapped.description)
        assertNull(mapped.start)
        assertEquals("29d5050b-4769-4be5-ace4-7e5973f68e3c", mapped.stageType)
        // classes/clubs are intentionally not mapped in this mapper
        assertNull(mapped.classes)
        assertNull(mapped.clubs)
    }

    @Test
    fun `GetStages - Empty List of Stages`() {
        val response = RemoteEventDetailsResponse(
            details = RemoteEventDetails(
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
                stages = emptyList(),
                federation = null,
                links = RemoteSelfLink(
                    self = RemoteLink(href = "https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977"))
            )
        )

        val result = getStages(response)

        assertTrue(result.isEmpty())
    }
}