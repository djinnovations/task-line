package com.oma.android.composeui.text

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.theme.Themer

@Composable
fun CenteredTextWithLines(modifier: Modifier, text: String) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.padding(horizontal = 1.dp),
            text = text,
            style = MaterialTheme.typography.labelLarge,
            color = Themer.colors.Boulder
        )
        HorizontalDivider(modifier = Modifier.weight(1f))
    }
}