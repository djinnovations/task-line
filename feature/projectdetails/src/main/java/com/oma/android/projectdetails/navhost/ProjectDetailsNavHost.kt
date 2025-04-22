package com.oma.android.projectdetails.navhost

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oma.android.composeui.navhost.AnimatedNavHost
import com.oma.android.domainmodel.projectdetails.ProjectItem
import com.oma.android.projectdetails.route.ScreenRoutes
import com.oma.android.projectdetails.screen.ProjectDetailsScreen

@Composable
fun ProjectDetailsNavHost(
    scaffoldPadding: PaddingValues,
    projectItem: ProjectItem
) {
    val backPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val navController = rememberNavController()
    AnimatedNavHost(navController = navController, startDestination = ScreenRoutes.ProjectDetails.route) {
        composable(ScreenRoutes.ProjectDetails.route) {
            ProjectDetailsScreen(scaffoldPadding, projectItem = projectItem) {
                backPressedDispatcher?.onBackPressed()
            }
        }
    }
}