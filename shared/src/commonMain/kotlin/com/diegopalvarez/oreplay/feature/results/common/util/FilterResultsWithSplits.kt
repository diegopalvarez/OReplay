package com.diegopalvarez.oreplay.feature.results.common.util

import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.types.UploadType

fun filterResultsWithSplits(
    runners: List<ResultIndividual>
): List<ResultIndividual> {
    return runners.filter {
        it.stageResult != null &&
                (it.stageResult.uploadType == UploadType.SPLIT_RESULT || it.stageResult.uploadType == UploadType.FINAL_RESULT)
    }
}