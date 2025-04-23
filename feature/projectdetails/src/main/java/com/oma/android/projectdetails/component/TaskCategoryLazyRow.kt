package com.oma.android.projectdetails.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oma.android.domainmodel.Status
import com.oma.android.domainmodel.projectdetails.TaskItem
import kotlinx.collections.immutable.toPersistentList

@Composable
fun TaskCategoryLazyRow(
    scaffoldPadding: PaddingValues,
    tasksByStatus: Map<Status, List<TaskItem>>,
    onTaskItemClicked: (TaskItem) -> Unit
) {
    LazyRow(
        modifier = Modifier.padding(
            top = 10.dp,
            bottom = scaffoldPadding.calculateBottomPadding() + 6.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        // Iterate through all possible statuses to maintain order
        Status.entries.forEach { status ->
            val tasksForStatus = tasksByStatus[status] ?: emptyList()
            if (tasksForStatus.isNotEmpty()) {
                item {
                    TaskStatusColumn(
                        modifier = Modifier.width(300.dp),
                        status = status,
                        tasks = tasksForStatus.toPersistentList(),
                        onTaskItemClicked = onTaskItemClicked
                    )
                }
            }
        }
    }
}