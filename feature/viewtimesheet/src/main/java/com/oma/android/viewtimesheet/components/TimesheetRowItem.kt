package com.oma.android.viewtimesheet.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.oma.android.domainmodel.timesheet.TimesheetData

@Composable
fun TimesheetRowItem(timesheet: TimesheetData) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        TableCell(timesheet.projectName, dimensionResource(com.intuit.sdp.R.dimen._150sdp))
        TableCell(timesheet.taskName, dimensionResource(com.intuit.sdp.R.dimen._170sdp))
        TableCell(timesheet.date, dimensionResource(com.intuit.sdp.R.dimen._95sdp))
        TableCell(timesheet.startTime, dimensionResource(com.intuit.sdp.R.dimen._55sdp))
        TableCell(timesheet.endTime, dimensionResource(com.intuit.sdp.R.dimen._55sdp))
        TableCell(timesheet.duration, dimensionResource(com.intuit.sdp.R.dimen._65sdp))
        TableCell(timesheet.comment, dimensionResource(com.intuit.sdp.R.dimen._270sdp))
    }
}