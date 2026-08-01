package com.diegopalvarez.oreplay.app.navigation

// A Sealed Interface is an interface whose direct implementations are known at compile time
sealed interface ScreenAEvent {
    data object ClickButtonA: ScreenAEvent
    data class UpdateText(val text: String): ScreenAEvent
}