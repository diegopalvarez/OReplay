package com.diegopalvarez.oreplay.domain.repository.util

import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.ResultTeam

fun getNumberOfLegs(
    results: List<ResultTeam>
): Int {
    return results.maxOfOrNull { it.runners.size } ?: 1
}