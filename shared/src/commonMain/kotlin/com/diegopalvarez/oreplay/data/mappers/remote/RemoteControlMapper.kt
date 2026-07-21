package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.remote.dto.results.RemoteControl
import com.diegopalvarez.oreplay.domain.model.Control

fun getControl(remoteControl: RemoteControl): Control {
    return Control(
        id = remoteControl.id,
        station = remoteControl.station,
        controlType = remoteControl.controlType.id      // Only the ID is needed since the control types are predefined
    )
}