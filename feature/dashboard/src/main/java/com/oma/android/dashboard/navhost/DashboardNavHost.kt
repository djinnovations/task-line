package com.oma.android.dashboard.navhost

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.oma.android.composeui.theme.Themer
import com.oma.android.dashboard.route.ScreenRoutes
import com.oma.android.dashboard.screen.HomeScreen

@Composable
fun DashboardNavHost(modifier: Modifier, navController: NavHostController) {
    NavHost(navController, startDestination = ScreenRoutes.Home.route, modifier) {
        composable(ScreenRoutes.Home.route) {
            HomeScreen()
        }
        composable(ScreenRoutes.Project.route) {
            Text(
                text = "Project",
                style = MaterialTheme.typography.titleLarge.copy(color = Themer.colors.ChateauGreen),
            )
        }
        composable(ScreenRoutes.Add.route) {
            Text(
                text = "Add",
                style = MaterialTheme.typography.titleLarge.copy(color = Themer.colors.ChateauGreen),
            )
        }
        composable(ScreenRoutes.Profile.route) {
            Text(
                text = "Profile",
                style = MaterialTheme.typography.titleLarge.copy(color = Themer.colors.ChateauGreen),
            )
        }
    }
}