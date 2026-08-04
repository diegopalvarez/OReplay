package com.diegopalvarez.oreplay.feature.events.screens.liveEvents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.diegopalvarez.oreplay.core.util.RepositoryError
import kotlinx.datetime.format.Padding
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.app_error
import oreplay.shared.generated.resources.error
import oreplay.shared.generated.resources.icon_app_error
import oreplay.shared.generated.resources.icon_error
import oreplay.shared.generated.resources.icon_network_error
import oreplay.shared.generated.resources.icon_server_error
import oreplay.shared.generated.resources.message_error
import oreplay.shared.generated.resources.message_internal_error
import oreplay.shared.generated.resources.message_network_error
import oreplay.shared.generated.resources.message_server_error
import oreplay.shared.generated.resources.network_error
import oreplay.shared.generated.resources.server_error
import oreplay.shared.generated.resources.snackbar_app_error
import oreplay.shared.generated.resources.snackbar_internal_error
import oreplay.shared.generated.resources.snackbar_network_error
import oreplay.shared.generated.resources.snackbar_server_error
import oreplay.shared.generated.resources.snackbar_unknown_error
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ErrorHelper(
    errorType: RepositoryError
){
    val iconModifier = Modifier
        .width(100.dp)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            when (errorType) {
                RepositoryError.NETWORK -> {
                    Image(
                        painter = painterResource(Res.drawable.network_error),
                        contentDescription = stringResource(Res.string.icon_network_error),
                        modifier = iconModifier,
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = stringResource(Res.string.message_network_error),
                        textAlign = TextAlign.Center,
                    )
                }

                RepositoryError.INTERNAL -> {
                    Image(
                        painter = painterResource(Res.drawable.app_error),
                        contentDescription = stringResource(Res.string.icon_app_error),
                        modifier = iconModifier,
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = stringResource(Res.string.message_internal_error),
                        textAlign = TextAlign.Center,
                    )
                }

                RepositoryError.SERVER -> {
                    Image(
                        painter = painterResource(Res.drawable.server_error),
                        contentDescription = stringResource(Res.string.icon_server_error),
                        modifier = iconModifier,
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = stringResource(Res.string.message_server_error),
                        textAlign = TextAlign.Center,
                    )
                }

                RepositoryError.NOT_IMPLEMENTED -> {
                    Image(
                        painter = painterResource(Res.drawable.app_error),
                        contentDescription = stringResource(Res.string.icon_app_error),
                        modifier = iconModifier,
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = stringResource(Res.string.message_internal_error),
                        textAlign = TextAlign.Center,
                    )
                }

                RepositoryError.UNKNOWN -> {
                    Image(
                        painter = painterResource(Res.drawable.error),
                        contentDescription = stringResource(Res.string.icon_error),
                        modifier = iconModifier,
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = stringResource(Res.string.message_error),
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}