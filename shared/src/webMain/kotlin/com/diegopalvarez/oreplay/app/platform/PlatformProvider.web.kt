package com.diegopalvarez.oreplay.app.platform

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

actual fun getPlatform(): Platform {
    return Platform.WEB
}
