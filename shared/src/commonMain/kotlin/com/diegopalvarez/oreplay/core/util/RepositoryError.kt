package com.diegopalvarez.oreplay.core.util

enum class RepositoryError : Error {
    NETWORK,
    INTERNAL,
    SERVER,
    NOT_IMPLEMENTED,
    UNKNOWN;
}