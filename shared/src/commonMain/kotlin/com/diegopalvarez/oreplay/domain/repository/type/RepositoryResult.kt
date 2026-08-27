package com.diegopalvarez.oreplay.domain.repository.type

import com.diegopalvarez.oreplay.domain.model.Result

abstract class RepositoryResult(
    val result: List<Result>
) {
}