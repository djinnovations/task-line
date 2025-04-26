package com.oma.android.projecttask.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.oma.android.projecttask.data.TimesheetDTO
import com.oma.android.projecttask.data.toTimeSheetDto
import com.oma.android.projecttask.data.toTimesheetEntity
import com.oma.android.roomdb.timesheet.TimesheetDao
import com.oma.android.roomdb.timesheet.TimesheetEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimesheetRepoImpl @Inject constructor(
    private val timesheetDao: TimesheetDao
) : TimesheetRepo {
    override suspend fun submitTimesheet(timesheetDTO: TimesheetDTO) = withContext(Dispatchers.IO) {
        timesheetDao.insertTimesheet(timesheetDTO.toTimesheetEntity())
    }

    override fun getTimesheetsPaged(): Flow<PagingData<TimesheetDTO>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                val result = timesheetDao.getPagedTimesheets()
                result
            }
        ).flow
            .map { pagingData: PagingData<TimesheetEntity> ->
                pagingData.map { entity ->
                    entity.toTimeSheetDto()
                }
            }
    }
}