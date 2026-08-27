package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.relay

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import com.diegopalvarez.oreplay.domain.model.ResultTeam
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.common.ResultTimesHeaderRow
import com.diegopalvarez.oreplay.ui.components.TextFieldWithName
import com.diegopalvarez.oreplay.ui.util.display
import kotlinx.datetime.TimeZone
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.after_leg
import oreplay.shared.generated.resources.points
import oreplay.shared.generated.resources.position
import oreplay.shared.generated.resources.team_position
import oreplay.shared.generated.resources.team_time
import oreplay.shared.generated.resources.team_time_behind
import oreplay.shared.generated.resources.time_ticket
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import kotlin.math.roundToInt
import kotlin.time.Duration

@Composable
fun TeamResultsHeader(
    result: StageResult,
    teamPosition: Long,
    teamAccumulatedTime: Duration,
    teamTimeBehind: Duration,
    teamIsAccumulatedError: Boolean,
    teamStatusCode: StatusCode,
    eventTimezone: TimeZone,
){
    // TODO - Modularize this check
    // Check if the start time should be converted to the local timezone
    var timezone = TimeZone.currentSystemDefault()

    // Inject the preference manager and see if there's a need to convert the timezone
    val preferenceManager: PreferencesManager = koinInject()
    val timezonePreference = preferenceManager.convertTimezone.collectAsState()
    val convertTimezones = timezonePreference.value ?: true

    // If the preference it's to not choose the timezone, and they're different, keep the event one
    // In every other case, just use the local
    if(!convertTimezones && eventTimezone != timezone) {
        timezone = eventTimezone
    }

    // Calculate the status code of the runner
    val statusCode = result.statusCode

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Position
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            // Position
            if(result.position != 0L){
                TextFieldWithName(
                    name = Res.string.position,
                    value = result.position.toString()
                )
            }
        }

        // Start Time and Total Time
        ResultTimesHeaderRow(result, timezone, statusCode)

        // Team statistics
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = MaterialTheme.colorScheme.tertiaryContainer)
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Card title
            Text(
                text = stringResource(Res.string.after_leg)
            )

            // Team time until now or Status if there's been an error
            if(!teamIsAccumulatedError) {
                // Team position
                if(teamPosition != 0L){
                    TextFieldWithName(
                        name = Res.string.team_position,
                        value = teamPosition.toString()
                    )
                }

                // Team accumulated time
                TextFieldWithName(
                    name = Res.string.team_time,
                    value = teamAccumulatedTime.display()
                )

                // Team time behind
                TextFieldWithName(
                    name = Res.string.team_time_behind,
                    value = "+${teamTimeBehind.display()}"
                )
            }
            else{
                TextFieldWithName(
                    name = Res.string.team_time,
                    value = stringResource(teamStatusCode.displayName)
                )
            }

        }

    }
}