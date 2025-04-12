package com.oma.android.composeui.contentanim

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally

object NavAnimations {
    fun slideInFromRight() =
        run { slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(300)) }

    fun slideOutToLeft() =
        run { slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(300)) }

    fun slideInFromLeft() =
        run { slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(300)) }

    fun slideOutToRight() =
        run { slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(300)) }

    // Add more animation presets as needed
}