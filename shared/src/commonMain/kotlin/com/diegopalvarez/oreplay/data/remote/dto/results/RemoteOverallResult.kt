package com.diegopalvarez.oreplay.data.remote.dto.results

import kotlinx.serialization.Serializable

@Serializable
data class RemoteOverallResult(
    val parts: List<RemoteOverall>,     // List of RemoteOverall with details for every stage the runner participated in.
    val overall: RemoteOverall          // Total final result taking into account every part listed.
)
