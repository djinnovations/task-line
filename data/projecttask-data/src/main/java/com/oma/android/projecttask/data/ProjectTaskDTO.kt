package com.oma.android.projecttask.data

data class ProjectWithTaskDTO(
    val id: Long,
    val title: String,
    val description: String,
    val dueDate: Long,
    val tasks: List<TaskDTO> = emptyList()
)

data class ProjectDTO(
    val id: Long,
    val title: String,
    val description: String,
    val dueDate: Long
)

data class TaskDTO(
    val id: Long,
    val projectId: Long,
    val title: String,
    val description: String,
    val dueDate: Long,
    val storyPoints: Int,
    val assignedTo: String,
    val status: String
)