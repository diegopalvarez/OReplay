package com.diegopalvarez.oreplay.ui.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.diegopalvarez.oreplay.domain.types.StageType
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.chase_start_stage_type
import oreplay.shared.generated.resources.classic_stage_type
import oreplay.shared.generated.resources.generic_stage
import oreplay.shared.generated.resources.mass_start_stage_type
import oreplay.shared.generated.resources.one_man_relay_stage_type
import oreplay.shared.generated.resources.overall_stage_type
import oreplay.shared.generated.resources.raid_stage_type
import oreplay.shared.generated.resources.ranking_stage_type
import oreplay.shared.generated.resources.relay_stage_type
import oreplay.shared.generated.resources.score_stage_type
import oreplay.shared.generated.resources.trail_stage_type
import org.jetbrains.compose.resources.stringResource

@Composable
fun StageTypeToText(
    stageType: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface
) {
    val text  = when (stageType) {
        StageType.CLASSIC.id -> stringResource(Res.string.classic_stage_type)
        StageType.MASS_START.id -> stringResource(Res.string.mass_start_stage_type)
        StageType.CHASE_START.id -> stringResource(Res.string.chase_start_stage_type)
        StageType.OVERALL.id -> stringResource(Res.string.overall_stage_type)
        StageType.RELAY.id -> stringResource(Res.string.relay_stage_type)
        StageType.SCORE.id -> stringResource(Res.string.score_stage_type)
        StageType.RAID.id -> stringResource(Res.string.raid_stage_type)
        StageType.TRAIL.id -> stringResource(Res.string.trail_stage_type)
        StageType.ONE_MAN_RELAY.id -> stringResource(Res.string.one_man_relay_stage_type)
        StageType.RANKING.id -> stringResource(Res.string.ranking_stage_type)
        else -> stringResource(Res.string.generic_stage)        // TODO - Look for better alternatives
    }

    return Text(
        text = text,
        modifier = modifier,
        color = color
    )
}