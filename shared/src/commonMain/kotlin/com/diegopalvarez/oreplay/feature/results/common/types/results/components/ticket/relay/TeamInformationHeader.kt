package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.relay

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.ResultTeam
import com.diegopalvarez.oreplay.ui.components.TextFieldWithName
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.leg
import oreplay.shared.generated.resources.legs_title
import oreplay.shared.generated.resources.no_class
import oreplay.shared.generated.resources.no_club
import oreplay.shared.generated.resources.position
import org.jetbrains.compose.resources.stringResource

@Composable
fun TeamInformationHeader(
    team: ResultTeam,
    runner: ResultIndividual
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Team Name
        Text(
            text = team.fullName,
            style = MaterialTheme.typography.titleLarge,
        )
    }

    // Team Class and Club
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Team Class
        if (team.teamClass != null) {
            Text(
                text = team.teamClass.shortName,
                style = MaterialTheme.typography.titleMedium,
            )
        } else {
            // Should never happen
            Text(
                text = stringResource(Res.string.no_class),
                style = MaterialTheme.typography.titleMedium,
            )
        }

        // Team Club
        if (team.teamClub != null) {
            Text(
                text = team.teamClub.shortName,
                style = MaterialTheme.typography.titleMedium,
            )
        } else {
            Text(
                text = stringResource(Res.string.no_club),
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }

    // Runner Name and Leg Number
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Runner name
        Text(
            text = runner.fullName,
            style = MaterialTheme.typography.titleMedium,
        )

        // Runner Leg Number
        TextFieldWithName(
            name = Res.string.leg,
            value = runner.legNumber.toString(),
        )
    }
}