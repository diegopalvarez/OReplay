package com.diegopalvarez.oreplay.ui.util

import kotlinx.datetime.DayOfWeek
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.friday
import oreplay.shared.generated.resources.monday
import oreplay.shared.generated.resources.saturday
import oreplay.shared.generated.resources.sunday
import oreplay.shared.generated.resources.thursday
import oreplay.shared.generated.resources.tuesday
import oreplay.shared.generated.resources.wednesday
import org.jetbrains.compose.resources.StringResource

fun DayOfWeek.display(): StringResource {
    return when(this){
        DayOfWeek.MONDAY -> Res.string.monday
        DayOfWeek.TUESDAY -> Res.string.tuesday
        DayOfWeek.WEDNESDAY -> Res.string.wednesday
        DayOfWeek.THURSDAY -> Res.string.thursday
        DayOfWeek.FRIDAY -> Res.string.friday
        DayOfWeek.SATURDAY -> Res.string.saturday
        DayOfWeek.SUNDAY -> Res.string.sunday
    }
}