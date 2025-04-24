package com.oma.android.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oma.android.roomdb.login.User
import com.oma.android.roomdb.login.UserDao
import com.oma.android.roomdb.projectdetails.ProjectDao
import com.oma.android.roomdb.projectdetails.ProjectEntity
import com.oma.android.roomdb.projectdetails.TaskDao
import com.oma.android.roomdb.projectdetails.TaskEntity
import com.oma.android.roomdb.timesheet.TimesheetDao
import com.oma.android.roomdb.timesheet.TimesheetEntity

@Database(entities = [User::class, ProjectEntity::class, TaskEntity::class, TimesheetEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun projectDao(): ProjectDao
    abstract fun taskDao(): TaskDao
    abstract fun timesheetDao(): TimesheetDao
}