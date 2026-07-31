package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.mappers.util.getInstant
import com.diegopalvarez.oreplay.data.remote.dto.results.ControlType
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteControl
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteSplit
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class RemoteSplitsMapperTest {
    @Test
    fun `GetSplits - Valid list of splits`() {
        // Create list of splits
        val splitList = listOf(
            RemoteSplit(
                id = "ea17d001-1dfc-4b6a-8c78-7eb2eb0d4096",
                isIntermediate = false,
                readingTime = "2026-06-28T09:50:53.000+00:00",
                points = 0L,
                orderNumber = 4L,
                created = "2026-06-30T08:53:10.658+00:00",
                control = RemoteControl(
                    id = "6c5c5f62-08ca-4834-8fc8-d7d75138c363",
                    station = "100",
                    controlType = ControlType(
                        id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        description = "Normal Control"
                    )
                )
            ),
            RemoteSplit(
                id = "c8af39f9-c402-424a-a0fa-9d961f5ef635",
                isIntermediate = false,
                readingTime = "2026-06-28T09:50:11.000+00:00",
                points = 0L,
                orderNumber = 3L,
                created = "2026-06-30T08:53:10.646+00:00",
                control = RemoteControl(
                    id = "ea5e8c26-5a16-40ac-a7c9-8c1574c42bcd",
                    station = "75",
                    controlType = ControlType(
                        id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        description = "Normal Control"
                    )
                )
            ),
            RemoteSplit(
                id = "541aa644-8dd1-42fd-a1fb-921c64335a1e",
                isIntermediate = false,
                readingTime = "2026-06-28T09:49:22.000+00:00",
                points = 0L,
                orderNumber = 2L,
                created = "2026-06-30T08:53:10.636+00:00",
                control = RemoteControl(
                    id = "157912be-832a-4d19-a804-074876dffdc3",
                    station = "57",
                    controlType = ControlType(
                        id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        description = "Normal Control"
                    )
                )
            ),
            RemoteSplit(
                id = "cedd814e-7817-497e-a664-4b5e2c095aed",
                isIntermediate = false,
                readingTime = "2026-06-28T09:49:01.000+00:00",
                points = 0L,
                orderNumber = 1L,
                created = "2026-06-30T08:53:10.627+00:00",
                control = RemoteControl(
                    id = "865bcb3e-c783-438d-9ac9-216d7427e9ce",
                    station = "65",
                    controlType = ControlType(
                        id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                        description = "Normal Control"
                    )
                )
            ),
        )

        val result = getSplits(
            splits = splitList,
            finishTime = getInstant("2026-06-28T09:51:03.000+00:00")
        )

        assertNotNull(result)
        assertEquals(5, result.size)        // Includes the finish control

        // Test all non-finish controls
        for(i in 0..< result.size - 1) {
            val control = result[i]

            assertNotNull(control)
            assertNotNull(control.id)

            // No additional information is calculated
            assertNull(control.partial)
            assertNull(control.partialDifference)
            assertNull(control.partialPosition)
            assertNull(control.accumulated)
            assertNull(control.accumulatedPosition)
            assertNull(control.accumulatedDifference)
        }

        // Test that the finish control is correct
        assertEquals("Finish", result[result.size - 1].id)
    }

    @Test
    fun `GetSplits - Empty list of splits`() {
        // Create list of splits
        val splitList = emptyList<RemoteSplit>()

        val result = getSplits(
            splits = splitList,
            finishTime = getInstant("2026-06-28T09:51:03.000+00:00")
        )

        assertNotNull(result)
        assertEquals(1, result.size)

        // Test that the only control is a finish
        val control = result.first()

        assertNotNull(control)
        assertNotNull(control.id)
        assertEquals("Finish", control.id)

        // No additional information is calculated
        assertNull(control.partial)
        assertNull(control.partialDifference)
        assertNull(control.partialPosition)
        assertNull(control.accumulated)
        assertNull(control.accumulatedPosition)
        assertNull(control.accumulatedDifference)
    }
}