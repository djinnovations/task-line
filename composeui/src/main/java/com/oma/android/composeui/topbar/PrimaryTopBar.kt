package com.oma.android.composeui.topbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.backarrow.CircularBackButton

@Composable
fun PrimaryTopBar(modifier: Modifier, title: String, onBack: () -> Unit) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularBackButton(modifier = Modifier, onBack = onBack)
        Text(
            title,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}