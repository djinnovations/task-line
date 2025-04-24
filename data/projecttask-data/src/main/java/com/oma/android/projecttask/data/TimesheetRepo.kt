package com.oma.android.projecttask.data

import com.oma.android.roomdb.timesheet.TimesheetDao
import com.oma.android.roomdb.timesheet.TimesheetEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimesheetRepo @Inject constructor(
    private val timesheetDao: TimesheetDao
) {
    suspend fun getAllRecords() = withContext(Dispatchers.IO) {
        timesheetDao.getAllTimesheets().toTimesheetDtoList()
    }

    suspend fun submitTimesheet(timesheetDTO: TimesheetDTO) = withContext(Dispatchers.IO) {
        timesheetDao.insertTimesheet(timesheetDTO.toTimesheetEntity())
    }
}