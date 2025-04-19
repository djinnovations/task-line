package com.oma.android.dashboard

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.oma.android.composeui.theme.Secondary
import com.oma.android.composeui.theme.Themer
import com.oma.android.dashboard.route.ScreenRoutes

@Composable
fun BottomNavBar(navController: NavController) {
    val screens = remember {
        listOf(
            ScreenRoutes.Home,
            ScreenRoutes.Project,
            ScreenRoutes.Add,
            ScreenRoutes.Profile
        )
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar (containerColor = Themer.colors.LynxWhite){
        screens.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.route == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        // Safe way to get start destination
                        val startDestination = navController.graph.findStartDestination().id
                        popUpTo(startDestination) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (currentDestination?.route == screen.route)
                            screen.icon else screen.iconUnSelected,
                        contentDescription = screen.label,
                        tint = Secondary
                    )
                },
                label = {
                    Text(
                        screen.label,
                        style = MaterialTheme.typography.labelSmall,
                        color = Themer.colors.TextAlternate
                    )
                }
            )
        }
    }
}