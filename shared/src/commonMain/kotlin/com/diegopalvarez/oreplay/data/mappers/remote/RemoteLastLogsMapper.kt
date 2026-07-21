package com.diegopalvarez.oreplay.data.mappers.remote

import com.diegopalvarez.oreplay.data.remote.dto.stages.RemoteLastLog

fun getStageState(remoteLastLogs: List<RemoteLastLog>): Long {
    return remoteLastLogs.maxOf { it.state }
}