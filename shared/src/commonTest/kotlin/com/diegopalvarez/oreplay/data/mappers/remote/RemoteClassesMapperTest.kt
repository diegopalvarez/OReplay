package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.remote.dto.classes.RemoteClass
import com.diegopalvarez.oreplay.data.remote.dto.classes.RemoteClassesResponse
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteClassResults
import com.diegopalvarez.oreplay.domain.model.ResultClass
import com.diegopalvarez.oreplay.domain.model.StageClass
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RemoteClassesMapperTest {

    /**
     * Tests for GetClasses
     * They indirectly test the functionality of the private function getClass
     */

    @Test
    fun `GetClasses - Complete RemoteClassesResponse`() {
        val remoteClassesResponse = RemoteClassesResponse(
            classes = listOf(
                RemoteClass(
                    id = "class-1",
                    shortName = "M21E",
                    longName = "Men 21 Elite",
                    radios = emptyList(),
                ),
            )
        )

        val result = getClasses(remoteClassesResponse)

        assertTrue(result is List<StageClass>)

        assertEquals(1, result.size)
        val mapped = result.first()
        assertEquals("class-1", mapped.id)
        assertEquals("M21E", mapped.shortName)
        assertEquals("Men 21 Elite", mapped.longName)
        assertTrue(mapped.radioControls.isEmpty())
    }

    @Test
    fun `GetClasses - Empty RemoteClassesResponse`() {
        val remoteClassesResponse = RemoteClassesResponse(classes = emptyList())

        val result = getClasses(remoteClassesResponse)

        assertTrue(result is List<StageClass>)
        assertTrue(result.isEmpty())
    }

    /**
     * Tests for GetResultClass
     */

    @Test
    fun `GetResultClass - Complete RemoteClassResults`() {
        val remoteClassResult = RemoteClassResults(
            id = "class-r-1",
            shortName = "W21E",
            longName = "Women 21 Elite",
            // A RemoteClassResult doesn't have radios
        )

        val result = getResultClass(remoteClassResult)

        assertTrue(result is ResultClass)

        assertEquals("class-r-1", result.id)
        assertEquals("W21E", result.shortName)
        assertEquals("Women 21 Elite", result.longName)
    }
}