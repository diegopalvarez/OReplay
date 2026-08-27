package com.diegopalvarez.oreplay.feature.results.common.types.startTimes

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.diegopalvarez.oreplay.domain.model.Event
import com.diegopalvarez.oreplay.domain.model.Result
import kotlinx.datetime.TimeZone

class StartTimesComponent(
    componentContext: ComponentContext,
    val results: Value<List<Result>>,
    private val event: Event,
    private val isClubView: Boolean
): ComponentContext by componentContext {

    // Function to get the event timezone
    fun getEventTimezone(): TimeZone {
        return event.timezone
    }

    // Function to get if this screen is a club or class view
    fun isClubView(): Boolean {
        return isClubView
    }
}