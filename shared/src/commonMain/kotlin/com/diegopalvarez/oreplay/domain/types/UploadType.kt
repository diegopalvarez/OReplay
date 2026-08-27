package com.diegopalvarez.oreplay.domain.types

import oreplay.shared.generated.resources.DNF
import oreplay.shared.generated.resources.DNS
import oreplay.shared.generated.resources.DSQ
import oreplay.shared.generated.resources.MP
import oreplay.shared.generated.resources.OK
import oreplay.shared.generated.resources.OT
import oreplay.shared.generated.resources.Res
import org.jetbrains.compose.resources.StringResource

enum class UploadType(val type: String) {
    COMPUTABLE_ORG("computable_org"),
    ENTRY_LIST("entry_list"),
    FINAL_RESULT("res_finish"),
    ONLINE_SPLITS("res_intermediates"),
    RANKING_COMPUTED("ranking_computed"),
    SPLIT_RESULT("res_splits"),
    START_TIMES("start_list"),
    TOTAL_POINTS("total_points"),
    TOTAL_TIMES("total_times"),
}