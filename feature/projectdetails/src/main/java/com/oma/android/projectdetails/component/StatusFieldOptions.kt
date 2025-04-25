package com.oma.android.projectdetails.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRight
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.bottomsheet.RadioGroupBottomSheet
import com.oma.android.composeui.theme.Themer
import kotlinx.collections.immutable.ImmutableList

@Composable
fun StatusFieldOptions(
    modifier: Modifier,
    presetStatus: String,
    optionList: ImmutableList<String>,
    onItemChanged: (String) -> Unit
) {
    var itemSelected by remember { mutableStateOf(presetStatus) }
    var itemSelectionRequest by remember { mutableStateOf(false) }
    Row(
        modifier = modifier
            .clickable {
                itemSelectionRequest = !itemSelectionRequest
            },
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            Icons.Filled.CheckBox, contentDescription = "Status",
            tint = Themer.colors.Black100
        )
        Text(
            "Status: ",
            style = MaterialTheme.typography.labelMedium,
            color = Themer.colors.TextAlternate
        )
        Text(
            text = itemSelected,
            style = MaterialTheme.typography.labelMedium,
            color = Themer.colors.TextAlternate
        )
        Spacer(Modifier.weight(1f, true))
        Icon(
            Icons.AutoMirrored.Default.ArrowRight, contentDescription = "Status",
            tint = Themer.colors.Black100
        )
    }

    if (itemSelectionRequest) {
        RadioGroupBottomSheet(
            title = "Update Status",
            presetStatus = presetStatus,
            options = optionList,
            onDismissRequest = { itemSelectionRequest = false }
        ) {
            itemSelectionRequest = false
            itemSelected = it
            onItemChanged.invoke(it)
        }
    }
}