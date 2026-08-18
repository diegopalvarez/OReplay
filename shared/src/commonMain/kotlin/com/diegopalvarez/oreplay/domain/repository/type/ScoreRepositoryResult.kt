package com.diegopalvarez.oreplay.domain.repository.type

import com.diegopalvarez.oreplay.domain.model.Result
import com.diegopalvarez.oreplay.domain.repository.util.ScoreResultStats

data class ScoreRepositoryResult(
    private val resultList: List<Result>,
    val visitedControls: Map<String, ScoreResultStats>
): RepositoryResult(resultList)