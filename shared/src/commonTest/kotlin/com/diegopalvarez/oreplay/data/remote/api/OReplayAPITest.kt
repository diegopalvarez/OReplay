package com.diegopalvarez.oreplay.data.remote.api

import assertk.assertThat
import assertk.assertions.hasSize
import assertk.assertions.isEmpty
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isNotEmpty
import assertk.assertions.isNotNull
import assertk.assertions.isNull
import assertk.assertions.isTrue
import com.diegopalvarez.oreplay.core.network.createHttpClient
import com.diegopalvarez.oreplay.core.util.NetworkError
import com.diegopalvarez.oreplay.core.util.Result
import com.diegopalvarez.oreplay.core.util.onSuccess
import com.diegopalvarez.oreplay.data.remote.api.util.ClassesResponses
import com.diegopalvarez.oreplay.data.remote.api.util.ClubsResponses
import com.diegopalvarez.oreplay.data.remote.api.util.EventsResponses
import com.diegopalvarez.oreplay.data.remote.api.util.HttpResponseData
import com.diegopalvarez.oreplay.data.remote.api.util.ResultsResponses
import com.diegopalvarez.oreplay.data.remote.api.util.StagesResponses
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.request.HttpRequestData
import io.ktor.http.HttpStatusCode
import io.ktor.http.headers
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class OReplayAPITest {
    private lateinit var api: OReplayAPI
    private lateinit var httpClient: HttpClient

    // Structure holding the data to be responded by the mocked API
    private var responseData = HttpResponseData(
        content = "",
        statusCode = HttpStatusCode.OK,
    )

    private lateinit var request: HttpRequestData

    @BeforeTest
    fun setUp() {
        httpClient = createHttpClient(
            engine = MockEngine.create {
                addHandler { req ->
                    request = req
                    val relativeURL = req.url.encodedPath
                    if(relativeURL.startsWith("/api/v1/events")) {
                        respond(
                            content = responseData.content,
                            status = responseData.statusCode,
                            headers = headers {
                                set("Content-Type", "application/json")
                            }
                        )
                    }
                    else {
                        respond(
                            content = "Not mocked",
                            status = HttpStatusCode.NotFound
                        )
                    }
                }
            },
        )
        api = OReplayAPI(httpClient)
    }

    /**
     * Tests for function getEvents
     */

    @Test
    fun `Unit Test - Single Valid Results`() = runTest {
        responseData = HttpResponseData(
            content = EventsResponses.valid,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getEvents()
        assertTrue(result is Result.Success)

        // Check that no parameters are applied to the request
        assertThat(request.url.parameters["when"]).isNull()
        assertThat(request.url.parameters["page"]).isNull()

        result.onSuccess { result ->
            assertThat(result.total).isEqualTo(1)
            assertThat(result.data.size).isEqualTo(1)

            // Content test
            val event = result.data.first()
            assertThat(event.id).isEqualTo("4ebb0458-1268-42f7-b608-c1c385ae575c")
            assertThat(event.isHidden).isFalse()
            assertThat(event.description).isEqualTo("6ª LIGA SPRINT FEMADO")
            assertThat(event.picture).isNull()
            assertThat(event.website).isEqualTo("https://femado.org/")
            assertThat(event.scope).isEqualTo("r.h")
            assertThat(event.location).isNull()
            assertThat(event.countryCode).isEqualTo("ES")
            assertThat(event.initialDate).isEqualTo("2026-06-14")
            assertThat(event.finalDate).isEqualTo("2026-06-14")
            assertThat(event.timezone).isEqualTo("Europe/Madrid")
            assertThat(event.federationID).isNull()
            assertThat(event.created).isEqualTo("2026-06-11T10:24:32.150+00:00")
            assertThat(event.modified).isEqualTo("2026-06-11T10:38:50.750+00:00")
            assertThat(event.organizerID).isEqualTo("d5db45c7-dfb6-41ce-9818-086067dfb33b")
            assertThat(event.organizer.name).isEqualTo("FEMADO")
            assertThat(event.organizer.region).isEqualTo("Comunidad de Madrid")
            assertThat(event.organizer.country).isEqualTo("Spain")
            assertThat(event.links.self.href).isEqualTo("https://www.oreplay.es/api/v1/events/4ebb0458-1268-42f7-b608-c1c385ae575c")

        }
    }

    @Test
    fun `Unit Test - List of Valid Results`() = runTest {
        responseData = HttpResponseData(
            content = EventsResponses.valid_list,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getEvents()
        assertTrue(result is Result.Success)

        // Check that no parameters are applied to the request
        assertThat(request.url.parameters["when"]).isNull()
        assertThat(request.url.parameters["page"]).isNull()

        result.onSuccess { result ->
            assertThat(result.total).isEqualTo(251)
            assertThat(result.data.size).isEqualTo(10)

            for ( i in result.data.indices) {
                assertThat(result.data[i]).isNotNull()
                assertThat(result.data[i].id).isNotEmpty()
            }
        }
    }

    @Test
    fun `Unit Test - Empty Valid Result`() = runTest {
        responseData = HttpResponseData(
            content = EventsResponses.empty,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getEvents()
        assertTrue(result is Result.Success)

        // Check that no parameters are applied to the request
        assertThat(request.url.parameters["when"]).isNull()
        assertThat(request.url.parameters["page"]).isNull()

        result.onSuccess { result ->
            assertThat(result.total).isEqualTo(251)
            assertThat(result.data).isEmpty()
            assertThat(result.links.next).isNull()
        }
    }

    @Test
    fun `Unit Test - Filter by when`() = runTest {
        responseData = HttpResponseData(
            content = EventsResponses.empty,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getEvents(
            moment = "today"
        )

        // Check that the parameters are applied to the request
        assertThat(request.url.parameters["when"]).isEqualTo("today")
        assertThat(request.url.parameters["page"]).isNull()
    }

    @Test
    fun `Unit Test - Filter by page`() = runTest {
        responseData = HttpResponseData(
            content = EventsResponses.empty,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getEvents(
            page = 3
        )

        // Check that the parameters are applied to the request
        assertThat(request.url.parameters["when"]).isNull()
        assertThat(request.url.parameters["page"]).isEqualTo("3")
    }

    /**
     * Tests for makeRequest function
     */

    @Test
    fun `Unit Test - Serialization Exception`() = runTest {
        responseData = HttpResponseData(
            content = EventsResponses.incompleteResponse,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getEvents()
        assertTrue(result is Result.Error)
        assertEquals(result.error, NetworkError.SERIALIZATION)
    }

    @Test
    fun `Unit Test - Empty Response`() = runTest {
        responseData = HttpResponseData(
            content = EventsResponses.noResponse,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getEvents()
        assertTrue(result is Result.Error)
        assertEquals(result.error, NetworkError.SERIALIZATION)
    }

    @Test
    fun `Unit Test - Error Codes`() = runTest {
        val cases = listOf(
            HttpStatusCode.BadRequest to NetworkError.BAD_REQUEST,
            HttpStatusCode.Unauthorized to NetworkError.UNAUTHORIZED,
            HttpStatusCode.Forbidden to NetworkError.FORBIDDEN,
            HttpStatusCode.NotFound to NetworkError.NOT_FOUND,
            HttpStatusCode.MethodNotAllowed to NetworkError.METHOD_NOT_ALLOWED,
            HttpStatusCode.Conflict to NetworkError.CONFLICT,
            HttpStatusCode.InternalServerError to NetworkError.SERVER_ERROR,
            HttpStatusCode.PayloadTooLarge to NetworkError.UNKNOWN
        )

        for ((statusCode, expectedError) in cases) {
            responseData = HttpResponseData(
                content = EventsResponses.noResponse,
                statusCode = statusCode,
            )

            val result = api.getEvents()
            assertTrue(result is Result.Error)
            assertEquals(result.error, expectedError)
        }
    }

    /**
     * Tests for getEventsFiltered
     * The Serialization is already tested in getEvents, so it's only necessary to test the filters
     */

    @Test
    fun `Unit Test - getEventsFiltered with no filters`() = runTest {
        responseData = HttpResponseData(
            content = EventsResponses.empty,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getEventsFiltered()

        // Check that no parameters are applied to the request
        assertThat(request.url.parameters["description"]).isNull()
        assertThat(request.url.parameters["initial_date"]).isNull()
        assertThat(request.url.parameters["final_date"]).isNull()
    }

    @Test
    fun `Unit Test - Filter by description`() = runTest {
        responseData = HttpResponseData(
            content = EventsResponses.empty,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getEventsFiltered(
            description = "descriptive name"
        )

        // Check that the parameters are applied to the request
        assertThat(request.url.parameters["description"]).isEqualTo("descriptive name")
        assertThat(request.url.parameters["initial_date"]).isNull()
        assertThat(request.url.parameters["final_date"]).isNull()
    }

    @Test
    fun `Unit Test - Filter by initialDate`() = runTest {
        responseData = HttpResponseData(
            content = EventsResponses.empty,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getEventsFiltered(
            initialDate = LocalDate(2025, 3, 11)
        )

        // Check that the parameters are applied to the request
        assertThat(request.url.parameters["description"]).isNull()
        assertThat(request.url.parameters["initial_date"]).isEqualTo("2025-03-11")
        assertThat(request.url.parameters["final_date"]).isNull()
    }

    @Test
    fun `Unit Test - Filter by finalDate`() = runTest {
        responseData = HttpResponseData(
            content = EventsResponses.empty,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getEventsFiltered(
            finalDate = LocalDate(2025, 3, 11)
        )

        // Check that the parameters are applied to the request
        assertThat(request.url.parameters["description"]).isNull()
        assertThat(request.url.parameters["initial_date"]).isNull()
        assertThat(request.url.parameters["final_date"]).isEqualTo("2025-03-11")

    }

    @Test
    fun `Unit Test - Single Valid Stage`() = runTest {
        responseData = HttpResponseData(
            content = StagesResponses.valid,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getEventStages(
            eventID = "70366547-ee34-4b76-9a64-ff66ca9cd977"
        )

        assertTrue(result is Result.Success)

        result.onSuccess { result ->
            assertThat(result).isNotNull()
            assertThat(result.details).isNotNull()

            // Content test
            val event = result.details
            assertThat(event.id).isEqualTo("70366547-ee34-4b76-9a64-ff66ca9cd977")
            assertThat(event.isHidden).isFalse()
            assertThat(event.description).isEqualTo("Trofeo Concello de O Grove")
            assertThat(event.picture).isNull()
            assertThat(event.website).isEqualTo("https://fegado.es/events/view/i140g1ltxp6n/")
            assertThat(event.scope).isEqualTo("r.h")
            assertThat(event.location).isNull()
            assertThat(event.countryCode).isEqualTo("ES")
            assertThat(event.initialDate).isEqualTo("2026-06-27")
            assertThat(event.finalDate).isEqualTo("2026-06-28")
            assertThat(event.timezone).isEqualTo("Europe/Madrid")
            assertThat(event.federationID).isNull()
            assertThat(event.created).isEqualTo("2026-06-26T19:52:23.118+00:00")
            assertThat(event.modified).isEqualTo("2026-06-26T19:58:29.735+00:00")
            assertThat(event.organizerID).isEqualTo("72943f5d-2232-4dc2-852d-84a856c1f6b2")
            assertThat(event.organizer.name).isEqualTo("AROMON")
            assertThat(event.organizer.region).isEqualTo("Galicia")
            assertThat(event.organizer.country).isEqualTo("Spain")
            assertThat(event.links.self.href).isEqualTo("https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977")

            // Stages test
            assertThat(event.stages).hasSize(1)
            val stage = event.stages.first()
            assertThat(stage).isNotNull()
            assertThat(stage.id).isEqualTo("86e6b0da-dc15-4211-9825-a72e190138f3")
            assertThat(stage.description).isEqualTo("Media")
            assertThat(stage.start).isEqualTo("2026-06-26T22:00:00.000+00:00")
            assertThat(stage.stageType.id).isEqualTo("29d5050b-4769-4be5-ace4-7e5973f68e3c")
            assertThat(stage.stageType.description).isEqualTo("Classic")
            assertThat(stage.lastLogs).hasSize(2)
            assertThat(stage.lastLogs[0].state).isEqualTo(2)
            assertThat(stage.lastLogs[0].created).isEqualTo("2026-06-30T08:56:52.000+00:00")
            assertThat(stage.lastLogs[1].state).isEqualTo(0)
            assertThat(stage.lastLogs[1].created).isEqualTo("2026-06-30T08:52:47.000+00:00")
            assertThat(stage.links.self.href).isEqualTo("https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977/stages/86e6b0da-dc15-4211-9825-a72e190138f3")
            assertThat(stage.links.classes.href).isEqualTo("https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977/stages/86e6b0da-dc15-4211-9825-a72e190138f3/classes/")
            assertThat(stage.links.results.href).isEqualTo("https://www.oreplay.es/api/v1/events/70366547-ee34-4b76-9a64-ff66ca9cd977/stages/86e6b0da-dc15-4211-9825-a72e190138f3/results/")

        }
    }

    @Test
    fun `Unit Test - List of Valid Stages`() = runTest {
        responseData = HttpResponseData(
            content = StagesResponses.valid_list,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getEventStages(
            eventID = "152aac91-e74c-43e1-a66d-96ce7734e2b7"
        )

        assertTrue(result is Result.Success)
        result.onSuccess { result ->
            val event = result.details
            assertThat(event.id).isEqualTo("152aac91-e74c-43e1-a66d-96ce7734e2b7")
            assertThat(event.stages).hasSize(7)

            for ( i in event.stages.indices) {
                assertThat(event.stages[i]).isNotNull()
                assertThat(event.stages[i].id).isNotEmpty()
            }
        }
    }

    @Test
    fun `Unit Test - List with No Stages`() = runTest {
        responseData = HttpResponseData(
            content = StagesResponses.empty,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getEventStages(
            eventID = "70366547-ee34-4b76-9a64-ff66ca9cd977"
        )

        assertTrue(result is Result.Success)
        result.onSuccess { result ->
            val event = result.details
            assertThat(event.id).isEqualTo("70366547-ee34-4b76-9a64-ff66ca9cd977")
            assertThat(event.stages).isNotNull()
            assertThat(event.stages).isEmpty()
        }
    }

    @Test
    fun `Unit Test - Stages No Response`() = runTest {
        responseData = HttpResponseData(
            content = StagesResponses.noResponse,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getEventStages(
            eventID = "70366547-ee34-4b76-9a64-ff66ca9cd977"
        )

        assertTrue(result is Result.Error)
        assertThat(result.error).isEqualTo(NetworkError.SERIALIZATION)
    }

    @Test
    fun `Unit Test - Stages Incomplete Response`() = runTest {
        responseData = HttpResponseData(
            content = StagesResponses.incompleteResponse,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getEventStages(
            eventID = "70366547-ee34-4b76-9a64-ff66ca9cd977"
        )

        assertTrue(result is Result.Error)
        assertThat(result.error).isEqualTo(NetworkError.SERIALIZATION)
    }

    /**
     * Tests for getStageClasses function
     */
    @Test
    fun `Unit Test - Single Valid Class`() = runTest {
        responseData = HttpResponseData(
            content = ClassesResponses.valid,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getStageClasses(
            eventID = "70366547-ee34-4b76-9a64-ff66ca9cd977",
            stageID = "86e6b0da-dc15-4211-9825-a72e190138f3"
        )

        assertTrue(result is Result.Success)

        result.onSuccess { result ->
            assertThat(result).isNotNull()
            assertThat(result.classes).isNotNull()
            assertThat(result.classes).hasSize(1)

            // Content test
            val classExample = result.classes.first()
            assertThat(classExample.id).isEqualTo("45fb60e7-958c-4e12-8a03-6614530211e7")
            assertThat(classExample.shortName).isEqualTo("F-12")
            assertThat(classExample.longName).isEqualTo("Feminino 12")
            //assertThat(classExample.radios).isNotNull()
            //assertThat(classExample.radios).isEmpty()
        }
    }

    @Test
    fun `Unit Test - List of Valid Classes`() = runTest {
        responseData = HttpResponseData(
            content = ClassesResponses.valid_list,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getStageClasses(
            eventID = "70366547-ee34-4b76-9a64-ff66ca9cd977",
            stageID = "86e6b0da-dc15-4211-9825-a72e190138f3"
        )

        assertTrue(result is Result.Success)
        result.onSuccess { result ->
            val classes = result.classes
            assertThat(classes).isNotNull()
            assertThat(classes).hasSize(26)

            for ( i in classes.indices) {
                assertThat(classes[i]).isNotNull()
                assertThat(classes[i].id).isNotEmpty()
            }
        }
    }

    @Test
    fun `Unit Test - List of No Classes`() = runTest {
        responseData = HttpResponseData(
            content = ClassesResponses.empty,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getStageClasses(
            eventID = "70366547-ee34-4b76-9a64-ff66ca9cd977",
            stageID = "86e6b0da-dc15-4211-9825-a72e190138f3"
        )

        assertTrue(result is Result.Success)
        result.onSuccess { result ->
            val classes = result.classes
            assertThat(classes).isNotNull()
            assertThat(classes).isEmpty()
        }
    }

    @Test
    fun `Unit Test - Classes Empty Response`() = runTest {
        responseData = HttpResponseData(
            content = ClassesResponses.noResponse,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getStageClasses(
            eventID = "70366547-ee34-4b76-9a64-ff66ca9cd977",
            stageID = "86e6b0da-dc15-4211-9825-a72e190138f3"
        )

        assertTrue(result is Result.Error)
        assertThat(result.error).isEqualTo(NetworkError.SERIALIZATION)
    }

    @Test
    fun `Unit Test - Classes Incomplete Response`() = runTest {
        responseData = HttpResponseData(
            content = ClassesResponses.incompleteResponse,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getStageClasses(
            eventID = "70366547-ee34-4b76-9a64-ff66ca9cd977",
            stageID = "86e6b0da-dc15-4211-9825-a72e190138f3"
        )

        assertTrue(result is Result.Error)
        assertThat(result.error).isEqualTo(NetworkError.SERIALIZATION)
    }

    /**
     * Tests for getStageClubs function
     */

    @Test
    fun `Unit Test - Single Valid Club`() = runTest {
        responseData = HttpResponseData(
            content = ClubsResponses.valid,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getStageClubs(
            eventID = "70366547-ee34-4b76-9a64-ff66ca9cd977",
            stageID = "86e6b0da-dc15-4211-9825-a72e190138f3"
        )

        assertTrue(result is Result.Success)

        result.onSuccess { result ->
            assertThat(result).isNotNull()
            assertThat(result.clubs).isNotNull()
            assertThat(result.clubs).hasSize(1)

            // Content test
            val club = result.clubs.first()
            assertThat(club.id).isEqualTo("0029c770-6bc5-4623-b8f1-ad806d9ca343")
            assertThat(club.shortName).isEqualTo("A Coruña ARTABROS")
        }
    }

    @Test
    fun `Unit Test - List of Valid Clubs`() = runTest {
        responseData = HttpResponseData(
            content = ClubsResponses.valid_list,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getStageClubs(
            eventID = "70366547-ee34-4b76-9a64-ff66ca9cd977",
            stageID = "86e6b0da-dc15-4211-9825-a72e190138f3"
        )

        assertTrue(result is Result.Success)
        result.onSuccess { result ->
            val clubs = result.clubs
            assertThat(clubs).isNotNull()
            assertThat(clubs).hasSize(24)

            for ( i in clubs.indices) {
                assertThat(clubs[i]).isNotNull()
                assertThat(clubs[i].id).isNotEmpty()
            }
        }
    }

    @Test
    fun `Unit Test - List of No Clubs`() = runTest {
        responseData = HttpResponseData(
            content = ClubsResponses.empty,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getStageClubs(
            eventID = "70366547-ee34-4b76-9a64-ff66ca9cd977",
            stageID = "86e6b0da-dc15-4211-9825-a72e190138f3"
        )

        assertTrue(result is Result.Success)
        result.onSuccess { result ->
            val clubs = result.clubs
            assertThat(clubs).isNotNull()
            assertThat(clubs).isEmpty()
        }
    }

    @Test
    fun `Unit Test - Clubs Empty Response`() = runTest {
        responseData = HttpResponseData(
            content = ClubsResponses.noResponse,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getStageClubs(
            eventID = "70366547-ee34-4b76-9a64-ff66ca9cd977",
            stageID = "86e6b0da-dc15-4211-9825-a72e190138f3"
        )

        assertTrue(result is Result.Error)
        assertThat(result.error).isEqualTo(NetworkError.SERIALIZATION)
    }

    @Test
    fun `Unit Test - Clubs Incomplete Response`() = runTest {
        responseData = HttpResponseData(
            content = ClubsResponses.incompleteResponse,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getStageClubs(
            eventID = "70366547-ee34-4b76-9a64-ff66ca9cd977",
            stageID = "86e6b0da-dc15-4211-9825-a72e190138f3"
        )

        assertTrue(result is Result.Error)
        assertThat(result.error).isEqualTo(NetworkError.SERIALIZATION)
    }

    /**
     * Tests for getStageResults function
     */
    @Test
    fun `Unit Test - Single Valid Result with Splits`() = runTest {
        responseData = HttpResponseData(
            content = ResultsResponses.valid_splits,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getStageResults(
            eventID = "70366547-ee34-4b76-9a64-ff66ca9cd977",
            stageID = "86e6b0da-dc15-4211-9825-a72e190138f3"
        )

        assertTrue(result is Result.Success)

        result.onSuccess { result ->
            assertThat(result).isNotNull()
            assertThat(result.results).isNotNull()

            // Content test
            val res = result.results.first()
            assertThat(res.id).isEqualTo("00924a47-1a21-4c9d-b3e2-ae78bf20009a")
            assertThat(res.bibNumber).isEqualTo("4354")
            assertThat(res.isNc).isFalse()
            assertThat(res.eligibility).isNull()
            assertThat(res.sicard).isEqualTo("8027206")
            assertThat(res.sex).isEqualTo("F")
            assertThat(res.legNumber).isEqualTo(1)
            assertThat(res.created).isEqualTo("2026-06-30T08:55:55.493+00:00")
            assertThat(res.runnerClass).isNotNull()
            assertThat(res.runnerClass!!.id).isEqualTo("1cc8fe3e-753d-456d-9d6b-9876502801ad")
            assertThat(res.runnerClass.shortName).isEqualTo("F-14")
            assertThat(res.runnerClass.longName).isEqualTo("Feminino 14")
            assertThat(res.runnerClub).isNotNull()
            assertThat(res.runnerClub!!.id).isEqualTo("034a5575-ccd9-41d8-bffc-0f2bca8cd039")
            assertThat(res.runnerClub.shortName).isEqualTo("Culleredo GALLAECIA_RAID")
            assertThat(res.fullName).isEqualTo("Noa Albarran Oroza")
            assertThat(res.stageResult).isNotNull()

            // Stages test
            val stage = res.stageResult!!
            assertThat(stage.id).isEqualTo("9a343741-7709-4833-897d-d5cea274e943")
            assertThat(stage.resultTypeID).isEqualTo("e4ddfa9d-3347-47e4-9d32-c6c119aeac0e")
            assertThat(stage.startTime).isEqualTo("2026-06-27T09:09:00.000+00:00")
            assertThat(stage.finishTime).isEqualTo("2026-06-27T09:45:45.000+00:00")
            assertThat(stage.uploadType).isEqualTo("res_splits")
            assertThat(stage.timeSeconds).isEqualTo(2205)
            assertThat(stage.position).isEqualTo(2)
            assertThat(stage.statusCode).isEqualTo("0")
            assertThat(stage.isNc).isFalse()
            assertThat(stage.contributory).isNotNull()
            assertThat(stage.contributory!!).isTrue()
            assertThat(stage.timeBehind).isEqualTo(130)
            assertThat(stage.timeNeutralization).isEqualTo(0)
            assertThat(stage.timeAdjusted).isEqualTo(0)
            assertThat(stage.timePenalty).isEqualTo(0)
            assertThat(stage.timeBonus).isEqualTo(0)
            assertThat(stage.pointsFinal).isEqualTo("0.0000")
            assertThat(stage.pointsBehind).isEqualTo("0.0000")
            assertThat(stage.pointsAdjusted).isEqualTo("0.0000")
            assertThat(stage.pointsPenalty).isEqualTo("0.0000")
            assertThat(stage.pointsBonus).isEqualTo("0.0000")
            assertThat(stage.note).isNull()
            assertThat(stage.legNumber).isEqualTo(1)
            assertThat(stage.created).isEqualTo("2026-06-30T08:55:55.504+00:00")

            // Splits test
            assertThat(stage.splits).isNotNull()
            assertThat(stage.splits).hasSize(1)

            val split = stage.splits.first()
            assertThat(split.id).isEqualTo("97051a45-3c81-4d1a-93b3-9c76eb41208c")
            assertThat(split.isIntermediate).isFalse()
            assertThat(split.readingTime).isEqualTo("2026-06-27T09:45:25.000+00:00")
            assertThat(split.points).isEqualTo(0)
            assertThat(split.orderNumber).isEqualTo(16)
            assertThat(split.created).isEqualTo("2026-06-30T08:55:55.688+00:00")
            assertThat(split.control).isNotNull()
            assertThat(split.control.id).isEqualTo("f24410e3-aebd-4c7f-8e94-2cae79a2068e")
            assertThat(split.control.station).isEqualTo("100")
            assertThat(split.control.controlType).isNotNull()
            assertThat(split.control.controlType.id).isEqualTo("f3cc5efa-065f-4ad6-844b-74e99612889b")
            assertThat(split.control.controlType.description).isEqualTo("Normal Control")

            // Overalls test
            assertThat(res.overalls).isNull()
        }
    }

    @Test
    fun `Unit Test - Single Valid Result with Overalls`() = runTest {
        responseData = HttpResponseData(
            content = ResultsResponses.valid_overall,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getStageResults(
            eventID = "62a8addc-469f-4304-a217-4cc94c4d7ff2",
            stageID = "d011e2dc-2d12-427b-9e53-842b25eb8481"
        )

        assertTrue(result is Result.Success)

        result.onSuccess { result ->
            assertThat(result).isNotNull()
            assertThat(result.results).isNotNull()

            // Content test
            val res = result.results.first()
            assertThat(res.id).isEqualTo("086910d3-4ac4-4f0b-9097-43dbc34d529c")
            assertThat(res.bibNumber).isEqualTo("4404")
            assertThat(res.isNc).isFalse()
            assertThat(res.eligibility).isNull()
            assertThat(res.sicard).isEqualTo("8027203")
            assertThat(res.sex).isEqualTo("M")
            assertThat(res.legNumber).isEqualTo(1)
            assertThat(res.created).isEqualTo("2026-04-01T07:22:28.833+00:00")
            assertThat(res.runnerClass).isNotNull()
            assertThat(res.runnerClass!!.id).isEqualTo("4e4bf06f-8dbb-4bf0-ba99-3f705aaa0d82")
            assertThat(res.runnerClass.shortName).isEqualTo("M-55")
            assertThat(res.runnerClass.longName).isEqualTo("Masculino 55")
            assertThat(res.runnerClub).isNotNull()
            assertThat(res.runnerClub!!.id).isEqualTo("9e11d2d2-c1c4-428f-a871-7c78b842c438")
            assertThat(res.runnerClub.shortName).isEqualTo("Culleredo GALLAECIA_RAID")
            assertThat(res.fullName).isEqualTo("Rodrigo González Romano")
            assertThat(res.stageResult).isNull()

            // Overalls test
            assertThat(res.overalls).isNotNull()
            val overalls = res.overalls!!

            // Parts of the overall
            assertThat(overalls.parts).isNotNull()
            assertThat(overalls.parts).hasSize(1)
            assertThat(overalls.parts[0]).isNotNull()
            val part = overalls.parts.first()

            assertThat(part.id).isEqualTo("026bdcd4-18f6-46aa-ba0d-b9ffc9b9dca1")
            assertThat(part.stageOrder).isEqualTo(1)
            assertThat(part.uploadType).isEqualTo("total_points")

            assertThat(part.stage).isNotNull()
            val stage = part.stage!!
            assertThat(stage.id).isEqualTo("bbdc0398-3ced-4054-bc80-7e77b957805c")
            assertThat(stage.description).isEqualTo("01 Paderne")

            assertThat(part.position).isEqualTo(1)
            assertThat(part.statusCode).isEqualTo("0")
            assertThat(part.isNc).isNotNull()
            assertThat(part.isNc!!).isFalse()
            assertThat(part.contributory).isNotNull()
            assertThat(part.contributory!!).isTrue()
            assertThat(part.timeSeconds).isEqualTo(0)
            assertThat(part.timeBehind).isEqualTo(0)
            assertThat(part.pointsFinal).isEqualTo(100.0)
            assertThat(part.pointsBehind).isNull()
            assertThat(part.note).isNull()

            // Total of the overall
            assertThat(overalls.overall).isNotNull()
            val total = overalls.overall

            assertThat(total.id).isEmpty()
            assertThat(total.stageOrder).isEqualTo(1)
            assertThat(total.uploadType).isEqualTo("ranking_computed")
            assertThat(total.stage).isNull()
            assertThat(total.position).isEqualTo(1)
            assertThat(total.statusCode).isEqualTo("0")
            assertThat(total.isNc).isNull()
            assertThat(total.contributory).isNull()
            assertThat(total.timeSeconds).isEqualTo(0)
            assertThat(total.timeBehind).isNull()
            assertThat(total.pointsFinal).isEqualTo(300.0)
            assertThat(total.pointsBehind).isNull()
            assertThat(total.note).isNull()
        }
    }

    @Test
    fun `Unit Test - Single Valid Result with Team`() = runTest {
        responseData = HttpResponseData(
            content = ResultsResponses.valid_team,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getStageResults(
            eventID = "152aac91-e74c-43e1-a66d-96ce7734e2b7",
            stageID = "402f1c15-5aeb-4178-b230-0fb2f3163605"
        )

        assertTrue(result is Result.Success)

        result.onSuccess { result ->
            assertThat(result).isNotNull()
            assertThat(result.results).isNotNull()

            // Content test
            val res = result.results.first()
            assertThat(res.id).isEqualTo("036c3d5e-a47d-413e-ac16-7b03d88e5171")
            assertThat(res.bibNumber).isEqualTo("310")
            assertThat(res.isNc).isFalse()
            assertThat(res.eligibility).isNull()
            assertThat(res.sicard).isNull()
            assertThat(res.sex).isNull()
            assertThat(res.legs).isNull()
            assertThat(res.created).isEqualTo("2026-06-22T09:13:09.560+00:00")

            // Runners test
            assertThat(res.runners).isNotNull()
            assertThat(res.runners!!).hasSize(1)
            val runner = res.runners.first()
            assertThat(runner.id).isEqualTo("6739ae46-4fc3-4249-888a-0a4cfcd61ead")
            assertThat(runner.bibNumber).isNull()
            assertThat(runner.isNc).isFalse()
            assertThat(runner.eligibility).isNull()
            assertThat(runner.sicard).isEqualTo("8539568")
            assertThat(runner.sex).isEqualTo("F")
            assertThat(runner.legNumber).isEqualTo(1)
            assertThat(runner.created).isEqualTo("2026-06-22T09:13:09.601+00:00")
            assertThat(runner.runnerClass).isNull()
            assertThat(runner.runnerClub).isNotNull()
            assertThat(runner.runnerClub!!.id).isEqualTo("f193c600-c5e7-483b-ab76-dbc5380f1ad3")
            assertThat(runner.runnerClub.shortName).isEqualTo("COMUNITAT VALENCIANA")
            assertThat(runner.fullName).isEqualTo("Victoria Mena Haro")
            assertThat(runner.stageResult).isNotNull()

            // Runner stages test
            val stage = runner.stageResult!!
            assertThat(stage.id).isEqualTo("eea8aefa-417e-4e3b-9405-e2ea4069a394")
            assertThat(stage.resultTypeID).isEqualTo("e4ddfa9d-3347-47e4-9d32-c6c119aeac0e")
            assertThat(stage.startTime).isEqualTo("2026-06-22T07:27:00.000+00:00")
            assertThat(stage.finishTime).isEqualTo("2026-06-22T07:42:21.000+00:00")
            assertThat(stage.uploadType).isEqualTo("res_splits")
            assertThat(stage.timeSeconds).isEqualTo(921)
            assertThat(stage.position).isEqualTo(11)
            assertThat(stage.statusCode).isEqualTo("0")
            assertThat(stage.isNc).isFalse()
            assertThat(stage.contributory).isNotNull()
            assertThat(stage.contributory!!).isFalse()
            assertThat(stage.timeBehind).isEqualTo(0)
            assertThat(stage.timeNeutralization).isEqualTo(0)
            assertThat(stage.timeAdjusted).isEqualTo(0)
            assertThat(stage.timePenalty).isEqualTo(0)
            assertThat(stage.timeBonus).isEqualTo(0)
            assertThat(stage.pointsFinal).isEqualTo("0.0000")
            assertThat(stage.pointsBehind).isEqualTo("0.0000")
            assertThat(stage.pointsAdjusted).isEqualTo("0.0000")
            assertThat(stage.pointsPenalty).isEqualTo("0.0000")
            assertThat(stage.pointsBonus).isEqualTo("0.0000")
            assertThat(stage.note).isNull()
            assertThat(stage.legNumber).isEqualTo(1)
            assertThat(stage.created).isEqualTo("2026-06-22T09:13:09.609+00:00")

            // Splits test
            assertThat(stage.splits).isNotNull()
            assertThat(stage.splits).hasSize(1)

            val split = stage.splits.first()
            assertThat(split.id).isEqualTo("2693bd26-8495-4cd6-b6cc-780f58fdf99d")
            assertThat(split.isIntermediate).isFalse()
            assertThat(split.readingTime).isEqualTo("2026-06-22T07:41:51.000+00:00")
            assertThat(split.points).isEqualTo(0)
            assertThat(split.orderNumber).isEqualTo(15)
            assertThat(split.created).isEqualTo("2026-06-22T09:13:09.793+00:00")
            assertThat(split.control).isNotNull()
            assertThat(split.control.id).isEqualTo("3e94fe42-4a6f-406d-8d70-472595ac3fc2")
            assertThat(split.control.station).isEqualTo("200")
            assertThat(split.control.controlType).isNotNull()
            assertThat(split.control.controlType.id).isEqualTo("f3cc5efa-065f-4ad6-844b-74e99612889b")
            assertThat(split.control.controlType.description).isEqualTo("Normal Control")

            // Overalls test
            assertThat(res.overalls).isNull()

            // Team test
            assertThat(res.runnerClass).isNotNull()
            assertThat(res.runnerClass!!.id).isEqualTo("0a09691b-bd02-4adc-988b-9f1a39649ddd")
            assertThat(res.runnerClass.shortName).isEqualTo("JUVENIL")
            assertThat(res.runnerClass.longName).isEqualTo("JUVENIL")
            assertThat(res.runnerClub).isNotNull()
            assertThat(res.runnerClub!!.id).isEqualTo("f193c600-c5e7-483b-ab76-dbc5380f1ad3")
            assertThat(res.runnerClub.shortName).isEqualTo("COMUNITAT VALENCIANA")

            assertThat(res.fullName).isEqualTo("COMUNITAT VALENCIANA B")

            // Team stage test
            val teamStage = res.stageResult!!
            assertThat(teamStage.id).isEqualTo("f8e64472-09f8-478c-8e8d-0b022789404e")
            assertThat(teamStage.resultTypeID).isEqualTo("e4ddfa9d-3347-47e4-9d32-c6c119aeac0e")
            assertThat(teamStage.startTime).isEqualTo("2026-06-22T07:27:00.000+00:00")
            assertThat(teamStage.finishTime).isEqualTo("2026-06-22T08:33:49.000+00:00")
            assertThat(teamStage.uploadType).isEqualTo("res_splits")
            assertThat(teamStage.timeSeconds).isEqualTo(4009)
            assertThat(teamStage.position).isEqualTo(0)
            assertThat(teamStage.statusCode).isEqualTo("9")
            assertThat(teamStage.isNc).isFalse()
            assertThat(teamStage.contributory).isNull()
            assertThat(teamStage.timeBehind).isEqualTo(1028)
            assertThat(teamStage.timeNeutralization).isEqualTo(0)
            assertThat(teamStage.timeAdjusted).isEqualTo(0)
            assertThat(teamStage.timePenalty).isEqualTo(0)
            assertThat(teamStage.timeBonus).isEqualTo(0)
            assertThat(teamStage.pointsFinal).isEqualTo("0.0000")
            assertThat(teamStage.pointsBehind).isNull()
            assertThat(teamStage.pointsAdjusted).isEqualTo("0.0000")
            assertThat(teamStage.pointsPenalty).isEqualTo("0.0000")
            assertThat(teamStage.pointsBonus).isEqualTo("0.0000")
            assertThat(teamStage.legNumber).isEqualTo(4)
            assertThat(teamStage.note).isNull()
            assertThat(teamStage.created).isEqualTo("2026-06-22T09:13:09.594+00:00")

            assertThat(teamStage.splits).isNotNull()
            assertThat(teamStage.splits).isEmpty()
            assertThat(res.overalls).isNull()
        }
    }

    @Test
    fun `Unit Test - List of Valid Results with Overalls`() = runTest {
        responseData = HttpResponseData(
            content = ResultsResponses.valid_list_overalls,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getStageResults(
            eventID = "62a8addc-469f-4304-a217-4cc94c4d7ff2",
            stageID = "d011e2dc-2d12-427b-9e53-842b25eb8481"
        )

        assertTrue(result is Result.Success)
        result.onSuccess { result ->
            val results = result.results
            assertThat(results).isNotNull()
            assertThat(results).hasSize(1)

            val item = results.first()
            assertThat(item.overalls).isNotNull()
            assertThat(item.overalls!!.parts).isNotNull()
            assertThat(item.overalls.parts).hasSize(5)

            for ( i in item.overalls.parts.indices) {
                assertThat(item.overalls.parts[i]).isNotNull()
            }

            assertThat(item.overalls.overall).isNotNull()
        }
    }

    @Test
    fun `Unit Test - List of Valid Results with Teams and Splits`() = runTest {
        responseData = HttpResponseData(
            content = ResultsResponses.valid_list_team,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getStageResults(
            eventID = "152aac91-e74c-43e1-a66d-96ce7734e2b7",
            stageID = "402f1c15-5aeb-4178-b230-0fb2f3163605"
        )

        assertTrue(result is Result.Success)
        result.onSuccess { result ->
            val results = result.results
            assertThat(results).isNotNull()
            assertThat(results).hasSize(1)

            val item = results.first()
            assertThat(item.runners).isNotNull()
            assertThat(item.runners!!).hasSize(4)

            val list = listOf<Int>(15, 17, 17, 15)

            for ( i in item.runners.indices) {
                assertThat(item.runners[i]).isNotNull()
                assertThat(item.runners[i].stageResult).isNotNull()
                assertThat(item.runners[i].stageResult!!.splits).isNotNull()
                assertThat(item.runners[i].stageResult!!.splits).hasSize(list[i])
                assertThat(item.runners[i].overalls).isNull()
            }

            assertThat(item.overalls).isNull()
        }
    }

    @Test
    fun `Unit Test - List of No Results`() = runTest {
        responseData = HttpResponseData(
            content = ResultsResponses.empty,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getStageResults(
            eventID = "62a8addc-469f-4304-a217-4cc94c4d7ff2",
            stageID = "d011e2dc-2d12-427b-9e53-842b25eb8481"
        )

        assertTrue(result is Result.Success)
        result.onSuccess { result ->
            val results = result.results
            assertThat(results).isNotNull()
            assertThat(results).isEmpty()
        }
    }

    @Test
    fun `Unit Test - Results Empty Response`() = runTest {
        responseData = HttpResponseData(
            content = ResultsResponses.noResponse,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getStageResults(
            eventID = "62a8addc-469f-4304-a217-4cc94c4d7ff2",
            stageID = "d011e2dc-2d12-427b-9e53-842b25eb8481"
        )

        assertTrue(result is Result.Error)
        assertThat(result.error).isEqualTo(NetworkError.SERIALIZATION)
    }

    @Test
    fun `Unit Test - Results Incomplete Response`() = runTest {
        responseData = HttpResponseData(
            content = ResultsResponses.incompleteResponse,
            statusCode = HttpStatusCode.OK,
        )


        val result = api.getStageResults(
            eventID = "62a8addc-469f-4304-a217-4cc94c4d7ff2",
            stageID = "d011e2dc-2d12-427b-9e53-842b25eb8481"
        )

        assertTrue(result is Result.Error)
        assertThat(result.error).isEqualTo(NetworkError.SERIALIZATION)
    }

    @Test
    fun `Unit Test - Filter Results by class`() = runTest {
        responseData = HttpResponseData(
            content = ResultsResponses.empty,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getStageResults(
            eventID = "62a8addc-469f-4304-a217-4cc94c4d7ff2",
            stageID = "d011e2dc-2d12-427b-9e53-842b25eb8481",
            classID = "0a09691b-bd02-4adc-988b-9f1a39649ddd"
        )

        // Check that the parameters are applied to the request
        assertThat(request.url.parameters["class_id"]).isEqualTo("0a09691b-bd02-4adc-988b-9f1a39649ddd")
        assertThat(request.url.parameters["club_id"]).isNull()
        assertThat(request.url.parameters["text"]).isNull()
        assertThat(request.url.parameters["station"]).isNull()
    }

    @Test
    fun `Unit Test - Filter Results by club`() = runTest {
        responseData = HttpResponseData(
            content = ResultsResponses.empty,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getStageResults(
            eventID = "62a8addc-469f-4304-a217-4cc94c4d7ff2",
            stageID = "d011e2dc-2d12-427b-9e53-842b25eb8481",
            clubID = "3668f6ac-5cc5-4f0e-a809-a1e4d3a2ce45"
        )

        // Check that the parameters are applied to the request
        assertThat(request.url.parameters["class_id"]).isNull()
        assertThat(request.url.parameters["club_id"]).isEqualTo("3668f6ac-5cc5-4f0e-a809-a1e4d3a2ce45")
        assertThat(request.url.parameters["text"]).isNull()
        assertThat(request.url.parameters["station"]).isNull()
    }

    @Test
    fun `Unit Test - Filter Results by text`() = runTest {
        responseData = HttpResponseData(
            content = ResultsResponses.empty,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getStageResults(
            eventID = "62a8addc-469f-4304-a217-4cc94c4d7ff2",
            stageID = "d011e2dc-2d12-427b-9e53-842b25eb8481",
            text = "Runner Name"
        )

        // Check that the parameters are applied to the request
        assertThat(request.url.parameters["class_id"]).isNull()
        assertThat(request.url.parameters["club_id"]).isNull()
        assertThat(request.url.parameters["text"]).isEqualTo("Runner Name")
        assertThat(request.url.parameters["station"]).isNull()
    }

    @Test
    fun `Unit Test - Filter Results by station`() = runTest {
        responseData = HttpResponseData(
            content = ResultsResponses.empty,
            statusCode = HttpStatusCode.OK,
        )

        val result = api.getStageResults(
            eventID = "62a8addc-469f-4304-a217-4cc94c4d7ff2",
            stageID = "d011e2dc-2d12-427b-9e53-842b25eb8481",
            station = 3
        )

        // Check that the parameters are applied to the request
        assertThat(request.url.parameters["class_id"]).isNull()
        assertThat(request.url.parameters["club_id"]).isNull()
        assertThat(request.url.parameters["text"]).isNull()
        assertThat(request.url.parameters["station"]).isEqualTo("3")
    }
}