package com.oma.android.dashboard.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRight
import androidx.compose.material.icons.filled.Architecture
import androidx.compose.material.icons.filled.Task
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.theme.Secondary
import com.oma.android.composeui.theme.Themer
import com.oma.android.dashboard.component.DateSelector
import com.oma.android.dashboard.component.TimeSelector
import java.util.Calendar

@Composable
fun AddTimesheetScreen() {
    val projectSelected by remember { mutableStateOf("") }
    val taskSelected by remember { mutableStateOf("") }
    var (startHour, startMin) = remember {
        Calendar.getInstance().get(Calendar.HOUR_OF_DAY) to
                Calendar.getInstance().get(Calendar.MINUTE)
    }
    var (endHour, endMin) = remember {
        Calendar.getInstance().get(Calendar.HOUR_OF_DAY) to
                Calendar.getInstance().get(Calendar.MINUTE)
    }
    var selectedDate = remember { "" }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            var projectSelectionRequest by remember { mutableStateOf(false) }
            var taskSelectionRequest by remember { mutableStateOf(false) }

            // Solid strip on top
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .background(Secondary)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            )

            // Choose Project Field (opens modal)
            Row(
                modifier = Modifier
                    .clickable {
                        projectSelectionRequest = !projectSelectionRequest
                    }
                    .fillMaxWidth()
                    .background(color = Themer.colors.FillSecondary)
                    .padding(horizontal = 10.dp, vertical = 10.dp),
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

            // Choose Task Field (opens modal)
            Row(
                modifier = Modifier
                    .clickable {
                        taskSelectionRequest = !taskSelectionRequest
                    }
                    .fillMaxWidth()
                    .background(color = Themer.colors.FillSecondary)
                    .padding(horizontal = 10.dp, vertical = 10.dp),
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
                    Icons.AutoMirrored.Default.ArrowRight, contentDescription = "Project",
                    tint = Themer.colors.Black100
                )
            }

            // Date Field (opens modal)
            DateSelector(modifier = Modifier
                .fillMaxWidth()
                .background(color = Themer.colors.FillSecondary)
                .padding(horizontal = 10.dp, vertical = 10.dp),) {
                selectedDate = it
            }

            // Time Selector
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Start Time
                TimeSelector(Modifier, label = "Start Time", initialTime = startHour to startMin) {
                    startHour = it.first
                    startMin = it.second
                }

                // End Time
                TimeSelector(Modifier, label = "End Time", initialTime = endHour to endMin) {
                    endHour = it.first
                    endMin = it.second
                }
            }
        }
    }
}