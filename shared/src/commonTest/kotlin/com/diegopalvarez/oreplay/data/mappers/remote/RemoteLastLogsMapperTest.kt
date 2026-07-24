package com.diegopalvarez.oreplay.data.mappers.remote

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.diegopalvarez.oreplay.data.remote.dto.stages.RemoteLastLog
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class RemoteLastLogsMapperTest {
    @Test
    fun `GetStageState - Valid List of States`() {
        val list = listOf(
            RemoteLastLog(
                state = 1,
                created = "2026-07-17T14:00:26.000+00:00"
            ),
            RemoteLastLog(
                state = 0,
                created = "2026-07-17T13:59:57.000+00:00"
            ),
            RemoteLastLog(
                state = 2,
                created = "2026-07-18T11:49:32.000+00:00"
            )
        )

        val result = getStageState(list)

        assertEquals(result, 2L)
    }

    @Test
    fun `GetStageState - Unique Valid State`() {
        val list = listOf(
            RemoteLastLog(
                state = 0,
                created = "2026-07-17T13:59:57.000+00:00"
            )
        )

        val result = getStageState(list)

        assertEquals(result, 0L)
    }

    @Test
    fun `GetStageState - Empty Last Logs List`() {
        val result = getStageState(emptyList())

        assertNull(result)
    }
}