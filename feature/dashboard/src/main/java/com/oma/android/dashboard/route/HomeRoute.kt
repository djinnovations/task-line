package com.oma.android.dashboard.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.oma.android.dashboard.DashboardEvent
import com.oma.android.dashboard.DashboardSharedViewModel
import com.oma.android.dashboard.screen.HomeScreen

@Composable
internal fun HomeRoute(
    navController: NavController,
    viewModel: DashboardSharedViewModel
) {
    // Perform onCreate task
    LaunchedEffect(Unit) {
        viewModel.onEvent(DashboardEvent.FetchProjects)
    }

    HomeScreen(
        viewModel.homeScreenStateFlow,
        onViewTimesheet = { viewModel.onEvent(DashboardEvent.ViewTimeSheetClick) }
    ) { project ->
        viewModel.onEvent(DashboardEvent.ProjectItemClick(project))
    }
}