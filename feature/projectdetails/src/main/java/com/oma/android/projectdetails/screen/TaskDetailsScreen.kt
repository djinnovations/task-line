package com.oma.android.projectdetails.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssignmentInd
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Score
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.gradient.RandomGradientBox
import com.oma.android.composeui.shape.SawtoothBottomShape
import com.oma.android.composeui.textinputfield.RoundedInputField
import com.oma.android.composeui.theme.Themer
import com.oma.android.composeui.topbar.PrimaryTopBar
import com.oma.android.domainmodel.projectdetails.TaskItem

@Composable
fun TaskDetailsScreen(
    scaffoldPadding: PaddingValues,
    taskItem: TaskItem,
    onBack: () -> Unit = {}
) {
    val description = remember { mutableStateOf(taskItem.description) }
    val assignedTo = remember { mutableStateOf(taskItem.assignedTo) }
    val storyPoints = remember { mutableStateOf(taskItem.storyPoints.toString()) }
    var statusChangeRequest by remember { mutableStateOf(false) }
    var dueDateChangeRequest by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Top background with parallax-like curve
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.30f)
                .clip(SawtoothBottomShape())
        ) {
            RandomGradientBox()
            PrimaryTopBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopStart)
                    .padding(top = scaffoldPadding.calculateTopPadding() + 20.dp)
                    .padding(horizontal = 16.dp),
                taskItem.title,
                onBack = onBack
            )
            RoundedInputField(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(bottom = 20.dp)
                    .padding(horizontal = 16.dp),
                value = description.value,
                onValueChange = { description.value = it },
                placeholder = "Description",
                icon = Icons.Default.Description,
            )
        }

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(
                    top = 16.dp,
                    bottom = scaffoldPadding.calculateBottomPadding()
                )
                .padding(horizontal = dimensionResource(com.intuit.sdp.R.dimen._16sdp)),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            RoundedInputField(
                value = assignedTo.value,
                onValueChange = { assignedTo.value = it },
                placeholder = "Assigned To",
                icon = Icons.Filled.AssignmentInd,
            )
            // Status Field (opens modal)
            Row(
                modifier = Modifier
                    .clickable {
                        statusChangeRequest = !statusChangeRequest
                    }
                    .fillMaxWidth()
                    .background(color = Themer.colors.FillSecondary)
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    Icons.Filled.CheckBox, contentDescription = "Status",
                    tint = Themer.colors.ChateauGreen
                )
                Text(
                    "Status: ",
                    style = MaterialTheme.typography.labelMedium,
                    color = Themer.colors.TextAlternate
                )
                Text(
                    text = taskItem.status.text,
                    style = MaterialTheme.typography.labelMedium,
                    color = Themer.colors.TextAlternate
                )
            }
            // Due Date Field (opens modal)
            Row(modifier = Modifier
                .clickable {
                    dueDateChangeRequest = !dueDateChangeRequest
                }
                .fillMaxWidth()
                .background(color = Themer.colors.FillSecondary)
                .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Outlined.CalendarMonth,
                    contentDescription = "Due Date",
                    tint = Themer.colors.ChateauGreen
                )
                Text(
                    "Due Date: ", style = MaterialTheme.typography.labelMedium,
                    color = Themer.colors.TextAlternate
                )
                TextButton(onClick = { dueDateChangeRequest = !dueDateChangeRequest }) {
                    Text(
                        taskItem.getFormattedDueDate(),
                        style = MaterialTheme.typography.labelMedium,
                        color = Themer.colors.TextAlternate
                    )
                }
            }

            // Story points
            RoundedInputField(
                value = storyPoints.value,
                onValueChange = { storyPoints.value = it },
                placeholder = "Story Points",
                icon = Icons.Default.Score,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
        }
    }
}