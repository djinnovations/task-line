package com.oma.android.composeui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider


private val LightColorScheme = lightColorScheme(
    primary = Primary, secondary = Secondary, background = Background
)

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryDark, secondary = SecondaryDark, background = BackgroundDark
)

@Composable
fun TaskLineTheme(
    darkTheme: Boolean = /*isSystemInDarkTheme()*/ false, content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val customColorsPalette = when {
        darkTheme -> DesignSystemColor.darkCustomColor
        else -> DesignSystemColor.lightCustomColor
    }


    CompositionLocalProvider(
        LocalDesignSystemColors provides customColorsPalette,
//        LocalDesignSystemTypography provides DesignSystemTypography.mpLightDarkTypography
    ) {
        MaterialTheme(
            colorScheme = colorScheme, typography = Typography, content = content
        )
    }
}