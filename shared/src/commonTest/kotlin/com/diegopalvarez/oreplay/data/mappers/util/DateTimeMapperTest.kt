package com.diegopalvarez.oreplay.data.mappers.util

import kotlinx.datetime.IllegalTimeZoneException
import kotlinx.datetime.number
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.time.Duration.Companion.seconds
import kotlin.time.Instant

class DateTimeMapperTest {

    /**
     * Tests for GetLocalDate
     */
    @Test
    fun `GetLocalDate - Valid Date`() {
        val result = getLocalDate("2024-01-15")

        assertEquals(2024, result.year)
        assertEquals(1, result.month.number)
        assertEquals(15, result.day)
    }

    @Test
    fun `GetLocalDate - Valid Leap Year Date`() {
        val result = getLocalDate("2024-02-29")

        assertEquals(2024, result.year)
        assertEquals(2, result.month.number)
        assertEquals(29, result.day)
    }

    @Test
    fun `GetLocalDate - Invalid Leap Year Date`() {
        assertFailsWith<IllegalArgumentException> {
            getLocalDate("2023-02-29")
        }
    }

    @Test
    fun `GetLocalDate - Invalid Format`() {
        assertFailsWith<IllegalArgumentException> {
            getLocalDate("15-01-2024")
        }
    }

    @Test
    fun `GetLocalDate - Not a Date`() {
        assertFailsWith<IllegalArgumentException> {
            getLocalDate("not-a-date")
        }
    }

    @Test
    fun `GetLocalDate - Empty Date`() {
        assertFailsWith<IllegalArgumentException> {
            getLocalDate("")
        }
    }

    @Test
    fun `GetLocalDate - Invalid Date and Time`() {
        assertFailsWith<IllegalArgumentException> {
            getLocalDate("2024-01-15T10:00:00")
        }
    }

    /**
     * Tests for GetTimeZone
     */

    @Test
    fun `GetTimezone - UTC`() {
        val result = getTimezone("UTC")

        assertEquals("UTC", result.id)
    }

    @Test
    fun `GetTimezone - Valid Time Zones`() {
        val result1 = getTimezone("America/New_York")
        assertEquals("America/New_York", result1.id)

        val result2 = getTimezone("Europe/Madrid")
        assertEquals("Europe/Madrid", result2.id)
    }

    @Test
    fun `GetTimeZone - Offset TimeZone`() {
        val result = getTimezone("+02:00")

        assertEquals("+02:00", result.id)
    }

    @Test
    fun `GetTimeZone - Illegal TimeZone`() {
        assertFailsWith<IllegalTimeZoneException> {
            getTimezone("Not/A_Real_Zone")
        }
    }

    @Test
    fun `GetTimeZone - Empty TimeZone`() {
        assertFailsWith<IllegalTimeZoneException> {
            getTimezone("")
        }
    }

    /**
     * Tests for getInstant
     */

    @Test
    fun `GetInstant - Valid UTC Instant`() {
        val result = getInstant("2024-01-15T10:30:00Z")
        assertEquals(Instant.parse("2024-01-15T10:30:00Z"), result)
        assertEquals("2024-01-15T10:30:00Z", result.toString())
    }

    @Test
    fun `GetInstant - Valid Offset Instant`() {
        val result = getInstant("2024-01-15T10:30:00+02:00")

        // 10:30 at +02:00 is 08:30 UTC.
        assertEquals(Instant.parse("2024-01-15T08:30:00Z"), result)
        assertEquals("2024-01-15T08:30:00Z", result.toString())
    }

    @Test
    fun `GetInstant - Valid Negative Offset Instant`() {
        val result = getInstant("2024-01-15T10:30:00-05:00")

        // 10:30 at -05:00 is 15:30 UTC.
        assertEquals(Instant.parse("2024-01-15T15:30:00Z"), result)
        assertEquals("2024-01-15T15:30:00Z", result.toString())
    }

    @Test
    fun `GetInstant - Invalid Only Date`() {
        assertFailsWith<IllegalArgumentException> {
            getInstant("2024-01-15")
        }
    }

    @Test
    fun `GetInstant - Invalid Malformed Offset`() {
        // Instant.parse requires an explicit offset/zone designator (e.g. Z).
        assertFailsWith<IllegalArgumentException> {
            getInstant("2024-01-15T10:30:00")
        }
    }

    @Test
    fun `GetInstant - Invalid Empty Instant`() {
        assertFailsWith<IllegalArgumentException> {
            getInstant("")
        }
    }

    /**
     * Tests for Duration
     */

    @Test
    fun `GetDuration - Valid Positive Seconds`() {
        val result = getDuration(60L)

        assertEquals(60.seconds, result)
    }

    @Test
    fun `GetDuration - Valid Zero Seconds`() {
        val result = getDuration(0L)

        assertEquals(0.seconds, result)
    }

    @Test
    fun `GetDuration - Valid Negative Seconds`() {
        val result = getDuration(-30L)

        assertEquals((-30).seconds, result)
    }

    @Test
    fun `GetDuration - Valid Long Duration in Seconds`() {
        val oneDayInSeconds = 86_400L
        val result = getDuration(oneDayInSeconds)

        assertEquals(oneDayInSeconds.seconds, result)
    }

    @Test
    fun `GetDuration - Valid Biggest Long Seconds`() {
        val result = getDuration(Long.MAX_VALUE)

        // Duration saturates at Duration.INFINITE rather than throwing/overflowing.
        assertEquals(Long.MAX_VALUE.seconds, result)
    }

    @Test
    fun `GetDuration - Valid Get Seconds`() {
        val seconds = 12_345L
        val result = getDuration(seconds)

        assertEquals(seconds, result.inWholeSeconds)
    }
}