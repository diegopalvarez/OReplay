package com.diegopalvarez.oreplay.core.util

enum class NetworkError : Error {
    BAD_REQUEST,        // 400
    UNAUTHORIZED,       // 401
    FORBIDDEN,          // 403
    NOT_FOUND,          // 404
    METHOD_NOT_ALLOWED, // 405
    CONFLICT,           // 409
    SERVER_ERROR,       // 50x
    REQUEST_TIMEOUT,
    NO_INTERNET,
    SERIALIZATION,
    UNKNOWN;
}