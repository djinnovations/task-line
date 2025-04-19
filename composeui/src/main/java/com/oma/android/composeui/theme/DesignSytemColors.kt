package com.oma.android.composeui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class DesignSystemColor(
    // Theme - Brand
    val Transparent: Color = Color(0x00FFFFFF),
    val BrandPrimary100: Color = Color.Unspecified,
    val BrandPrimary80: Color = Color.Unspecified,

    // Theme - Fill
    val FillPrimary100: Color = Color.Unspecified,
    val FillSecondary: Color = Color.Unspecified,
    val FillSecondary80: Color = Color.Unspecified,
    val FillTertiary: Color = Color.Unspecified,
    val FillQuaternary: Color = Color.Unspecified,

    // Indication
    val IndicationPrimary: Color = Color.Unspecified,
    val IndicationSecondary: Color = Color.Unspecified,

    // Theme - Text
    val TextPrimary: Color = Color.Unspecified,
    val TextSecondary: Color = Color.Unspecified,
    val TextTertiary: Color = Color.Unspecified,
    val TextAlternate: Color = Color.Unspecified,
    val TextBlack: Color = Color.Unspecified,
    val TextBrand: Color = Color.Unspecified,

    // Theme - Button
    val ButtonGray: Color = Color.Unspecified,
    val ButtonGrayLight: Color = Color.Unspecified,

    //  Border
    val PrimaryBorder: Color = Color.Unspecified,
    val SecondaryBorder:Color = Color.Unspecified,
    val TertiaryBorder:Color = Color.Unspecified,
    val QuaternaryBorder:Color = Color.Unspecified,
    val QuinaryBorder:Color = Color.Unspecified,

) : DesignSystemBaseColor() {
    companion object {
        val baseColor = DesignSystemBaseColor()
        val lightCustomColor = DesignSystemColor(
            BrandPrimary100 = baseColor.RoyalBlue,
            FillPrimary100 = baseColor.Lavender,
            FillSecondary = baseColor.AliceBlueDark,
            FillSecondary80 = baseColor.LilyWhite,
            FillTertiary = baseColor.SwissCoffee,
            FillQuaternary = baseColor.Onahau,
            TextPrimary = baseColor.LynxWhite,
            TextSecondary = baseColor.ChateauGreen,
            TextBlack = baseColor.Black,
            TextAlternate = baseColor.Black100,
            IndicationPrimary = baseColor.BlueTitmouse,
            IndicationSecondary = baseColor.Periwinkle.copy(0.5f),
            PrimaryBorder = baseColor.AshDust,
            SecondaryBorder = baseColor.Dugong,
            TertiaryBorder = baseColor.SuvaGrey,
            QuaternaryBorder = baseColor.Mercury,
            ButtonGray = baseColor.Whisper,
            ButtonGrayLight = baseColor.Boulder,
            QuinaryBorder = baseColor.SilverChalice
        )

        val darkCustomColor = DesignSystemColor(
            BrandPrimary100 = baseColor.RoyalBlue,
            FillPrimary100 = baseColor.Lavender,
            FillSecondary = baseColor.AliceBlueDark,
            FillSecondary80 = baseColor.LilyWhite,
            FillTertiary = baseColor.SwissCoffee,
            FillQuaternary = baseColor.Onahau,
            TextPrimary = baseColor.Black100,
            TextSecondary = baseColor.ChateauGreen,
            TextBlack = baseColor.Black,
            TextAlternate = baseColor.Black100,
            IndicationPrimary = baseColor.BlueTitmouse,
            IndicationSecondary = baseColor.Periwinkle.copy(0.5f),
            PrimaryBorder = baseColor.AshDust,
            SecondaryBorder = baseColor.Dugong,
            TertiaryBorder = baseColor.SuvaGrey,
            QuaternaryBorder = baseColor.Mercury,
            ButtonGray = baseColor.Whisper,
            ButtonGrayLight = baseColor.Boulder,
            QuinaryBorder = baseColor.SilverChalice
        )
    }
}