package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.remote.dto.radiocontrols.RemoteRadioControl
import com.diegopalvarez.oreplay.data.remote.dto.stages.RemoteStage
import com.diegopalvarez.oreplay.domain.model.SplitRadio

private fun getRadioControl(remoteRadioControl: RemoteRadioControl): SplitRadio {
    return SplitRadio("")       // TODO - Complete when radios are available
}

/**
 * Function to parse the radio controls from the API into domain objects
 * @param remoteRadioControls List of radios gotten from the API
 * @return List of radio controls
 */
fun getRadioControls(remoteRadioControls: List<RemoteRadioControl>): List<SplitRadio> {
    return remoteRadioControls.map(::getRadioControl)
}