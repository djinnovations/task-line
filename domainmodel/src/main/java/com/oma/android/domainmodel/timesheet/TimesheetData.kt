package com.oma.android.domainmodel.timesheet

import com.oma.android.projecttask.data.TimesheetDTO

data class TimesheetData(
    val projectName: String,
    val taskName: String,
    val date: String,
    val startTime: String,
    val endTime: String,
    val duration: String,
    val comment: String
)

fun TimesheetData.toTimesheetDto() = TimesheetDTO(
    projectName = projectName,
    taskName = taskName,
    date = date,
    startTime = startTime,
    endTime = endTime,
    duration = duration,
    comment = comment
)

fun TimesheetDTO.toTimesheetData() = TimesheetData(
    projectName = projectName,
    taskName = taskName,
    date = date,
    startTime = startTime,
    endTime = endTime,
    duration = duration,
    comment = comment
)

fun List<TimesheetDTO>.toTimesheetDataList() = this.map {
    it.toTimesheetData()
}
