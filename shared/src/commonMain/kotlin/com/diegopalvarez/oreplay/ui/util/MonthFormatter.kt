package com.diegopalvarez.oreplay.ui.util

import kotlinx.datetime.Month
import oreplay.shared.generated.resources.Res
import oreplay.shared.generated.resources.april
import oreplay.shared.generated.resources.august
import oreplay.shared.generated.resources.december
import oreplay.shared.generated.resources.february
import oreplay.shared.generated.resources.january
import oreplay.shared.generated.resources.july
import oreplay.shared.generated.resources.june
import oreplay.shared.generated.resources.march
import oreplay.shared.generated.resources.may
import oreplay.shared.generated.resources.november
import oreplay.shared.generated.resources.october
import oreplay.shared.generated.resources.september
import org.jetbrains.compose.resources.StringResource

fun Month.display(): StringResource {
    return when(this){
        Month.JANUARY -> Res.string.january
        Month.FEBRUARY -> Res.string.february
        Month.MARCH -> Res.string.march
        Month.APRIL -> Res.string.april
        Month.MAY -> Res.string.may
        Month.JUNE -> Res.string.june
        Month.JULY -> Res.string.july
        Month.AUGUST -> Res.string.august
        Month.SEPTEMBER -> Res.string.september
        Month.OCTOBER -> Res.string.october
        Month.NOVEMBER -> Res.string.november
        Month.DECEMBER -> Res.string.december
    }
}