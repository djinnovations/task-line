package com.oma.android.projecttask.data.repo

import com.oma.android.projecttask.data.TaskDTO
import com.oma.android.projecttask.data.toProjectWithTaskDto
import com.oma.android.projecttask.data.toProjectWithTaskListDto
import com.oma.android.projecttask.data.toTaskEntity
import com.oma.android.roomdb.projectdetails.ProjectDao
import com.oma.android.roomdb.projectdetails.TaskDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProjectTaskRepoImpl @Inject constructor(
    private val projectDao: ProjectDao,
    private val taskDao: TaskDao
) : ProjectTaskRepo {
    override suspend fun getAllProjectsWithTask() = withContext(Dispatchers.IO) {
        projectDao.getProjectsWithTasksListFlow()
            .map { it.toProjectWithTaskListDto() }
    }

    override suspend fun updateTask(taskDTO: TaskDTO) = withContext(Dispatchers.IO) {
        taskDao.updateTask(taskDTO.toTaskEntity())
    }

    override suspend fun getProjectWithTaskFlow(projectId: Long) = withContext(Dispatchers.IO) {
        projectDao.getProjectWithTasksFlow(projectId).map {
            it.toProjectWithTaskDto()
        }
    }
}