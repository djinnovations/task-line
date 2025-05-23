package com.oma.android.dashboard.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRight
import androidx.compose.material.icons.filled.Architecture
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
fun ProjectFieldTimesheet(modifier: Modifier, optionList: ImmutableList<String>, onProjectChanged: (String) -> Unit) {

    var projectSelected by remember { mutableStateOf(optionList[0]) }
    var projectSelectionRequest by remember { mutableStateOf(false) }
    // Choose Project Field (opens modal)
    Row(
        modifier = modifier
            .clickable {
                projectSelectionRequest = !projectSelectionRequest
            },
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            Icons.Default.Architecture, contentDescription = "Project",
            tint = Themer.colors.Black100
        )
        Text(
            "Project: ",
            style = MaterialTheme.typography.labelMedium,
            color = Themer.colors.TextAlternate
        )
        Text(
            text = projectSelected,
            style = MaterialTheme.typography.labelMedium,
            color = Themer.colors.TextAlternate
        )
        Spacer(Modifier.weight(1f, true))
        Icon(
            Icons.AutoMirrored.Default.ArrowRight, contentDescription = "Project",
            tint = Themer.colors.Black100
        )
    }

    if (projectSelectionRequest) {
        RadioGroupBottomSheet(
            title = "Select Project",
            presetStatus = optionList[0],
            options = optionList,
            onDismissRequest = { projectSelectionRequest = false }
        ) {
            projectSelectionRequest = false
            projectSelected = it
            onProjectChanged.invoke(it)
        }
    }
}