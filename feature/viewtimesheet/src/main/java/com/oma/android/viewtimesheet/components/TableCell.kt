package com.oma.android.viewtimesheet.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.theme.Themer

@Composable
fun TableCell(text: String, width: Dp = dimensionResource(com.intuit.sdp.R.dimen._100sdp)) {
    Text(
        text = text,
        modifier = Modifier
            .width(width)
            .padding(horizontal = 4.dp),
        overflow = TextOverflow.Visible,
        style = MaterialTheme.typography.bodySmall,
        color = Themer.colors.TextAlternate
    )
}