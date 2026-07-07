package com.diegopalvarez.oreplay.data.remote.dto.results

import com.diegopalvarez.oreplay.data.remote.dto.classes.RemoteClass
import com.diegopalvarez.oreplay.data.remote.dto.clubs.RemoteClub
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteResult(
    val id: String,

    @SerialName("bib_number")
    val bibNumber: String,

    @SerialName("is_nc")
    val isNc: Boolean,

    val eligibility: String? = null,        // TODO - Check its meaning and possible values

    // Only in case of single competitors
    val sicard: String,
    val sex: String,

    @SerialName("leg_number")
    val legNumber: Long,

    // Only in case of team competitors
    val legs:  Long? = null,                             // TODO - Check type String/Long
    val runners: List<RemoteResult>,

    val created: String,

    @SerialName("class")
    val runnerClass: RemoteClass,

    val runnerClub: RemoteClub,

    @SerialName("full_name")
    val fullName: String,

    val stageResult: RemoteStageResult? =null,      // If only overall results are displayed, it might be null. If it contains a Team, it's the overall result for the team and stage
    val overalls: RemoteOverallResult? = null       // If only stage results are displayed, it might be null
)
