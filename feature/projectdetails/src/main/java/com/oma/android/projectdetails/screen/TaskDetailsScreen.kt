package com.oma.android.projectdetails.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssignmentInd
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Score
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
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
import com.oma.android.composeui.button.ButtonPrimary
import com.oma.android.composeui.datetimepicker.DateSelector
import com.oma.android.composeui.gradient.RandomGradientBox
import com.oma.android.composeui.shape.SawtoothBottomShape
import com.oma.android.composeui.textinputfield.RoundedInputField
import com.oma.android.composeui.theme.Themer
import com.oma.android.composeui.topbar.PrimaryTopBar
import com.oma.android.domainmodel.Status
import com.oma.android.domainmodel.projectdetails.TaskItem
import com.oma.android.projectdetails.component.StatusFieldOptions
import kotlinx.collections.immutable.toPersistentList
import java.util.Calendar

@Composable
fun TaskDetailsScreen(
    scaffoldPadding: PaddingValues,
    taskItem: TaskItem,
    onUpdateTask: (TaskItem) -> Unit,
    onBack: () -> Unit = {}
) {
    val description = remember { mutableStateOf(taskItem.description) }
    val assignedTo = remember { mutableStateOf(taskItem.assignedTo) }
    val storyPoints = remember { mutableStateOf(taskItem.storyPoints.toString()) }
    var selectedStatus by remember { mutableStateOf(taskItem.status.text) }
    var selectedDate by remember { mutableStateOf(0L) }

    val isFormValid by remember {
        derivedStateOf {
            description.value.isNotBlank() &&
                    assignedTo.value.isNotBlank() &&
                    storyPoints.value.isNotBlank() &&
                    (selectedDate != 0L) &&
                    selectedStatus.isNotBlank()
        }
    }

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
                minLines = 3,
                singleLine = false
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
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )

            // Status Field (opens modal)
            StatusFieldOptions(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Themer.colors.FillSecondary)
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                presetStatus = taskItem.status.name,
                optionList = Status.entries.map { it.name }.toPersistentList(),
            ) {
                selectedStatus = it
            }

            // Due Date Field (opens modal)
            DateSelector(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Themer.colors.FillSecondary)
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                hint = "Due Date: ",
                initialDate = Calendar.getInstance().apply { timeInMillis = taskItem.dueDate }
            ) { _, epochMillis ->
                selectedDate = epochMillis
            }

            // Story points
            RoundedInputField(
                value = storyPoints.value,
                onValueChange = { storyPoints.value = it },
                placeholder = "Story Points",
                icon = Icons.Default.Score,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )

            Spacer(Modifier.height(2.dp))

            ButtonPrimary(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp), text = "Update Task"
            ) {
                if (isFormValid) {
                    onUpdateTask(
                        taskItem.copy(
                            description = description.value,
                            assignedTo = assignedTo.value,
                            storyPoints = storyPoints.value.toInt(),
                            status = Status.valueOf(selectedStatus),
                            dueDate = selectedDate
                        )
                    )
                }
            }
        }
    }
}