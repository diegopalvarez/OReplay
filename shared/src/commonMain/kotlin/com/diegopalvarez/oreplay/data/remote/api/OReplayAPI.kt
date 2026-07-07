package com.diegopalvarez.oreplay.data.remote.api

import com.diegopalvarez.oreplay.core.util.NetworkError
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.koin.compose.koinInject
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

// Base URL Definitions
const val EVENTS_URL = "https://www.oreplay.es/api/v1/events/"

class OReplayAPI: KoinComponent {
    // Inject HTTP Client
    val client: HttpClient by inject()

    /**
     *  Function to get the list of events uploaded to the server
     */
    suspend fun getEvents(_when: String?): Result<String, NetworkError> {
        val response = try {
            client.get(
                urlString = EVENTS_URL
            ) {
                if(!_when.isNullOrBlank()) {
                    parameter("when", _when)
                }
            }
        }


    }

    /**
     * Private TRY-CATCH wrapper that handles the different calls to the API and solves the different possible errors
     */
}