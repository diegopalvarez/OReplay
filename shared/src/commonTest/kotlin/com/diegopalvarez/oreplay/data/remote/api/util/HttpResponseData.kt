package com.diegopalvarez.oreplay.data.remote.api.util

import io.ktor.http.HttpStatusCode

data class HttpResponseData(
    val content: String,
    val statusCode: HttpStatusCode,
)
