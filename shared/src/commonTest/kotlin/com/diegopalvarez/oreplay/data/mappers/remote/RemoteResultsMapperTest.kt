package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.mappers.remote.objects.RemoteResponse
import com.diegopalvarez.oreplay.data.mappers.util.getInstant
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteResult
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteResultsResponse
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

class RemoteResultsMapperTest {
    /**
     * Tests for getClassicResults
     * They also test indirectly the functionality provided by the private functions getSplit, getSplits, getStageResult,
     * getIndividualResult, calculateIndividualTimes, calculateTime, calculateRanks, getOverallResult, getOverallParts
     * and getOverall
     */

    @Test
    fun `GetClassicResults - List of Valid Results with Splits and CalculateRanks`(){
        val response: List<ResultIndividual> = getClassicResults(RemoteResponse.complete)

        // Check the integrity of the list
        assertTrue(response.isNotEmpty())
        assertEquals(6, response.size)

        // Sort the list by position (0-6), the first one is the MP
        response.forEach {
            assertNotNull(it.stageResult)
        }
        val sortedList = response.sortedBy { it.stageResult!!.position }    // The stageResults have been asserted not null

        // First position (winner)
        val winner = sortedList[1]

        // Test GetIndividualResults and whether the runner information is mapped correctly
        assertEquals("d3fa5295-7787-4524-a048-b0254deb142c", winner.id)
        assertEquals("7461", winner.bibNumber)
        assertFalse(winner.isNc)
        assertNull(winner.eligibility)
        assertEquals("8545840", winner.siCard)
        assertEquals("F", winner.sex)
        assertEquals(1L, winner.legNumber)
        assertEquals(getInstant("2026-06-30T08:53:09.534+00:00"), winner.created)
        // The runnerClass and runnerClub are tested on their own tests
        assertNotNull(winner.runnerClass)
        assertNotNull(winner.runnerClub)
        assertEquals("Nerea Loira Camiña", winner.fullName)

        // Test GetStageResult
        val stageResult = winner.stageResult!!
        assertEquals("4d9d1697-190d-46f8-b6e3-6bfe3f4a2134", stageResult.id)
        assertEquals("e4ddfa9d-3347-47e4-9d32-c6c119aeac0e", stageResult.resultType)
        assertEquals(getInstant("2026-06-28T08:45:00.000+00:00"), stageResult.startTime)
        assertEquals(getInstant("2026-06-28T09:11:33.000+00:00"), stageResult.finishTime)
        assertEquals("res_splits", stageResult.uploadType)
        assertEquals(1593.seconds, stageResult.timeSeconds)
        assertEquals(1, stageResult.position)
        assertEquals("0", stageResult.statusCode)
        assertFalse(stageResult.isNC)
        assertEquals(true, stageResult.contributory)
        assertEquals(0.seconds, stageResult.timeBehind)
        assertEquals(0.seconds, stageResult.timeNeutralization)
        assertEquals(0.seconds, stageResult.timeAdjusted)
        assertEquals(0.seconds, stageResult.timePenalty)
        assertEquals(0.seconds, stageResult.timeBonus)
        assertEquals("0.0000", stageResult.pointsTotal)
        assertEquals("0.0000", stageResult.pointsBehind)
        assertEquals("0.0000", stageResult.pointsAdjusted)
        assertEquals("0.0000", stageResult.pointsPenalty)
        assertEquals("0.0000", stageResult.pointsBonus)
        assertNull(stageResult.note)
        assertEquals(1, stageResult.legNumber)
        assertEquals(getInstant("2026-06-30T08:53:09.545+00:00"), stageResult.created)

        // Test GetSplits and GetSplit
        val splits = stageResult.splits
        assertEquals(23, splits.size)       // Tests that the finish control is added

        val stations = listOf("51", "52", "64", "82", "81", "77", "44", "59", "43", "47", "71", "36", "37", "38", "41", "49", "53", "50", "65", "57", "75", "100", "Finish")
        val splitTime = listOf("31s", "1m 16s", "44s", "1m 04s", "40s", "1m 04s","1m 02s", "54s", "36s", "1m 25s", "1m 11s", "17s", "3m 40s", "1m 55s", "1m 53s", "1m 42s", "2m 40s", "1m 35s", "36s", "42s", "41s", "19s", "6s")
        val splitTimeDifference = listOf("0s", "8s", "7s", "13s", "3s", "5s","0s", "0s", "0s", "49s", "0s", "0s", "2m 10s", "35s", "0s", "0s", "15s", "38s", "0s", "21s", "0s", "0s", "0s")
        val splitPosition = listOf<Long>(1, 2, 5, 4, 2, 3, 1, 1, 1, 6, 1, 1, 6, 5, 1, 1, 2, 6, 1, 5, 1, 1, 1)
        val accumulatedTime = listOf("31s", "1m 47s", "2m 31s", "3m 35s", "4m 15s", "5m 19s","6m 21s", "7m 15s", "7m 51s", "9m 16s", "10m 27s", "10m 44s", "14m 24s", "16m 19s", "18m 12s", "19m 54s", "22m 34s", "24m 09s", "24m 45s", "25m 27s", "26m 08s", "26m 27s", "26m 33s")
        val accumulatedTimeDifference = listOf("0s", "4s", "8s", "0s", "0s", "0s","0s", "0s", "0s", "0s", "0s", "0s", "0s", "0s", "0s", "0s", "0s", "0s", "0s", "0s", "0s", "0s", "0s")
        val accumulatedPosition = listOf<Long>(1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)

        for(index in splits.indices){
            assertEquals(index + 1L, splits[index].orderNumber)
            assertEquals(stations[index], splits[index].control.station)
            assertEquals(Duration.parse(splitTime[index]), splits[index].partial)
            assertEquals(Duration.parse(splitTimeDifference[index]), splits[index].partialDifference)
            assertEquals(splitPosition[index], splits[index].partialPosition)
            assertEquals(Duration.parse(accumulatedTime[index]), splits[index].accumulated)
            assertEquals(Duration.parse(accumulatedTimeDifference[index]), splits[index].accumulatedDifference)
            assertEquals(accumulatedPosition[index], splits[index].accumulatedPosition)
        }
    }

