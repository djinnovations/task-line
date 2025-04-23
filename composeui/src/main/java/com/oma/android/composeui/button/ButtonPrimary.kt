package com.oma.android.composeui.button

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oma.android.composeui.theme.Primary

@Composable
fun ButtonPrimary(modifier: Modifier, text: String, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Primary),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}