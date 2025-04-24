package com.oma.android.roomdb.di

import android.content.Context
import androidx.room.Room
import com.oma.android.roomdb.AppDatabase
import com.oma.android.roomdb.SampleDataExecutor
import com.oma.android.roomdb.login.UserDao
import com.oma.android.roomdb.projectdetails.ProjectDao
import com.oma.android.roomdb.projectdetails.TaskDao
import com.oma.android.roomdb.timesheet.TimesheetDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private const val APP_DB_NAME = "oma_pm_database_v2"

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            APP_DB_NAME
        ).fallbackToDestructiveMigration() // wipes & rebuilds DB on schema change
            .addCallback(SampleDataExecutor(context).roomCallback)
            .build()
    }

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    fun provideProjectDao(database: AppDatabase): ProjectDao {
        return database.projectDao()
    }

    @Provides
    fun provideTaskDao(database: AppDatabase): TaskDao {
        return database.taskDao()
    }

    @Provides
    fun provideTimesheetDao(database: AppDatabase): TimesheetDao {
        return database.timesheetDao()
    }
}