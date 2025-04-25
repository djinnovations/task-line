package com.oma.android.viewtimesheet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.oma.android.composeui.theme.Themer
import com.oma.android.composeui.topbar.PrimaryTopBar
import com.oma.android.domainmodel.timesheet.toTimesheetData
import com.oma.android.viewtimesheet.ViewTimesheetViewModel

@Composable
internal fun ViewTimesheetScreen(
    paddingValues: PaddingValues,
    viewModel: ViewTimesheetViewModel,
    onBack: () -> Unit = {}
) {
    val timesheetItems = viewModel.timesheets.collectAsLazyPagingItems()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Spacer(Modifier.height(4.dp))
        PrimaryTopBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            "View Timesheet",
            titleColor = Themer.colors.TextAlternate,
            onBack = onBack
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            item {
                // Table Header
                Row(Modifier.fillMaxWidth().horizontalScroll(scrollState)) {
                    TimesheetHeader()
                }
            }

            items(timesheetItems.itemCount) { index ->
                val timesheet = timesheetItems[index]
                timesheet?.let {
                    Row(Modifier.horizontalScroll(scrollState)) {
                        TimesheetRowItem(it.toTimesheetData())
                    }
                }
            }
        }
    }
}