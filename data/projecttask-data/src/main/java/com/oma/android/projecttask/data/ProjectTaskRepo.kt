package com.oma.android.projecttask.data

import com.oma.android.roomdb.projectdetails.ProjectDao
import com.oma.android.roomdb.projectdetails.TaskDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProjectTaskRepo @Inject constructor(
    private val projectDao: ProjectDao,
    private val taskDao: TaskDao
) {
    suspend fun getAllProjects() = withContext(Dispatchers.IO) {
        projectDao.getAllProjects().toProjectListDto()
    }

    suspend fun getAllProjectsWithTask() = withContext(Dispatchers.IO) {
        projectDao.getProjectsWithTasks().toProjectWithTaskListDto()
    }

    suspend fun getTaskByProjectId(projectId: Long) = withContext(Dispatchers.IO) {
        taskDao.getTasksByProject(projectId).toTaskListDto()
    }

    suspend fun updateTask(taskDTO: TaskDTO) = withContext(Dispatchers.IO) {
        taskDao.updateTask(taskDTO.toTaskEntity())
    }

    suspend fun getProjectWithTaskFlow(projectId: Long) = withContext(Dispatchers.IO) {
        projectDao.getProjectWithTasksFlow(projectId).map {
            it.toProjectWithTaskDto()
        }
    }
}