package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.feature.results.common.types.results.navigation.CommonResultComponent
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_class
import oreplay.shared.generated.resources.no_club
import org.jetbrains.compose.resources.stringResource

@Composable
fun RunnerInformationHeader(
    runner: ResultIndividual,
    component: CommonResultComponent
) {
    // Get from the component if it's a class or club view
    val isClubView = component.isClubView()

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Runner Name
        Text(
            text = runner.fullName,
            style = MaterialTheme.typography.titleLarge,
        )
    }

    // Runner Class and Club
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Runner Class
        if (runner.runnerClass != null) {
            ClassLink(
                stageClass = runner.runnerClass,
                isClubView = isClubView,
                goToPage = component.goToPage
            )
        } else {
            // Should never happen
            Text(
                text = stringResource(Res.string.no_class),
                style = MaterialTheme.typography.titleMedium,
            )
        }

        // Runner Club
        if (runner.runnerClub != null) {
            ClubLink(
                stageClub = runner.runnerClub,
                isClubView = isClubView,
                goToPage = component.goToPage
            )
        } else {
            Text(
                text = stringResource(Res.string.no_club),
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}