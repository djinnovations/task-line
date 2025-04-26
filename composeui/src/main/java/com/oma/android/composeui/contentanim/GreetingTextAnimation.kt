package com.oma.android.composeui.contentanim

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GreetingAnimation(
    modifier: Modifier = Modifier,
    personName: String = "Name",
    delayMillis: Long = 3000
) {
    val currentGreeting = remember { mutableStateOf(0) }

    // Automatically toggle between greetings
    LaunchedEffect(Unit) {
        while (true) {
            delay(delayMillis)
            currentGreeting.value = (currentGreeting.value + 1) % 2
        }
    }

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        AnimatedContent(
            targetState = currentGreeting.value,
            transitionSpec = {
                // Slide in from top when entering, slide out to bottom when exiting
                slideInVertically { height -> -height } with
                        slideOutVertically { height -> height }
            },
            label = "Greeting Animation"
        ) { state ->
            val text = when (state) {
                0 -> "Hi $personName"
                else -> "Welcome \uD83D\uDE0A"
            }

            AnimatedRainbowText(text)
        }
    }
}