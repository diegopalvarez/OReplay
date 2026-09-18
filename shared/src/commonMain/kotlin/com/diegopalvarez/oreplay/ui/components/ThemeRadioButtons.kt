package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.core.language.AppLanguage
import com.diegopalvarez.oreplay.core.language.getAppLanguageByCode
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.theme_dark
import oreplay.shared.generated.resources.theme_default
import oreplay.shared.generated.resources.theme_light
import org.jetbrains.compose.resources.stringResource

@Composable
fun ThemeRadioButtons(
    selectedOption: MutableState<Boolean?>,
) {

    Column(
        modifier = Modifier
            .selectableGroup()
    ) {
        // Dark Theme
        Row(
            Modifier
                .fillMaxWidth()
                .height(56.dp)
                .selectable(
                    selected = (selectedOption.value == true),
                    onClick = { selectedOption.value = true },
                    role = Role.RadioButton
                )
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = (selectedOption.value == true),
                onClick = null
            )
            Text(
                text = stringResource(Res.string.theme_dark),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        // Light Theme
        Row(
            Modifier
                .fillMaxWidth()
                .height(56.dp)
                .selectable(
                    selected = (selectedOption.value == false),
                    onClick = { selectedOption.value = false },
                    role = Role.RadioButton
                )
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = (selectedOption.value == false),
                onClick = null
            )
            Text(
                text = stringResource(Res.string.theme_light),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        // Default Theme
        Row(
            Modifier
                .fillMaxWidth()
                .height(56.dp)
                .selectable(
                    selected = (selectedOption.value == null),
                    onClick = { selectedOption.value = null },
                    role = Role.RadioButton
                )
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = (selectedOption.value == null),
                onClick = null
            )
            Text(
                text = stringResource(Res.string.theme_default),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}