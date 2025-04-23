package com.oma.android.composeui.shape

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class SawtoothBottomShape(
    private val toothCount: Int = 15,
    private val heightScale: Float = 0.05f
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val width = size.width
        val height = size.height
        val toothWidth = width / toothCount
        val toothHeight = height * heightScale

        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(0f, height - toothHeight)

            for (i in 0 until toothCount) {
                val x1 = i * toothWidth
                val x2 = x1 + toothWidth / 2
                val x3 = x1 + toothWidth

                lineTo(x2, height)
                lineTo(x3, height - toothHeight)
            }

            lineTo(width, 0f)
            close()
        }

        return Outline.Generic(path)
    }
}