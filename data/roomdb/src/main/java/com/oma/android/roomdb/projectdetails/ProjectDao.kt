package com.oma.android.roomdb.projectdetails

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProject(project: ProjectEntity)

    @Query("SELECT * FROM projects")
    suspend fun getAllProjects(): List<ProjectEntity>

    @Transaction
    @Query("SELECT * FROM projects")
    fun getProjectsWithTasksListFlow(): Flow<List<ProjectWithTasks>>

    @Transaction
    @Query("SELECT * FROM projects WHERE id = :projectId")
    fun getProjectWithTasksFlow(projectId: Long): Flow<ProjectWithTasks>
}