package com.oma.android.projectdetails.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.backarrow.CircularBackButton
import com.oma.android.composeui.gradient.RandomGradientBox
import com.oma.android.domainmodel.Status
import com.oma.android.domainmodel.projectdetails.ProjectItem
import com.oma.android.projectdetails.component.ProjectDetailsTopSection
import com.oma.android.projectdetails.component.TaskCategoryLazyRow

@Composable
fun ProjectScreen(
    scaffoldPadding: PaddingValues,
    projectItem: ProjectItem,
    onBack: () -> Unit = {},
) {
    // Group tasks by their status for efficient filtering
    val tasksByStatus = remember { projectItem.taskItems.groupBy { it.status } }
    val completedTask = remember { tasksByStatus[Status.Done]?.size ?: 0 }
    val totalTasks = remember { projectItem.taskItems.count() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Top Section
        Box(modifier = Modifier.fillMaxHeight(0.35f)) {
            RandomGradientBox()
            CircularBackButton(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(
                        top = dimensionResource(com.intuit.sdp.R.dimen._40sdp),
                        start = dimensionResource(com.intuit.sdp.R.dimen._16sdp)
                    ),
                onBack = onBack
            )
            ProjectDetailsTopSection(projectItem, completedTask, totalTasks)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Task Columns Row
        TaskCategoryLazyRow(scaffoldPadding, tasksByStatus)
    }
}
