package com.oma.android.projectdetails.navhost

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oma.android.composeui.navhost.AnimatedNavHost
import com.oma.android.projectdetails.ProjectDetailsSharedViewModel
import com.oma.android.projectdetails.route.ProjectDetailsRoute
import com.oma.android.projectdetails.route.ScreenRoutes
import com.oma.android.projectdetails.route.TaskDetailsRoute

@Composable
internal fun ProjectDetailsNavHost(
    scaffoldPadding: PaddingValues,
    viewModel: ProjectDetailsSharedViewModel
) {
    val backPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val navController = rememberNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = ScreenRoutes.ProjectDetails.route
    ) {
        composable(ScreenRoutes.ProjectDetails.route) {
            ProjectDetailsRoute(
                scaffoldPadding,
                navController,
                viewModel
            ) {
                backPressedDispatcher?.onBackPressed()
            }
        }

        composable(ScreenRoutes.TaskDetails.route) {
            TaskDetailsRoute(scaffoldPadding, navController, viewModel)
        }
    }
}