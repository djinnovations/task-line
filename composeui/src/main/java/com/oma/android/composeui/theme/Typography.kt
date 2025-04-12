package com.oma.android.composeui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.oma.android.composeui.R

// Set of Material typography styles to start with
val Typography: Typography
    @Composable
    get() {
        return Typography(
            titleLarge = TextStyle(
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                fontWeight = FontWeight(600),
                color = Themer.colors.TextPrimary,
            ),

            titleMedium = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                fontWeight = FontWeight(600),
                color = Themer.colors.TextPrimary,
            ),

            bodyMedium = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.be_vietnampro_medium)),
                fontWeight = FontWeight(600),
                color = Themer.colors.TextPrimary,
            ),

            bodySmall = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.be_vietnampro_medium)),
                fontWeight = FontWeight(400),
                color = Themer.colors.TextPrimary,
            ),

            labelLarge = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.be_vietnampro_medium)),
                fontWeight = FontWeight(200),
                color = Themer.colors.TextPrimary,
            ),

            labelMedium = TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.be_vietnampro_medium)),
                fontWeight = FontWeight(200),
                color = Themer.colors.TextPrimary,
            ),

            labelSmall = TextStyle(
                fontSize = 10.sp,
                lineHeight = 10.sp,
                fontFamily = FontFamily(Font(R.font.lato_regular)),
                fontWeight = FontWeight(200),
                color = Themer.colors.TextPrimary,
            ),
        )
    }