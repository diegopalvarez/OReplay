package com.diegopalvarez.oreplay.domain.repository.type

import com.diegopalvarez.oreplay.domain.model.Result

data class OneManRelayRepositoryResult(
    private val resultList: List<Result>
): RepositoryResult(resultList)