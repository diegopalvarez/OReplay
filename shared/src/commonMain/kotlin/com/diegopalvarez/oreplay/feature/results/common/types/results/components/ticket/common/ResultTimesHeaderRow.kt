package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.diegopalvarez.oreplay.domain.model.ResultIndividual
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.ui.components.TextFieldWithName
import com.diegopalvarez.oreplay.ui.util.display
import com.diegopalvarez.oreplay.ui.util.displayTime
import kotlinx.datetime.TimeZone
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.start_time_ticket
import oreplay.shared.generated.resources.time_ticket
import org.jetbrains.compose.resources.stringResource

@Composable
fun ResultTimesHeaderRow(
    result: StageResult,
    timezone: TimeZone,
    statusCode: StatusCode,
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        // Start Time
        if(result.startTime != null) {
            TextFieldWithName(
                name = Res.string.start_time_ticket,
                value = result.startTime.displayTime(timezone)
            )
        }
        // TODO - In which cases might the start time be null?

        // Time or Status if there's been an error
        if(statusCode == StatusCode.OK) {
            if(result.position != 0L){
                // Only display the time if the runner has finished
                TextFieldWithName(
                    name = Res.string.time_ticket,
                    value = result.timeSeconds.display()
                )
            }

        }
        else{
            TextFieldWithName(
                name = Res.string.time_ticket,
                value = stringResource(statusCode.displayName)
            )
        }

    }
}