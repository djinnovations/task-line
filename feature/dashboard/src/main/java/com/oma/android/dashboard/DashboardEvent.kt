package com.oma.android.dashboard

import com.oma.android.domainmodel.projectdetails.ProjectItem
import com.oma.android.domainmodel.projectdetails.TaskItem
import com.oma.android.domainmodel.timesheet.TimesheetData

internal sealed class DashboardEvent {
    data object FetchProjects : DashboardEvent()
    data object FetchTimesheetOptions: DashboardEvent()
    data class ProjectItemClick(val project: ProjectItem): DashboardEvent()
    data class TaskItemClick(val task: TaskItem): DashboardEvent()
    data class SubmitTimesheet(val timesheetData: TimesheetData) : DashboardEvent()
    data class NotifyMessage(val message: String): DashboardEvent()
}