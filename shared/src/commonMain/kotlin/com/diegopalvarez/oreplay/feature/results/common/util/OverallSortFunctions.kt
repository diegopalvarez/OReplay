package com.diegopalvarez.oreplay.feature.results.common.util

import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.types.StatusCode
import kotlin.time.Clock
import kotlin.time.Instant

fun sortByStatusOverall(): Comparator<ResultIndividual> {
    return Comparator{ a, b ->
        val statusA = statusOrderOverall(a.overallResult?.overallTotal, a.isNc)
        val statusB = statusOrderOverall(b.overallResult?.overallTotal, b.isNc)

        statusA - statusB // Smaller status are the ones with the most priority
    }
}

fun sortByStagePositionOverall(): Comparator<ResultIndividual> {
    return Comparator{ a, b ->
        val positionA = a.overallResult?.overallTotal?.position
        val positionB = b.overallResult?.overallTotal?.position

        if(positionA != 0L && positionB != 0L){
            // If both positions are valid finished positions, sort in a new step
            sortByPosition(positionA, positionB, a.isNc, b.isNc)
        }
        else if(positionA == 0L && positionB == 0L) {
            // If both positions are 0, both runners haven't finished correctly or yet
            0
        }
        else if(positionA == 0L){
            1
        }
        else if(positionB == 0L){
            -1
        }
        else{
            0
        }
    }
}

fun sortByOverallPositionOverall(): Comparator<ResultIndividual> {
    return Comparator{ a, b ->
        sortByPosition(
            a.overallResult?.overallTotal?.position,
            b.overallResult?.overallTotal?.position,
            a.isNc,     // TODO - Check why there are several different isNC fields
            b.isNc,)
    }
}

fun sortByNameOverall(): Comparator<ResultIndividual> {
    return Comparator{ a, b ->
        a.fullName
            .lowercase()
            .compareTo(b.fullName.lowercase())
    }
}

fun sortByTimeOverall(): Comparator<ResultIndividual> {
    return Comparator{ a, b ->
        val timeA = a.overallResult?.overallTotal?.timeSeconds
        val timeB = b.overallResult?.overallTotal?.timeSeconds

        if(timeA != null && timeB != null){
            timeA.compareTo(timeB)
        }
        else if(timeA != null){
            -1
        }
        else if(timeB != null){
            1
        }
        else{
            0
        }

    }
}