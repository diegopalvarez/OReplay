package com.diegopalvarez.oreplay.feature.stageDetails.common

import com.diegopalvarez.oreplay.domain.model.StageClass
import com.diegopalvarez.oreplay.domain.model.StageClub

class SearchResultWrapper(
    val isClass: Boolean,
    val classResult: StageClass?,
    val clubResult: StageClub?
) {
}