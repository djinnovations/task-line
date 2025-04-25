package com.oma.android.viewtimesheet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp

@Composable
fun TimesheetHeader() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(vertical = 6.dp),
    ) {
        TableCell("Project", dimensionResource(com.intuit.sdp.R.dimen._150sdp))
        TableCell("Task", dimensionResource(com.intuit.sdp.R.dimen._170sdp))
        TableCell("Date", dimensionResource(com.intuit.sdp.R.dimen._95sdp))
        TableCell("Start", dimensionResource(com.intuit.sdp.R.dimen._55sdp))
        TableCell("End", dimensionResource(com.intuit.sdp.R.dimen._55sdp))
        TableCell("Duration", dimensionResource(com.intuit.sdp.R.dimen._65sdp))
        TableCell("Comment", dimensionResource(com.intuit.sdp.R.dimen._270sdp))
    }
}