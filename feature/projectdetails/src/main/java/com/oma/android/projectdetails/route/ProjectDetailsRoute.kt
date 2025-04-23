package com.oma.android.projectdetails.route

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.oma.android.projectdetails.ProjectDetailsSharedViewModel
import com.oma.android.projectdetails.screen.ProjectDetailsScreen

@Composable
internal fun ProjectDetailsRoute(
    scaffoldPadding: PaddingValues,
    navController: NavController,
    viewModel: ProjectDetailsSharedViewModel,
    onBack: () -> Unit = {}
) {
    ProjectDetailsScreen(
        scaffoldPadding,
        viewModel.getProjectData()!!,
        onTaskItemClicked = {
            viewModel.setTaskItem(it)
            navController.navigate(ScreenRoutes.TaskDetails.route)
        },
        onBack = onBack
    )
}