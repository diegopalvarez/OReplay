package com.diegopalvarez.oreplay.ui.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextOverflow
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.generic_stage
import org.jetbrains.compose.resources.stringResource

@Composable
fun SmallAppBarTitle(title: String, subtitle: String?) {
    if(title.isNotBlank()){
        Text(
            text = title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleLarge,
        )
    }
    else if (subtitle != null) {
        Text(
            text = subtitle,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleLarge,
        )
    }
    else{
        Text(
            text = stringResource(Res.string.generic_stage),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}