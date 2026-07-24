package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.remote.dto.results.ControlType
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteControl
import com.diegopalvarez.oreplay.domain.model.Control
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RemoteControlMapperTest {
    @Test
    fun `GetControl - Valid RemoteControl`() {
        val remoteControl = RemoteControl(
            id = "e8792646-901e-46b7-bddb-31601dfc8669",
            station = "78",
            controlType = ControlType(
                id = "f3cc5efa-065f-4ad6-844b-74e99612889b",
                description = "Normal Control"
            )
        )

        val result = getControl(remoteControl)
        assertTrue(result is Control)

        assertEquals("e8792646-901e-46b7-bddb-31601dfc8669", result.id)
        assertEquals("78", result.station)
        assertEquals("f3cc5efa-065f-4ad6-844b-74e99612889b", result.controlType)    // Only the Control Type ID is kept
    }
}