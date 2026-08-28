package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.diegopalvarez.oreplay.ui.util.displayWithUnit
import kotlinx.coroutines.flow.Flow
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.change_reload
import oreplay.shared.generated.resources.confirm_dialog
import oreplay.shared.generated.resources.dismiss_dialog
import org.jetbrains.compose.resources.stringResource
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

@Composable
fun RefreshDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: (Long) -> Unit,
    currentInterval: Long?,
) {
    // Select the initial selected interval
    val initialSelection = when(currentInterval){
        30.seconds.inWholeSeconds -> 0
        1.minutes.inWholeSeconds -> 1
        2.minutes.inWholeSeconds -> 2
        5.minutes.inWholeSeconds -> 3
        else -> 1       // By default, 1 minute
    }

    // Define the possible units
    val options = listOf(30.seconds, 1.minutes, 2.minutes, 5.minutes)

    // Selected Unit
    var selectedIndex by remember { mutableIntStateOf(initialSelection) }

    Dialog(
        onDismissRequest = {
            onDismissRequest()
        }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            // Contents of the card
            Column(
                modifier = Modifier
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Reload Interval Title
                Text(
                    text = stringResource(Res.string.change_reload),
                    modifier = Modifier.padding(16.dp),
                )

                // Interval Selector
                SingleChoiceSegmentedButtonRow(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                ){
                    // Buttons
                    options.forEachIndexed { index, label ->
                        SegmentedButton(
                            shape = SegmentedButtonDefaults.itemShape(
                                index = index,
                                count = options.size,
                            ),
                            onClick = { selectedIndex = index },
                            selected = index == selectedIndex,
                            label = {
                                Text(label.displayWithUnit())
                            }

                        )
                    }
                }

                // Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    // Cancel Button
                    TextButton(
                        onClick = { onDismissRequest() },
                        modifier = Modifier.padding(8.dp)
                    ){
                        Text(stringResource(Res.string.dismiss_dialog))
                    }

                    // Confirm Button
                    TextButton(
                        onClick = {
                            onConfirmation(options[selectedIndex].inWholeSeconds)
                            onDismissRequest()
                        },
                        modifier = Modifier.padding(8.dp)
                    ){
                        Text(stringResource(Res.string.confirm_dialog))
                    }
                }
            }
        }
    }
}