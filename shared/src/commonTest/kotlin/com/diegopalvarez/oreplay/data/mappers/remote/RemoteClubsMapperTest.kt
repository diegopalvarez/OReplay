package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.remote.dto.clubs.RemoteClub
import com.diegopalvarez.oreplay.data.remote.dto.clubs.RemoteClubsResponse
import com.diegopalvarez.oreplay.domain.model.StageClub
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RemoteClubsMapperTest {

    /**
     * Tests for GetClub
     */

    @Test
    fun `GetClub - Valid RemoteClub`() {
        val remoteClub = RemoteClub(
            id = "0029c770-6bc5-4623-b8f1-ad806d9ca343",
            shortName = "IFK",
        )

        val result = getClub(remoteClub)
        assertTrue(result is StageClub)

        assertEquals("0029c770-6bc5-4623-b8f1-ad806d9ca343", result.id)
        assertEquals("IFK", result.shortName)
    }

    /**
     * Tests for GetClubs
     */

    @Test
    fun `GetClubs - Valid List of Clubs`() {
        val remoteClubsResponse = RemoteClubsResponse(
            clubs = listOf(
                RemoteClub(id = "0029c770-6bc5-4623-b8f1-ad806d9ca343", shortName = "IFK"),
                RemoteClub(id = "e560852f-ae5a-44a1-af94-8d49bb0c49ad", shortName = "OK LINNE"),
            )
        )

        val result = getClubs(remoteClubsResponse)
        assertTrue(result is List<StageClub>)

        assertEquals(2, result.size)
        assertEquals("0029c770-6bc5-4623-b8f1-ad806d9ca343", result[0].id)
        assertEquals("IFK", result[0].shortName)
        assertEquals("e560852f-ae5a-44a1-af94-8d49bb0c49ad", result[1].id)
        assertEquals("OK LINNE", result[1].shortName)
    }

    @Test
    fun `GetClubs - Empty List of Clubs`() {
        val remoteClubsResponse = RemoteClubsResponse(clubs = emptyList())

        val result = getClubs(remoteClubsResponse)
        assertTrue(result is List<StageClub>)

        assertTrue(result.isEmpty())
    }
}