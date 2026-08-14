package com.diegopalvarez.oreplay.ui.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.TextStyle
import com.diegopalvarez.oreplay.domain.model.ResultClass
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.no_class
import org.jetbrains.compose.resources.stringResource

@Composable
fun RunnerClassFormatter(
    runnerClass: ResultClass?,
    style: TextStyle = MaterialTheme.typography.labelSmall
){
    if(runnerClass != null){
        Text(
            text = runnerClass.shortName,
            style = style,
        )
    }
    else{
        Text(
            text = stringResource(Res.string.no_class),
            style = style
        )
    }
}