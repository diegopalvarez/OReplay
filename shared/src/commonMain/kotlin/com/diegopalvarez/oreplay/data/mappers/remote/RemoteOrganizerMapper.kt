package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.remote.dto.events.RemoteOrganizer
import com.diegopalvarez.oreplay.domain.model.Organizer

/**
 * Function to parse an organizer obtained from the API to a domain model
 * @param remoteOrganizer organizer gotten from the API
 * @return Domain model Organizer
 */
fun getOrganizer(remoteOrganizer: RemoteOrganizer): Organizer {
    return Organizer(
        id = remoteOrganizer.id,
        name = remoteOrganizer.name,
        countryCode = remoteOrganizer.countryCode,
        regionCode = remoteOrganizer.regionCode,
        province = remoteOrganizer.province,
        city = remoteOrganizer.city,
        region = remoteOrganizer.region
    )
}