package com.oma.android.roomdb.timesheet

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TimesheetDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTimesheet(timesheet: TimesheetEntity)

    @Query("SELECT * FROM timesheets")
    suspend fun getAllTimesheets(): List<TimesheetEntity>
}