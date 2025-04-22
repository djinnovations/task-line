package com.oma.android.dashboard.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.header.PrimaryHeader
import com.oma.android.dashboard.component.ProjectCard
import com.oma.android.dashboard.component.HomeScreenTaskItem
import com.oma.android.domainmodel.projectdetails.ProjectItem
import com.oma.android.domainmodel.projectdetails.TaskItem

@Composable
fun HomeScreen(
    seeAllProjects: () -> Unit = {},
    seeAllTask: () -> Unit = {},
    onTaskClicked: (TaskItem?) -> Unit = {},
    onProjectClicked: (ProjectItem?) -> Unit,
) {
    val recentProjects = remember { listOf("Tiki Mobile App", "Banking App", "Ecom UI Kit") }
    val recentTasks = remember {
        listOf(
            "Kickoff Meeting",
            "Wireframe Review",
            "Client Feedback",
            "Fix Login Bug",
            "Design Polish"
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            PrimaryHeader("Recent Project", "See All") {
                seeAllProjects.invoke()
            }
        }

        item {
            // Recent Projects LazyRow
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(recentProjects.take(3)) { project ->
                    Box(
                        modifier = Modifier.clickable { onProjectClicked.invoke(null) },
                        contentAlignment = Alignment.Center
                    ) {
                        ProjectCard(title = project)
                    }
                }
            }
        }

        item {
            PrimaryHeader("Today Task", "See All") {
                seeAllTask.invoke()
            }
        }

        // Tasks or Features
        items(recentTasks.take(5)) { task ->
            HomeScreenTaskItem(task)
        }
    }
}