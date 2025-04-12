package com.oma.android.composeui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

val LocalDesignSystemColors = staticCompositionLocalOf {
    DesignSystemColor()
}

//val LocalDesignSystemTypography = staticCompositionLocalOf {
//    Typography
//}


object Themer {
    val colors: DesignSystemColor
        @Composable get() = LocalDesignSystemColors.current

//    val typography: Typography
//        @Composable get() = LocalDesignSystemTypography.current
}