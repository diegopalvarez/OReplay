package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.classic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.diegopalvarez.oreplay.core.datastore.PreferencesManager
import com.diegopalvarez.oreplay.domain.model.StageResult
import com.diegopalvarez.oreplay.domain.types.StatusCode
import com.diegopalvarez.oreplay.domain.types.getStatusCode
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.common.ResultTimesHeaderRow
import com.diegopalvarez.oreplay.ui.components.TextFieldWithName
import com.diegopalvarez.oreplay.ui.util.display
import com.diegopalvarez.oreplay.ui.util.displayTime
import kotlinx.datetime.TimeZone
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.points
import oreplay.shared.generated.resources.position
import oreplay.shared.generated.resources.start_time_ticket
import oreplay.shared.generated.resources.time_ticket
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import kotlin.math.roundToInt

@Composable
fun RunnerResultsHeader(
    result: StageResult,
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
    val statusCode = result.statusCode.getStatusCode()

    // TODO - Consider adding the other time parameters (neutralization, bonus, penalty)

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Position and Points
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

            // Points - These are not calculated by the API and have to be manually calculated
            // TODO - Check if NC runners also have points or not
            if(statusCode == StatusCode.OK){
                // TODO - Check what points field does and if there's a better option to calculating the points here
                val time = result.timeSeconds.inWholeSeconds.toDouble()
                val timeWinner = (result.timeSeconds - result.timeBehind).inWholeSeconds.toDouble()

                // If the time is 0, dividing would cause an Exception
                if(time != 0.0){
                    TextFieldWithName(
                        name = Res.string.points,
                        value = ((timeWinner / time) * 1000).roundToInt().toString()   // (Winner Time / Runner Time) * 1000
                    )
                }

            }
            else{
                TextFieldWithName(
                    name = Res.string.points,
                    value = "0"
                )
            }
        }

        // Start Time and Total Time
        ResultTimesHeaderRow(result, timezone, statusCode)
    }
}