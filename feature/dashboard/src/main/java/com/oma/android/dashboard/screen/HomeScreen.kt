package com.oma.android.dashboard.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.button.ButtonPrimary
import com.oma.android.composeui.header.PrimaryHeader
import com.oma.android.dashboard.screen.uistatemodel.HomeScreenUiState
import com.oma.android.dashboard.component.HomeScreenTaskItem
import com.oma.android.dashboard.component.ProjectCard
import com.oma.android.domainmodel.projectdetails.ProjectItem
import com.oma.android.domainmodel.projectdetails.TaskItem
import kotlinx.coroutines.flow.StateFlow

@Composable
fun HomeScreen(
    state: StateFlow<HomeScreenUiState>,
    seeAllProjects: () -> Unit = {},
    seeAllTask: () -> Unit = {},
    onViewTimesheet: () -> Unit,
    onTaskClicked: (TaskItem?) -> Unit = {},
    onProjectClicked: (ProjectItem) -> Unit,
) {
    val homeScreenData = state.collectAsState().value
    if (homeScreenData.projectList.isEmpty()) return

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
                items(homeScreenData.projectList) { project ->
                    Box(
                        modifier = Modifier.clickable { onProjectClicked.invoke(project) },
                        contentAlignment = Alignment.Center
                    ) {
                        ProjectCard(title = project.title, project.description)
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
        items(homeScreenData.projectList[0].taskItems.toList().take(5)) { task ->
            HomeScreenTaskItem(task)
        }

        item {
            ButtonPrimary(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp), text = "View Timesheet"
            ) {
                onViewTimesheet()
            }
        }
    }
}