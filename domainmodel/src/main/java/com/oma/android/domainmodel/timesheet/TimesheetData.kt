package com.oma.android.domainmodel.timesheet

data class TimesheetData(
    val projectName: String,
    val taskName: String,
    val date: String,
    val startTime: String,
    val endTime: String,
    val comment: String
)
