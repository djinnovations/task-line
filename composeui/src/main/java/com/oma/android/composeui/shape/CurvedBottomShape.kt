package com.oma.android.composeui.shape

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class CurvedBottomShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(0f, height * 0.85f)

            cubicTo(
                width * 0.3f, height * 1.05f,   // First control: dip near start
                width * 0.7f, height * 0.65f,    // Second control: mid climb
                x3 = width, height * 0.65f             // End with slight dip at the right edge
            )

            lineTo(width, 0f)
            close()
        }

        return Outline.Generic(path)
    }
}