package com.oma.android.dashboard

import com.oma.android.domainmodel.projectdetails.ProjectItem
import com.oma.android.domainmodel.projectdetails.TaskItem

internal sealed class DashboardEvent {
    data object FetchProjects : DashboardEvent()
    data class ProjectItemClick(val project: ProjectItem): DashboardEvent()
    data class TaskItemClick(val task: TaskItem): DashboardEvent()
}