package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.diegopalvarez.oreplay.core.language.AppLanguage
import com.diegopalvarez.oreplay.core.language.getAppLanguageByCode
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.change_language
import oreplay.shared.generated.resources.confirm_dialog
import oreplay.shared.generated.resources.dismiss_dialog
import org.jetbrains.compose.resources.stringResource

@Composable
fun LanguagePickerDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: (String) -> Unit,
    currentSelected: String?,
) {
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
                // Language Picker Title
                Text(
                    text = stringResource(Res.string.change_language),
                    modifier = Modifier.padding(16.dp),
                )

                // Language Picker Options
                val selectedOption = remember { mutableStateOf(getAppLanguageByCode(currentSelected)) }
                LanguageRadioButtons(selectedOption)

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
                            onConfirmation(selectedOption.value.code)
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