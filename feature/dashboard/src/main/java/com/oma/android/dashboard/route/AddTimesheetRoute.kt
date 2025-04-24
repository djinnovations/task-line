package com.oma.android.dashboard.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.oma.android.dashboard.DashboardEvent
import com.oma.android.dashboard.DashboardSharedViewModel
import com.oma.android.dashboard.screen.AddTimesheetScreen

@Composable
internal fun AddTimesheetRoute(
    navController: NavController,
    viewModel: DashboardSharedViewModel
) {
    // Perform onCreate task
    LaunchedEffect(Unit) {
        viewModel.onEvent(DashboardEvent.FetchTimesheetOptions)
    }

    AddTimesheetScreen(
        viewModel.timesheetScreenStateFlow,
        notifyMessage = { viewModel.onEvent(DashboardEvent.NotifyMessage(it)) }
    ) {
        viewModel.onEvent(DashboardEvent.SubmitTimesheet(it))
    }
}