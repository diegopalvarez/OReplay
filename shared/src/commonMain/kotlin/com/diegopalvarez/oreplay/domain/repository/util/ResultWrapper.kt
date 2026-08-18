package com.diegopalvarez.oreplay.domain.repository.util

import com.diegopalvarez.oreplay.domain.model.Result
import com.diegopalvarez.oreplay.domain.repository.type.ClassicRepositoryResult
import com.diegopalvarez.oreplay.domain.repository.type.OneManRelayRepositoryResult
import com.diegopalvarez.oreplay.domain.repository.type.OverallRepositoryResult
import com.diegopalvarez.oreplay.domain.repository.type.RelayRepositoryResult
import com.diegopalvarez.oreplay.domain.repository.type.RepositoryResult
import com.diegopalvarez.oreplay.domain.repository.type.ScoreRepositoryResult
import com.diegopalvarez.oreplay.domain.types.StageType

fun wrapResult(
    result: List<Result>,
    stageType: StageType
): RepositoryResult {
    return when (stageType) {
        StageType.CLASSIC -> ClassicRepositoryResult(result)
        StageType.MASS_START -> TODO("Implement in the whole app")
        StageType.CHASE_START -> TODO("Implement in the whole app")
        StageType.OVERALL -> OverallRepositoryResult(result)
        StageType.RELAY -> RelayRepositoryResult(result)
        StageType.SCORE -> ScoreRepositoryResult(result)
        StageType.RAID -> TODO("Implement in the whole app")
        StageType.TRAIL -> TODO("Implement in the whole app")
        StageType.ONE_MAN_RELAY -> OneManRelayRepositoryResult(result)
        StageType.RANKING -> TODO("Implement in the whole app")
    }
}