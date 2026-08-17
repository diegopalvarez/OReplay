package com.diegopalvarez.oreplay.data.remote.dto.stages

import com.diegopalvarez.oreplay.data.remote.dto.events.RemoteOrganizer
import com.diegopalvarez.oreplay.data.remote.dto.links.RemoteSelfLink
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteEventDetails(
    val id: String,

    @SerialName("is_hidden")
    val isHidden: Boolean,

    val description: String,
    val picture: String? = null,
    val website: String? = null,
    val scope: String,
    val location: String? = null,

    @SerialName("country_code")
    val countryCode: String? = null,

    @SerialName("initial_date")
    val initialDate: String,

    @SerialName("final_date")
    val finalDate: String,

    val timezone: String,

    @SerialName("federation_id")
    val federationID: String? = null,

    val created: String,
    val modified: String,

    @SerialName("organizer_id")
    val organizerID: String,
    val organizer: RemoteOrganizer,

    // TODO - Up to here, everything is repeated from the RemoteEvent query

    val stages: List<RemoteStage>,
    val federation: String? = null,     // TODO - Check type, might be another element but isn't specified

    @SerialName("_links")
    val links: RemoteSelfLink
)
