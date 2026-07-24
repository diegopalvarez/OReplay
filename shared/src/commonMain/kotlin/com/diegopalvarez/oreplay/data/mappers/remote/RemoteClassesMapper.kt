package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.remote.dto.classes.RemoteClass
import com.diegopalvarez.oreplay.data.remote.dto.classes.RemoteClassesResponse
import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteClassResults
import com.diegopalvarez.oreplay.domain.model.ResultClass
import com.diegopalvarez.oreplay.domain.model.StageClass

private fun getClass(remoteClass: RemoteClass): StageClass {
    return StageClass(
        id = remoteClass.id,
        shortName = remoteClass.shortName,
        longName = remoteClass.longName,
        radioControls = getRadioControls(remoteClass.radios),
    )
}

/**
 * Function to parse the list of classes received from the API
 * @param remoteClassesResponse Response gotten from the API
 * @return List of classes
 */
fun getClasses(remoteClassesResponse: RemoteClassesResponse): List<StageClass> {
    val classes = remoteClassesResponse.classes
    return classes.map(::getClass)
}

/**
 * Function to parse the individual class received as part of the results for a runner
 * @param remoteClassResult Class gotten from the API
 * @return individual class without radios
 */
fun getResultClass(remoteClassResult: RemoteClassResults): ResultClass {
    return ResultClass(
        id = remoteClassResult.id,
        shortName = remoteClassResult.shortName,
        longName = remoteClassResult.longName,
    )
}