    @Test
    fun `GetClassicResults - MP Result with Splits and CalculateRanks`(){
        val response: List<ResultIndividual> = getClassicResults(RemoteResponse.complete)

        // Check the integrity of the list
        assertTrue(response.isNotEmpty())
        assertEquals(6, response.size)

        // Sort the list by position (0-6), the first one is the MP
        response.forEach {
            assertNotNull(it.stageResult)
        }
        val sortedList = response.sortedBy { it.stageResult!!.position }    // The stageResults have been asserted not null

        // Runner with MP
        val mp = sortedList[0]

        // Test GetStageResult
        val stageResult = mp.stageResult!!
        assertEquals("4d7e15c0-af6f-4f08-9da2-841beaf2e7be", stageResult.id)
        assertEquals("e4ddfa9d-3347-47e4-9d32-c6c119aeac0e", stageResult.resultType)
        assertEquals(getInstant("2026-06-28T09:20:00.000+00:00"), stageResult.startTime)
        assertEquals(getInstant("2026-06-28T09:57:55.000+00:00"), stageResult.finishTime)
        assertEquals("res_splits", stageResult.uploadType)
        assertEquals(2275.seconds, stageResult.timeSeconds)
        assertEquals(0, stageResult.position)
        assertEquals("3", stageResult.statusCode)
        assertFalse(stageResult.isNC)
        assertEquals(true, stageResult.contributory)
        assertEquals(682.seconds, stageResult.timeBehind)
        assertEquals(0.seconds, stageResult.timeNeutralization)
        assertEquals(0.seconds, stageResult.timeAdjusted)
        assertEquals(0.seconds, stageResult.timePenalty)
        assertEquals(0.seconds, stageResult.timeBonus)
        assertEquals("0.0000", stageResult.pointsTotal)
        assertEquals("0.0000", stageResult.pointsBehind)
        assertEquals("0.0000", stageResult.pointsAdjusted)
        assertEquals("0.0000", stageResult.pointsPenalty)
        assertEquals("0.0000", stageResult.pointsBonus)
        assertNull(stageResult.note)
        assertEquals(1, stageResult.legNumber)
        assertEquals(getInstant("2026-06-30T08:53:10.956+00:00"), stageResult.created)

        // Test GetSplits and GetSplit
        val splits = stageResult.splits
        assertEquals(23, splits.size)       // Tests that the finish control is added

        val stations = listOf("51", "52", "64", "82", "81", "77", "44", "59", "43", "47", "71", "36", "37", "38", "41", "49", "53", "50", "65", "57", "75", "100", "Finish")
        val splitTime = listOf("47s", "3m 59s", "42s", "1m 14s", "1m 54s", "2m 32s", null, null, "1m 10s", "40s", "1m 49s", "20s", "1m 30s", "1m 20s", "4m 50s", "2m 56s", "2m 56s", "1m", "50s", "2m 29s", "46s", "1m 57s", "8s")
        val splitTimeDifference = listOf("16s", "2m 51s", "5s", "23s", "1m 17s", "1m 33s", null, null, "34s", "4s", "38s", "3s", "0s", "0s", "2m 57s", "1m 14s", "31s", "3s", "14s", "2m 8s", "5s", "1m 38s", "2s")
        val splitPosition = listOf<Long?>(4, 6, 4, 5, 5, 5, null, null, 6, 3, 4, 2, 1, 1, 5, 5, 3, 2, 3, 6, 3, 6, 2)
        val accumulatedTime = listOf("47s", "4m 46s", "5m 28s", "6m 42s", "8m 36s", "11m 8s", null, "13m 14s", "14m 24s", "15m 4s", "16m 53s", "17m 13s", "18m 43s", "20m 3s", "24m 53s", "27m 49s", "30m 45s", "31m 45s", "32m 35s", "35m 4s", "35m 50s", "37m 47s", "37m 55s")
        val accumulatedTimeDifference = listOf("16s", "3m 3s", "3m 5s", "3m 7s", "4m 21s", "5m 49s")
        val accumulatedPosition = listOf<Long>(4, 6, 6, 6, 5, 4)

        for(index in splits.indices){
            assertEquals(index + 1L, splits[index].orderNumber)
            assertEquals(stations[index], splits[index].control.station)
            assertEquals(
                if(splitTime[index] != null) Duration.parse(splitTime[index]!!) else null
                , splits[index].partial)
            assertEquals(
                if(splitTimeDifference[index] != null) Duration.parse(splitTimeDifference[index]!!) else null,
                splits[index].partialDifference)
            assertEquals(splitPosition[index], splits[index].partialPosition)
            assertEquals(
                if(accumulatedTime[index] != null) Duration.parse(accumulatedTime[index]!!) else null,
                splits[index].accumulated)
            if(index < accumulatedPosition.size){
                assertEquals(Duration.parse(accumulatedTimeDifference[index]), splits[index].accumulatedDifference)
                assertEquals(accumulatedPosition[index], splits[index].accumulatedPosition)
            }
            else {
                assertNull(splits[index].accumulatedDifference)
                assertNull(splits[index].accumulatedPosition)
                assertTrue(splits[index].accumulatedError)
            }

        }
    }

