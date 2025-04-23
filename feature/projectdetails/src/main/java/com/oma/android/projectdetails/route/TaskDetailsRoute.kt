package com.oma.android.projectdetails.route

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.oma.android.projectdetails.ProjectDetailsSharedViewModel
import com.oma.android.projectdetails.screen.TaskDetailsScreen

@Composable
internal fun TaskDetailsRoute(
    scaffoldPadding: PaddingValues,
    navController: NavController,
    viewModel: ProjectDetailsSharedViewModel
) {
    TaskDetailsScreen(
        scaffoldPadding,
        viewModel.getTaskItem()!!,
    ) {
        navController.popBackStack()
    }
}