package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket

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
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_class
import oreplay.shared.generated.resources.no_club
import org.jetbrains.compose.resources.stringResource

@Composable
fun RunnerInformationHeader(
    runner: ResultIndividual
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Name and Club
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            // Runner Name
            Text(
                text = runner.fullName,
                style = MaterialTheme.typography.titleLarge,
            )
            // Runner Club
            if(runner.runnerClub != null){
                Text(
                    text = runner.runnerClub.shortName,
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            else{
                Text(
                    text = stringResource(Res.string.no_club),
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }

        // Runner Class
        if(runner.runnerClass != null){
            Text(
                text = runner.runnerClass.shortName,
                style = MaterialTheme.typography.titleMedium,
            )
        }
        else{
            // Should never happen
            Text(
                text = stringResource(Res.string.no_class),
                style = MaterialTheme.typography.titleMedium,
            )
        }

    }
}