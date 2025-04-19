package com.oma.android.composeui.gradient

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.oma.android.composeui.theme.generateRandomColors
import kotlin.random.Random

@Composable
fun RandomGradientBox() {
    // Two sets of colors to interpolate between
    val currentColors = remember { mutableStateOf(generateRandomColors()) }
    val targetColors = remember { mutableStateOf(generateRandomColors()) }

    // Animation state
    val infiniteTransition = rememberInfiniteTransition()
    val progress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 7000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    // Interpolated colors
    val interpolatedColors = remember(progress, currentColors.value, targetColors.value) {
        currentColors.value.mapIndexed { index, color ->
            lerpColor(color, targetColors.value[index], progress)
        }
    }

    // Animate the center position using two separate float animations
    val centerX by infiniteTransition.animateFloat(
        initialValue = 0.3f + Random.nextFloat() * 0.4f,
        targetValue = 0.3f + Random.nextFloat() * 0.4f,
        animationSpec = infiniteRepeatable(
            animation = tween(7000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val centerY by infiniteTransition.animateFloat(
        initialValue = 0.3f + Random.nextFloat() * 0.4f,
        targetValue = 0.3f + Random.nextFloat() * 0.4f,
        animationSpec = infiniteRepeatable(
            animation = tween(7000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val center = remember(centerX, centerY) {
        Offset(centerX, centerY)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.sweepGradient(
                    colors = interpolatedColors,
                    center = center
                )
            )
    )
}

private fun lerpColor(start: Color, end: Color, fraction: Float): Color {
    return Color(
        red = lerp(start.red, end.red, fraction),
        green = lerp(start.green, end.green, fraction),
        blue = lerp(start.blue, end.blue, fraction),
        alpha = 1f
    )
}

private fun lerp(a: Float, b: Float, t: Float): Float {
    return a + (b - a) * t
}