    @Test
    fun `GetClassicResults - EmptyList`(){
        val remoteResultsResponse = RemoteResultsResponse(
            results = emptyList(),
        )
        val response: List<ResultIndividual> = getClassicResults(remoteResultsResponse)

        // Check the integrity of the list
        assertNotNull(response)
        assertTrue(response.isEmpty())
    }

    @Test
    fun `GetClassicResults - Valid List without CalculateRanks`(){
        val response: List<ResultIndividual> = getClassicResults(RemoteResponse.complete, calculateRanks = false)

        // Check the integrity of the list
        assertTrue(response.isNotEmpty())
        assertEquals(6, response.size)

        // Sort the list by position (0-6), the first one is the MP
        response.forEach {
            assertNotNull(it.stageResult)
        }
        val sortedList = response.sortedBy { it.stageResult!!.position }    // The stageResults have been asserted not null

        // Test that, for all runners, the ranked items are null
        for(runner in sortedList){
            assertNotNull(runner.stageResult)
            for(split in runner.stageResult.splits){
                assertNull(split.partialDifference)
                assertNull(split.partialPosition)
                assertNull(split.accumulatedDifference)
                assertNull(split.accumulatedPosition)
            }
        }
    }

    @Test
    fun `GetClassicResults - Invalid Result without siCard`(){
        val remote = RemoteResultsResponse(
            results = listOf(
                RemoteResult(
                    id = "02c0298a-d3e5-470e-8ae2-77a40063b407",
                    bibNumber = "4346",
                    isNc = false,
                    eligibility = null,
                    sicard = null,
                    sex = "F",
                    legNumber = 1,
                    legs = null,
                    runners = null,
                    created = "2026-06-30T08:53:10.392+00:00",
                    runnerClass = null,
                    runnerClub = null,
                    fullName = "Julia Pérez Álvarez",
                    stageResult = null,
                    overalls = null,
                )
            )
        )

        assertFailsWith<IllegalArgumentException> {
            getClassicResults(remote, calculateRanks = false)
        }
    }

