package com.oma.android.projecttask.data.repo

import com.oma.android.projecttask.data.ProjectWithTaskDTO
import com.oma.android.projecttask.data.TaskDTO
import kotlinx.coroutines.flow.Flow

interface ProjectTaskRepo {
    suspend fun getAllProjectsWithTask(): Flow<List<ProjectWithTaskDTO>>
    suspend fun getProjectWithTaskFlow(projectId: Long): Flow<ProjectWithTaskDTO>
    suspend fun updateTask(taskDTO: TaskDTO)
}