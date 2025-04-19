package com.oma.android.composeui.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.oma.android.composeui.theme.Themer

@Composable
fun PrimaryHeader(title: String, actionButtonText: String, actionButtonClick: () -> Unit) {
    // Recent Projects Header
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, style = MaterialTheme.typography.titleMedium, color = Themer.colors.TextAlternate)
        TextButton(onClick = actionButtonClick) {
            Text(
                actionButtonText,
                style = MaterialTheme.typography.labelMedium,
                color = Themer.colors.ChateauGreen
            )
        }
    }
}