package com.oma.android.dashboard.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRight
import androidx.compose.material.icons.filled.Task
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
fun TaskFieldTimesheet(modifier: Modifier, optionList: ImmutableList<String>, onTaskChanged: (String) -> Unit) {

    var taskSelected by remember { mutableStateOf(optionList[0]) }
    LaunchedEffect(optionList) {
        taskSelected = optionList[0]
        onTaskChanged(taskSelected)
    }
    var taskSelectionRequest by remember { mutableStateOf(false) }
    Row(
        modifier = modifier
            .clickable {
                taskSelectionRequest = !taskSelectionRequest
            },
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            Icons.Filled.Task, contentDescription = "Task",
            tint = Themer.colors.Black100
        )
        Text(
            "Task: ",
            style = MaterialTheme.typography.labelMedium,
            color = Themer.colors.TextAlternate
        )
        Text(
            text = taskSelected,
            style = MaterialTheme.typography.labelMedium,
            color = Themer.colors.TextAlternate
        )
        Spacer(Modifier.weight(1f, true))
        Icon(
            Icons.AutoMirrored.Default.ArrowRight, contentDescription = "Task",
            tint = Themer.colors.Black100
        )
    }

    if (taskSelectionRequest) {
        RadioGroupBottomSheet(
            title = "Select Task",
            presetStatus = optionList[0],
            options = optionList,
            onDismissRequest = { taskSelectionRequest = false }
        ) {
            taskSelectionRequest = false
            taskSelected = it
            onTaskChanged.invoke(it)
        }
    }
}