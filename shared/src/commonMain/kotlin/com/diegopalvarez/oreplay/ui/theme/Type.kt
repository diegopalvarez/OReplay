package com.diegopalvarez.oreplay.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import oreplay.shared.generated.resources.Inter_Black
import oreplay.shared.generated.resources.Inter_BlackItalic
import oreplay.shared.generated.resources.Inter_Bold
import oreplay.shared.generated.resources.Inter_BoldItalic
import oreplay.shared.generated.resources.Inter_ExtraBold
import oreplay.shared.generated.resources.Inter_ExtraBoldItalic
import oreplay.shared.generated.resources.Inter_ExtraLight
import oreplay.shared.generated.resources.Inter_ExtraLightItalic
import oreplay.shared.generated.resources.Inter_Italic
import oreplay.shared.generated.resources.Inter_Light
import oreplay.shared.generated.resources.Inter_LightItalic
import oreplay.shared.generated.resources.Inter_Medium
import oreplay.shared.generated.resources.Inter_MediumItalic
import oreplay.shared.generated.resources.Inter_Regular
import oreplay.shared.generated.resources.Inter_Semibold
import oreplay.shared.generated.resources.Inter_SemiboldItalic
import oreplay.shared.generated.resources.Inter_Thin
import oreplay.shared.generated.resources.Inter_ThinItalic
import oreplay.shared.generated.resources.Res
import org.jetbrains.compose.resources.Font


val InterFontFamily @Composable get() = FontFamily(
    Font(
        resource = Res.font.Inter_Black,
        weight = FontWeight.Black,
    ),
    Font(
        resource = Res.font.Inter_BlackItalic,
        weight = FontWeight.Black,
        style = FontStyle.Italic
    ),
    Font(
        resource = Res.font.Inter_Bold,
        weight = FontWeight.Bold,
    ),Font(
        resource = Res.font.Inter_BoldItalic,
        weight = FontWeight.Bold,
        style = FontStyle.Italic
    ),
    Font(
        resource = Res.font.Inter_ExtraBold,
        weight = FontWeight.ExtraBold,
    ),
    Font(
        resource = Res.font.Inter_ExtraBoldItalic,
        weight = FontWeight.ExtraBold,
        style = FontStyle.Italic
    ),
    Font(
        resource = Res.font.Inter_ExtraLight,
        weight = FontWeight.ExtraLight,
    ),
    Font(
        resource = Res.font.Inter_ExtraLightItalic,
        weight = FontWeight.ExtraLight,
        style = FontStyle.Italic
    ),Font(
        resource = Res.font.Inter_Italic,
        style = FontStyle.Italic,
    ),Font(
        resource = Res.font.Inter_Light,
        weight = FontWeight.Light,
    ),Font(
        resource = Res.font.Inter_LightItalic,
        weight = FontWeight.Light,
        style = FontStyle.Italic
    ),
    Font(
        resource = Res.font.Inter_Medium,
        weight = FontWeight.Medium,
    ),
    Font(
        resource = Res.font.Inter_MediumItalic,
        weight = FontWeight.Medium,
        style = FontStyle.Italic
    ),
    Font(
        resource = Res.font.Inter_Regular,
        weight = FontWeight.Normal,
    ),
    Font(
        resource = Res.font.Inter_Semibold,
        weight = FontWeight.SemiBold,
    ),
    Font(
        resource = Res.font.Inter_SemiboldItalic,
        weight = FontWeight.SemiBold,
        style = FontStyle.Italic
    ),
    Font(
        resource = Res.font.Inter_Thin,
        weight = FontWeight.Thin,
    ),
    Font(
        resource = Res.font.Inter_ThinItalic,
        weight = FontWeight.Thin,
        style = FontStyle.Italic
    )
)

// Default Material 3 typography values
val baseline = Typography()

val AppTypography @Composable get() = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = InterFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = InterFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = InterFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = InterFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = InterFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = InterFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = InterFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = InterFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = InterFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = InterFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = InterFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = InterFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = InterFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = InterFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = InterFontFamily),
)

