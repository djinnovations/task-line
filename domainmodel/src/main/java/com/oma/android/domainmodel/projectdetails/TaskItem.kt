package com.oma.android.domainmodel.projectdetails

import android.os.Parcelable
import com.oma.android.domainmodel.Status
import com.oma.android.projecttask.data.TaskDTO
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Parcelize
data class TaskItem(
    val id: Long,
    val title: String,
    val description: String,
    val dueDate: Long,
    val storyPoints: Int,
    val assignedTo: String,
    val status: Status = Status.Todo
) : Parcelable {
    fun getFormattedDueDate(): String {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormat.format(Date(dueDate))
    }
}

fun List<TaskDTO>.toTaskList() = this.map {
    it.toTask()
}

fun TaskDTO.toTask() = TaskItem(
    id,
    title,
    description,
    dueDate,
    storyPoints,
    assignedTo,
    status = Status.valueOf(status)
)

fun TaskItem.toTaskDto(projectId: Long) = TaskDTO(
    id,
    projectId,
    title,
    description,
    dueDate,
    storyPoints,
    assignedTo,
    status.name
)