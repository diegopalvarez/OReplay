package com.diegopalvarez.oreplay.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.load_next_page
import oreplay.shared.generated.resources.next_page
import oreplay.shared.generated.resources.next_page_icon
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun NextPageButton(
    loadFunction: () -> Unit,
    isNextPageLoading: State<Boolean>,
) {
    FilledTonalButton(
        onClick = { loadFunction() }
    ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(space = 6.dp, alignment = Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(Res.string.load_next_page),
            )

            if(isNextPageLoading.value){

                CircularProgressIndicator(
                    modifier = Modifier
                        .size(20.dp),
                    strokeWidth = 2.dp
                )
            }
            else{
                Icon(
                    painter = painterResource(Res.drawable.next_page),
                    contentDescription = stringResource(Res.string.next_page_icon),
                )
            }
        }
    }
}