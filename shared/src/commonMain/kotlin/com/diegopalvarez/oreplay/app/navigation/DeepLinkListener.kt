package com.diegopalvarez.oreplay.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect

@Composable
fun DeepLinkListener() {
    DisposableEffect(Unit){
        ExternalUriHandler.listener = { uri ->
            // Navigate to the URI received

        }

        // Correctly handle the component disposing
        onDispose {
            ExternalUriHandler.listener = null
        }
    }
}