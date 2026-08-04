package com.diegopalvarez.oreplay.feature.events.navigation

import com.diegopalvarez.oreplay.domain.model.Event

// A Sealed Interface is an interface whose direct implementations are known at compile time
sealed interface EventScreenEvent {
    data class ClickEvent(val selectedEvent: Event): EventScreenEvent

    data class ChangeLanguage(val languageCode: String): EventScreenEvent
}