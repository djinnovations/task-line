package com.oma.android.projecttask.data

import com.oma.android.roomdb.projectdetails.ProjectEntity
import com.oma.android.roomdb.projectdetails.ProjectWithTasks
import com.oma.android.roomdb.projectdetails.TaskEntity
import com.oma.android.roomdb.timesheet.TimesheetEntity

fun List<ProjectWithTasks>.toProjectWithTaskDto() = this.map {
    it.toProjectWithTaskDto()
}

// ProjectWithTasks -> ProjectWithTaskDTO
fun ProjectWithTasks.toProjectWithTaskDto() = ProjectWithTaskDTO(
    id = project.id,
    title = project.title,
    description = project.description,
    dueDate = project.dueDate,
    tasks = tasks.map { it.toTaskDto() }
)

fun List<ProjectEntity>.toProjectListDto() = this.map {
    it.toProjectDto()
}

// ProjectEntity -> ProjectDTO
fun ProjectEntity.toProjectDto() = ProjectDTO(
    id = id,
    title = title,
    description = description,
    dueDate = dueDate
)

fun List<TaskEntity>.toTaskListDto() = this.map {
    it.toTaskDto()
}

// TaskEntity -> TaskDTO
fun TaskEntity.toTaskDto() = TaskDTO(
    id = id,
    projectId = projectId,
    title = title,
    description = description,
    dueDate = dueDate,
    storyPoints = storyPoints,
    assignedTo = assignedTo,
    status = status
)

// TaskDTO -> TaskEntity
fun TaskDTO.toTaskEntity() = TaskEntity(
    id = id,
    projectId = projectId,
    title = title,
    description = description,
    dueDate = dueDate,
    storyPoints = storyPoints,
    assignedTo = assignedTo,
    status = status
)

fun TimesheetEntity.toTimeSheetDto() = TimesheetDTO(
    projectName = projectName,
    taskName = taskName,
    date = date,
    startTime = startTime,
    endTime = endTime,
    duration = duration,
    comment = comment
)

fun TimesheetDTO.toTimesheetEntity() = TimesheetEntity(
    projectName = projectName,
    taskName = taskName,
    date = date,
    startTime = startTime,
    endTime = endTime,
    duration = duration,
    comment = comment
)

fun List<TimesheetEntity>.toTimesheetDtoList() = this.map {
    it.toTimeSheetDto()
}