package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.remote.dto.events.RemoteOrganizer
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class RemoteOrganizerMapperTest {
    @Test
    fun `GetOrganizer - Valid Organizer`() {
        val organizer = RemoteOrganizer(
            id = "8ea4fc7f-1bf3-42a4-ae84-2e19dc9aa2af",
            name = "Segovia-O",
            countryCode = "ES",
            regionCode = "CL",
            province = null,
            city = null,
            region = "Castilla y León"
        )

        val result = getOrganizer(organizer)

        assertEquals("8ea4fc7f-1bf3-42a4-ae84-2e19dc9aa2af", result.id)
        assertEquals("Segovia-O", result.name)
        assertEquals("ES", result.countryCode)
        assertEquals("CL", result.regionCode)
        assertNull(result.province)
        assertNull(result.city)
        assertEquals("Castilla y León", result.region)


    }
}