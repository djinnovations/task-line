package com.oma.android.roomdb.timesheet

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "timesheets")
data class TimesheetEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val projectName: String,
    val taskName: String,
    val date: String,
    val startTime: String,
    val endTime: String,
    val comment: String
)