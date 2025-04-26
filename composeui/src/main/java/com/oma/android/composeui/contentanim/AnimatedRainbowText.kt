package com.oma.android.composeui.contentanim

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import com.oma.android.composeui.theme.Secondary
import com.oma.android.composeui.theme.Themer

@Composable
fun AnimatedRainbowText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.titleLarge
) {
    val infiniteTransition = rememberInfiniteTransition()
    val colorOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = LinearEasing)
        )
    )

    val rainbowColors = listOf(
        Color(0xFF4B0082),
        Themer.colors.Purple100,
        Secondary,
        Themer.colors.ChateauGreen,
    )

    val rainbowColors2 = listOf(
        Color.Red,
        Color.Cyan,
        Color.Magenta,
        Color.Blue,
        Color.Green,
        Color.Red
    )

    // Calculate the gradient positions based on the offset
    val density = LocalDensity.current
    val brush = remember(colorOffset, text, style) {
        val textWidth = with(density) { style.fontSize.toPx() } * text.length
        Brush.linearGradient(
            colors = rainbowColors,
            start = Offset(
                x = -textWidth * colorOffset * 2,
                y = 0f
            ),
            end = Offset(
                x = textWidth * (1 - colorOffset * 2),
                y = 0f
            ),
            tileMode = TileMode.Mirror
        )
    }

    Text(
        text = text,
        modifier = modifier,
        style = style.copy(brush = brush)
    )
}