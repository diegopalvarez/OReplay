package com.diegopalvarez.oreplay.feature.results.common.util

sealed interface Optional<out T : Any> {
    data object None : Optional<Nothing>
    data class Some<T : Any>(val value: T) : Optional<T>
}