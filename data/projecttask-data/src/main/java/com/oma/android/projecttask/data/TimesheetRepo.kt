package com.oma.android.projecttask.data

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.oma.android.roomdb.timesheet.TimesheetDao
import com.oma.android.roomdb.timesheet.TimesheetEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimesheetRepo @Inject constructor(
    private val timesheetDao: TimesheetDao
) {
    suspend fun getAllRecords() = withContext(Dispatchers.IO) {
        timesheetDao.getAllTimesheets().toTimesheetListDto()
    }

    suspend fun submitTimesheet(timesheetDTO: TimesheetDTO) = withContext(Dispatchers.IO) {
        timesheetDao.insertTimesheet(timesheetDTO.toTimesheetEntity())
    }

    fun getTimesheetsPaged(): Flow<PagingData<TimesheetDTO>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                val result = timesheetDao.getPagedTimesheets()
                Log.d("TAG", "getTimesheetsPaged: "+result.toString())
                result
            }
        ).flow
            .map { pagingData: PagingData<TimesheetEntity> ->
                pagingData.map { entity ->
                    Log.d("TAG", "getTimesheetsPaged: "+entity.toString())
                    entity.toTimeSheetDto()
                }
            }
    }
}