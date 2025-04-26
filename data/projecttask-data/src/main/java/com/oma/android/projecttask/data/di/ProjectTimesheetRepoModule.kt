package com.oma.android.projecttask.data.di

import com.oma.android.projecttask.data.repo.ProjectTaskRepo
import com.oma.android.projecttask.data.repo.ProjectTaskRepoImpl
import com.oma.android.projecttask.data.repo.TimesheetRepo
import com.oma.android.projecttask.data.repo.TimesheetRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProjectTimesheetRepoModule {
    @Binds
    @Singleton
    abstract fun bindsProjectRepo(projectTaskRepoImpl: ProjectTaskRepoImpl): ProjectTaskRepo

    @Binds
    @Singleton
    abstract fun bindsTimesheetRepo(timesheetRepoImpl: TimesheetRepoImpl): TimesheetRepo
}