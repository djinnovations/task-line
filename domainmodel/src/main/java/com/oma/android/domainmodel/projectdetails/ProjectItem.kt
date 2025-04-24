package com.oma.android.domainmodel.projectdetails

import com.oma.android.projecttask.data.ProjectDTO
import com.oma.android.projecttask.data.ProjectWithTaskDTO
import com.oma.android.projecttask.data.TaskDTO
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class ProjectItem(
    val id: Long,
    val title: String,
    val description: String,
    val dueDate: Long,
    val taskItems: Iterable<TaskItem>
) {
    fun getFormattedDueDate(): String {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormat.format(Date(dueDate))
    }
}

fun List<ProjectWithTaskDTO>.toProjectList() = this.map {
    it.toProject()
}

fun ProjectWithTaskDTO.toProject() = ProjectItem(
    id, title, description, dueDate, tasks.toTaskList()
)

fun ProjectDTO.toProject(taskList: List<TaskDTO>) = ProjectItem(
    id, title, description, dueDate, taskList.toTaskList()
)