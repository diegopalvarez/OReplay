package com.diegopalvarez.oreplay.data.remote.dto.liveResults

import com.diegopalvarez.oreplay.data.remote.dto.clubs.RemoteClub
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteClassResults
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteOverallResult
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteLiveResult(
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
    val runners: List<RemoteLiveResult>? = null,

    val created: String,

    @SerialName("class")
    val runnerClass: RemoteClassResults? = null,

    @SerialName("club")
    val runnerClub: RemoteClub? = null,

    @SerialName("full_name")
    val fullName: String,

    @SerialName("stage")
    val stageResult: RemoteLiveStageResult? = null,      // If only overall results are displayed, it might be null. If it contains a Team, it's the overall result for the team and stage
    val overalls: RemoteOverallResult? = null       // If only stage results are displayed, it might be null
)
