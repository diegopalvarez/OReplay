package com.diegopalvarez.oreplay.data.remote.dto.events

import com.diegopalvarez.oreplay.data.remote.dto.links.RemoteSelfLink
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteEvent (
    val id: String,

    @SerialName("is_hidden")
    val isHidden: Boolean,

    val description: String,
    val picture: String? = null,     // TODO - Check why it's always null
    val website: String? = null,
    val scope: String,
    val location: String? = null,    // TODO - Check why it's always null

    @SerialName("country_code")
    val countryCode: String,

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

    @SerialName("_links")
    val links: RemoteSelfLink
)