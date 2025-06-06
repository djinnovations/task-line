package com.oma.android.composeui.theme

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

val Primary = Color(0xFF2F5233)
val Secondary = Color(0xFF498558)
val Background = Color(0xFF3FA15D)

val PrimaryDark = Color(0xFF2F5233)
val SecondaryDark = Color(0xFF498558)
val BackgroundDark = Color(0xFF3FA15D)

fun generateRandomColors(): List<Color> {
    return List(4) {
        Color.hsv(
            hue = Random.nextFloat() * 360,
            saturation = 0.7f + Random.nextFloat() * 0.3f,
            value = 0.7f + Random.nextFloat() * 0.3f
        )
    }
}