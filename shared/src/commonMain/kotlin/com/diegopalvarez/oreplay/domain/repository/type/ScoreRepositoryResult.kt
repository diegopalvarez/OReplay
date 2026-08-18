package com.diegopalvarez.oreplay.domain.repository.type

import com.diegopalvarez.oreplay.domain.model.Result

data class ScoreRepositoryResult(
    private val resultList: List<Result>
): RepositoryResult(resultList)