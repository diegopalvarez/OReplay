package com.diegopalvarez.oreplay.app.platform

import kotlinx.coroutines.flow.StateFlow

expect fun getPlatform(): StateFlow<Platform>