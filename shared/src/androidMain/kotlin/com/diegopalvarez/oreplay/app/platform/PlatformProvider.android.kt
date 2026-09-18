package com.diegopalvarez.oreplay.app.platform

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private val platform = MutableStateFlow(Platform.ANDROID)

actual fun getPlatform(): StateFlow<Platform> {
    return platform
}