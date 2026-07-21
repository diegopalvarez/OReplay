package com.diegopalvarez.oreplay.data.remote.dto.results

import com.diegopalvarez.oreplay.data.remote.dto.clubs.RemoteClub
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteResult(
    val id: String,

    @SerialName("bib_number")
    val bibNumber: String ? = null,

    @SerialName("is_nc")
    val isNc: Boolean,

    val eligibility: Boolean? = null,        // TODO - Check its meaning and possible values

    // Only in case of single competitors
    val sicard: String? = null,
    val sex: String? = null,

    @SerialName("leg_number")
    val legNumber: Long? = null,

    // Only in case of team competitors
    val legs: Long? = null,                             // TODO - Check type String/Long
    val runners: List<RemoteResult>? = null,

    val created: String,

    @SerialName("class")
    val runnerClass: RemoteClassResults? = null,

    @SerialName("club")
    val runnerClub: RemoteClub? = null,

    @SerialName("full_name")
    val fullName: String,

    @SerialName("stage")
    val stageResult: RemoteStageResult? = null,      // If only overall results are displayed, it might be null. If it contains a Team, it's the overall result for the team and stage
    val overalls: RemoteOverallResult? = null       // If only stage results are displayed, it might be null
)
