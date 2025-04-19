package com.oma.android.composeui.chip

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.theme.Secondary

@Composable
fun OutlinedChip(text: String, color: Color = Secondary) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = color,
                shape = RoundedCornerShape(50) // Fully rounded
            )
            .padding(horizontal = 12.dp, vertical = 4.dp) // Inner padding
    ) {
        Text(
            text = text,
            color = color,
            style = MaterialTheme.typography.labelMedium
        )
    }
}