package com.oma.android.roomdb.projectdetails

import androidx.room.Embedded
import androidx.room.Relation

data class ProjectWithTasks(
    @Embedded val project: ProjectEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "projectId"
    )
    val tasks: List<TaskEntity>
)
