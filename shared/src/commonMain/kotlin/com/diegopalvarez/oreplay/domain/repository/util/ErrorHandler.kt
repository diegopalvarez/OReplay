package com.diegopalvarez.oreplay.domain.repository.util

import com.diegopalvarez.oreplay.core.util.NetworkError
import com.diegopalvarez.oreplay.core.util.RepositoryError

fun handleNetworkError(
    error: NetworkError
): RepositoryError {
    return when (error) {
        NetworkError.BAD_REQUEST -> RepositoryError.INTERNAL
        NetworkError.UNAUTHORIZED -> RepositoryError.INTERNAL
        NetworkError.FORBIDDEN -> RepositoryError.INTERNAL
        NetworkError.NOT_FOUND -> RepositoryError.INTERNAL
        NetworkError.METHOD_NOT_ALLOWED -> RepositoryError.INTERNAL
        NetworkError.CONFLICT -> RepositoryError.INTERNAL
        NetworkError.SERVER_ERROR -> RepositoryError.SERVER
        NetworkError.REQUEST_TIMEOUT -> RepositoryError.SERVER
        NetworkError.NO_INTERNET -> RepositoryError.NETWORK
        NetworkError.SERIALIZATION -> RepositoryError.INTERNAL
        NetworkError.UNKNOWN -> RepositoryError.UNKNOWN
    }
}