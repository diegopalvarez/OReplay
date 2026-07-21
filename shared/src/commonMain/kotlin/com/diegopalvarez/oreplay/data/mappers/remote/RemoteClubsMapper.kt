package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.remote.dto.clubs.RemoteClub
import com.diegopalvarez.oreplay.data.remote.dto.clubs.RemoteClubsResponse
import com.diegopalvarez.oreplay.domain.model.StageClub

fun getClub(remoteClub: RemoteClub): StageClub {
    return StageClub(
        id = remoteClub.id,
        shortName = remoteClub.shortName,
    )
}

/**
 * Function to parse the list of clubs received from the API
 * @param remoteClubsResponse Response gotten from the API
 * @return List of clubs
 */
fun getClubs(remoteClubsResponse: RemoteClubsResponse): List<StageClub> {
    val clubs = remoteClubsResponse.clubs
    return clubs.map(::getClub)
}