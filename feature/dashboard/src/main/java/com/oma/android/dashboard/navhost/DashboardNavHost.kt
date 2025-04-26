package com.oma.android.dashboard.navhost

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.oma.android.composeui.theme.Themer
import com.oma.android.dashboard.DashboardSharedViewModel
import com.oma.android.dashboard.R
import com.oma.android.dashboard.route.AddTimesheetRoute
import com.oma.android.dashboard.route.HomeRoute
import com.oma.android.dashboard.route.ScreenRoutes
import com.oma.android.dashboard.screen.CluelessScreen

@Composable
internal fun DashboardNavHost(
    modifier: Modifier, navController: NavHostController,
    viewModel: DashboardSharedViewModel
) {
    NavHost(navController, startDestination = ScreenRoutes.Home.route, modifier) {
        composable(ScreenRoutes.Home.route) {
            HomeRoute(navController, viewModel)
        }
        composable(ScreenRoutes.Project.route) {
            CluelessScreen("Add Project")
        }
        composable(ScreenRoutes.Add.route) {
            CluelessScreen("Add Task")
        }
        composable(ScreenRoutes.Profile.route) {
            AddTimesheetRoute(navController, viewModel)
        }
    }
}