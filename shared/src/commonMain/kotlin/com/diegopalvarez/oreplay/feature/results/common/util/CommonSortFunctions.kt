package com.diegopalvarez.oreplay.feature.results.common.util

import com.diegopalvarez.oreplay.domain.model.OverallResult
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.types.StatusCode

fun statusOrder(stageResult: StageResult?, isNC: Boolean): Int{
    // The default is the lowest priority possible
    if(stageResult == null){
        return 10
    }

    // TODO - Check NC ordering
    // If the results is NC, it has its own priority behind OK results
    if(isNC){
        return 0
    }

    // The position is 0 when there's no position applicable
    return when(stageResult.statusCode){
        StatusCode.OK -> {
            if(stageResult.position > 0){
                // The first results are the correct ones
                0
            } else{
                // Runners that are still running are displayed under correctly finished runners and OT
                2
            }
        }
        StatusCode.OVERTIME -> 1
        StatusCode.MISSING_PUNCH -> 3
        StatusCode.DISQUALIFIED -> 5
        StatusCode.DID_NOT_FINISH -> 4
        StatusCode.DID_NOT_START -> 6
    }
}

fun statusOrderOverall(overallResult: OverallResult?, isNC: Boolean): Int{
    // The default is the lowest priority possible
    if(overallResult == null){
        return 10
    }

    // If the results is NC, it has its own priority behind OK results
    if(isNC){
        return 0
    }

    // The position is 0 when there's no position applicable
    return when(overallResult.statusCode){
        StatusCode.OK -> {
            if(overallResult.position > 0){
                // The first results are the correct ones
                0
            } else{
                // Runners that are still running are displayed under correctly finished runners and OT
                2
            }
        }
        StatusCode.OVERTIME -> 1
        StatusCode.MISSING_PUNCH -> 3
        StatusCode.DISQUALIFIED -> 5
        StatusCode.DID_NOT_FINISH -> 4
        StatusCode.DID_NOT_START -> 6
    }
}

fun sortByPosition(
    positionA: Long?,
    positionB: Long?,
    isANC: Boolean,
    isBNC: Boolean
): Int {
    return if(positionA != null && positionB != null){
        // If both runners have a stageResult and a position
        if(positionA == positionB){
            sortByIsNC(isANC, isBNC)
        }
        else{
            positionA.compareTo(positionB)
        }
    }
    else if(positionA != null) {
        -1
    }
    else if(positionB != null) {
        1
    }
    else{
        0
    }
}

fun sortByIsNC(
    isANC: Boolean,
    isBNC: Boolean
): Int {
    return if(isANC && isBNC){
        0
    }
    else if(isANC){
        1
    }
    else if(isBNC){
        -1
    }
    else {
        0
    }
}