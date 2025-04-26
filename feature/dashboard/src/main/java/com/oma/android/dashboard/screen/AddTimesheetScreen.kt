package com.oma.android.dashboard.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.button.ButtonPrimary
import com.oma.android.composeui.datetimepicker.DateSelector
import com.oma.android.composeui.datetimepicker.TimeSelector
import com.oma.android.composeui.text.CenteredTextWithLines
import com.oma.android.composeui.theme.Secondary
import com.oma.android.composeui.theme.Themer
import com.oma.android.dashboard.component.CommentFieldTimesheet
import com.oma.android.dashboard.component.ProjectFieldTimesheet
import com.oma.android.dashboard.component.TaskFieldTimesheet
import com.oma.android.dashboard.screen.uistatemodel.TimesheetUiState
import com.oma.android.domainmodel.timesheet.TimesheetData
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.StateFlow
import java.util.Calendar
import java.util.Locale
import java.util.concurrent.TimeUnit

@Composable
fun AddTimesheetScreen(
    timesheetUiState: StateFlow<TimesheetUiState>,
    notifyMessage: (String) -> Unit,
    onSubmit: (TimesheetData) -> Unit = {}
) {
    val projectTitleMap = timesheetUiState.collectAsState().value.projectTitleMap
    if (projectTitleMap.isEmpty()) return
    var (startHour, startMin) = remember {
        Calendar.getInstance().get(Calendar.HOUR_OF_DAY) to
                Calendar.getInstance().get(Calendar.MINUTE)
    }
    var (endHour, endMin) = remember {
        Calendar.getInstance().get(Calendar.HOUR_OF_DAY) to
                Calendar.getInstance().get(Calendar.MINUTE)
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(Modifier.height(12.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Fill Timesheet",
            style = MaterialTheme.typography.titleMedium,
            color = Themer.colors.TextAlternate,
            textAlign = TextAlign.Center
        )

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
                val projectTitles = remember { projectTitleMap.keys }
                var selectedProject by remember { mutableStateOf(projectTitles.first()) }
                var selectedTask by remember {
                    mutableStateOf(
                        projectTitleMap[selectedProject]?.toPersistentList()?.get(0)
                    )
                }
                var duration by remember { mutableStateOf("0:0") }
                var selectedDate by remember { mutableStateOf("") }
                var comments by remember { mutableStateOf("") }

                // Derived state that only changes when validation result changes
                val isFormValid by remember {
                    derivedStateOf {
                        selectedProject.isNotBlank() &&
                                selectedTask!!.isNotBlank() &&
                                duration.isNotBlank() &&
                                selectedDate.isNotBlank() &&
                                comments.isNotBlank()
                    }
                }

                // Solid strip on top
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .background(Secondary)
                        .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                )

                // Choose Project Field
                ProjectFieldTimesheet(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Themer.colors.FillSecondary)
                        .padding(horizontal = 10.dp, vertical = 10.dp),
                    optionList = projectTitles.toPersistentList(),
                ) {
                    selectedProject = it
                }

                // Choose Task Field (opens modal)
                TaskFieldTimesheet(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Themer.colors.FillSecondary)
                        .padding(horizontal = 10.dp, vertical = 10.dp),
                    optionList = projectTitleMap[selectedProject]?.toPersistentList()!!
                ) {
                    selectedTask = it
                }

                // Date Field (opens modal)
                DateSelector(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Themer.colors.FillSecondary)
                        .padding(horizontal = 10.dp, vertical = 10.dp),
                    hint = "What Date: "
                ) { formattedDate, _ ->
                    selectedDate = formattedDate
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
                    TimeSelector(
                        Modifier,
                        label = "Start Time",
                        initialTime = startHour to startMin
                    ) {
                        startHour = it.first
                        startMin = it.second

                        duration = getTimeDifference(startHour, startMin, endHour, endMin)
                    }

                    CenteredTextWithLines(modifier = Modifier.fillMaxWidth(0.4f), duration)

                    // End Time
                    TimeSelector(Modifier, label = "End Time", initialTime = endHour to endMin) {
                        endHour = it.first
                        endMin = it.second

                        duration = getTimeDifference(startHour, startMin, endHour, endMin)
                    }
                }

                // Comments
                CommentFieldTimesheet(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    comments = it
                }

                ButtonPrimary(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp), text = "Submit"
                ) {
                    if (isFormValid) {
                        onSubmit(
                            TimesheetData(
                                projectName = selectedProject,
                                taskName = selectedTask ?: "",
                                date = selectedDate,
                                startTime = String.format(
                                    Locale.getDefault(),
                                    "%02d:%02d",
                                    startHour,
                                    startMin
                                ),
                                endTime = String.format(
                                    Locale.getDefault(),
                                    "%02d:%02d",
                                    endHour,
                                    endMin
                                ),
                                duration = duration,
                                comment = comments
                            )
                        )
                    } else {
                        notifyMessage("Fill all fields")
                    }
                }
            }
        }
    }
}

private fun getTimeDifference(startHour: Int, startMin: Int, endHour: Int, endMin: Int): String {
    val start = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, startHour)
        set(Calendar.MINUTE, startMin)
    }
    val end = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, endHour)
        set(Calendar.MINUTE, endMin)
    }

    // Get the time in milliseconds for both calendars
    val startMillis = start.timeInMillis
    val endMillis = end.timeInMillis

    // Calculate the difference in milliseconds
    val diffMillis = endMillis - startMillis

    // Convert to hours and minutes
    val hours = TimeUnit.MILLISECONDS.toHours(diffMillis)
    val minutes = TimeUnit.MILLISECONDS.toMinutes(diffMillis) -
            TimeUnit.HOURS.toMinutes(hours)

    // Format as HH:MM
    return "%02d:%02d".format(hours, minutes)
}