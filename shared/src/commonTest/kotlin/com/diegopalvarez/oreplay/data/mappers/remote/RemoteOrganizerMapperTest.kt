package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.remote.dto.events.RemoteOrganizer
import kotlin.test.Test
import kotlin.test.assertEquals

class RemoteOrganizerMapperTest {
    @Test
    fun `GetOrganizer - Valid Organizer`() {
        val organizer = RemoteOrganizer(
            id = "8ea4fc7f-1bf3-42a4-ae84-2e19dc9aa2af",
            name = "Segovia-O",
            country = "Spain",
            region = "Castilla y León"
        )

        val result = getOrganizer(organizer)

        assertEquals("8ea4fc7f-1bf3-42a4-ae84-2e19dc9aa2af", result.id)
        assertEquals("Segovia-O", result.name)
        assertEquals("Spain", result.country)
        assertEquals("Castilla y León", result.region)


    }
}