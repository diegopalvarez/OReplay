package com.diegopalvarez.oreplay.app.platform

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

actual fun getPlatform(): Platform {
    return Platform.IOS
}