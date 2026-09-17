package com.diegopalvarez.oreplay.app.platform

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

val platform = MutableStateFlow(Platform.WEB)

actual fun getPlatform(): StateFlow<Platform> {
    return platform
}
