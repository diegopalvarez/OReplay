package com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.score

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
import com.diegopalvarez.oreplay.feature.results.common.types.results.components.ticket.common.ResultTimesHeaderRow
import com.diegopalvarez.oreplay.ui.components.TextFieldWithName
import com.diegopalvarez.oreplay.ui.util.toPoints
import kotlinx.datetime.TimeZone
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.bonus
import oreplay.shared.generated.resources.penalty
import oreplay.shared.generated.resources.points
import oreplay.shared.generated.resources.position
import org.koin.compose.koinInject

@Composable
fun RunnerScoreResultsHeader(
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
    val statusCode = result.statusCode

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

            // Points - For Score results, these are provided by the API
            if(statusCode == StatusCode.OK){
                if(result.pointsTotal != null){
                    TextFieldWithName(
                        name = Res.string.points,
                        value = result.pointsTotal.toPoints()
                    )
                }
                else{
                    TextFieldWithName(
                        name = Res.string.points,
                        value = "0"
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

        // Bonus and Penalty
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            // Point Bonus
            if(result.pointsBonus != null){
                TextFieldWithName(
                    name = Res.string.bonus,
                    value = result.pointsBonus.toPoints()
                )
            }
            else{
                TextFieldWithName(
                    name = Res.string.bonus,
                    value = "0"
                )
            }

            // Point Penalty
            if(result.pointsPenalty != null){
                TextFieldWithName(
                    name = Res.string.penalty,
                    value = result.pointsPenalty.toPoints()
                )
            }
            else{
                TextFieldWithName(
                    name = Res.string.penalty,
                    value = "0"
                )
            }
        }

        // Start Time and Total Time
        ResultTimesHeaderRow(result, timezone, statusCode)
    }
}