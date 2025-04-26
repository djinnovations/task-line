package com.oma.android.projecttask.data.repo

import androidx.paging.PagingData
import com.oma.android.projecttask.data.TimesheetDTO
import kotlinx.coroutines.flow.Flow

interface TimesheetRepo {
    suspend fun submitTimesheet(timesheetDTO: TimesheetDTO)
    fun getTimesheetsPaged(): Flow<PagingData<TimesheetDTO>>
}