    @Test
    fun `GetClassicResults - Invalid Result without sex`(){
        val remote = RemoteResultsResponse(
            results = listOf(
                RemoteResult(
                    id = "02c0298a-d3e5-470e-8ae2-77a40063b407",
                    bibNumber = "4346",
                    isNc = false,
                    eligibility = null,
                    sicard = "2077088",
                    sex = null,
                    legNumber = 1,
                    legs = null,
                    runners = null,
                    created = "2026-06-30T08:53:10.392+00:00",
                    runnerClass = null,
                    runnerClub = null,
                    fullName = "Julia Pérez Álvarez",
                    stageResult = null,
                    overalls = null,
                )
            )
        )

        assertFailsWith<IllegalArgumentException> {
            getClassicResults(remote, calculateRanks = false)
        }
    }

    @Test
    fun `GetClassicResults - Invalid Result without legNumber`(){
        val remote = RemoteResultsResponse(
            results = listOf(
                RemoteResult(
                    id = "02c0298a-d3e5-470e-8ae2-77a40063b407",
                    bibNumber = "4346",
                    isNc = false,
                    eligibility = null,
                    sicard = "2077088",
                    sex = "F",
                    legNumber = null,
                    legs = null,
                    runners = null,
                    created = "2026-06-30T08:53:10.392+00:00",
                    runnerClass = null,
                    runnerClub = null,
                    fullName = "Julia Pérez Álvarez",
                    stageResult = null,
                    overalls = null,
                )
            )
        )

        assertFailsWith<IllegalArgumentException> {
            getClassicResults(remote, calculateRanks = false)
        }
    }

    @Test
    fun `GetClassicResults - Valid Result without Class, Club, StageResult or Overalls`(){
        val result = getClassicResults(RemoteResponse.allNulls, calculateRanks = false)

        assertNotNull(result)
        assertEquals(1, result.size)
    }

    @Test
    fun `GetClassicResults - Valid Result with Splits without ReadingTime`(){
        val result = getClassicResults(RemoteResponse.noReadingTime, calculateRanks = false)

        assertNotNull(result)
        assertEquals(1, result.size)

        // Test that, for all runners, all time items BUT THE LAST ONE are null
        for(runner in result){
            assertNotNull(runner.stageResult)
            val split = runner.stageResult.splits
            for(i in 0..<runner.stageResult.splits.size - 1){
                assertNull(split[i].partial)
                assertNull(split[i].partialDifference)
                assertNull(split[i].partialPosition)
                assertNull(split[i].accumulated)
                assertNull(split[i].accumulatedDifference)
                assertNull(split[i].accumulatedPosition)
            }

            assertNotNull(split[split.size - 1].accumulated)
        }
    }

    @Test
    fun `GetClassicResults - Valid Result with Splits without Splits`(){
        val result = getClassicResults(RemoteResponse.noSplits, calculateRanks = false)

        assertNotNull(result)
        assertEquals(1, result.size)

        // Test that, for all runners, the only split is the Finish control
        for(runner in result){
            assertNotNull(runner.stageResult)
            assertEquals(1, runner.stageResult.splits.size)
        }
    }

    @Test
    fun `GetClassicResults - Valid Result with Extra Splits Visited`(){
        val result = getClassicResults(RemoteResponse.extraSplit, calculateRanks = false)

        assertNotNull(result)
        assertEquals(1, result.size)

        // Test that, for all runners, the extra split has a correct accumulated time
        for(runner in result){
            assertNotNull(runner.stageResult)
            val splits = runner.stageResult.splits

            assertEquals(1.minutes, splits[1].partial)
            assertEquals(1.minutes, splits[1].accumulated)
            assertNull(splits[0].partial)
            assertEquals(3.minutes, splits[0].accumulated)
        }
    }

}