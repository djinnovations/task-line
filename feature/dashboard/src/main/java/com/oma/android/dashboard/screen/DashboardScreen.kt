package com.oma.android.dashboard.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.oma.android.composeui.theme.Themer
import com.oma.android.dashboard.BottomNavBar
import com.oma.android.dashboard.navhost.DashboardNavHost

@Composable
fun DashboardScreen() {
    val navController = rememberNavController()
    Scaffold(
        containerColor = Themer.colors.Mercury,
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) { innerPadding ->
        DashboardNavHost(modifier = Modifier.padding(innerPadding), navController)
    }
}