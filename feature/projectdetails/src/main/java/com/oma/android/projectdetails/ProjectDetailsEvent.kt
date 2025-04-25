package com.oma.android.projectdetails

import com.oma.android.domainmodel.projectdetails.TaskItem

sealed class ProjectDetailsEvent {
    data class UpdateTaskItem(val taskItem: TaskItem) : ProjectDetailsEvent()
}