package com.diegopalvarez.oreplay.domain.repository.util


data class ScoreResultStats(
    val visited: Map<String, Long>,     // Number of visitors for each of the stations
    val runners: Long,                  // Number of runners in the class
)
