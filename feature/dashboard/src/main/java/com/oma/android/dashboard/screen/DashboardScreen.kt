package com.oma.android.dashboard.screen

import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.oma.android.composeui.theme.ColorPacket
import com.oma.android.composeui.theme.Primary
import com.oma.android.composeui.theme.Themer
import com.oma.android.dashboard.BottomNavBar
import com.oma.android.dashboard.DashboardSharedViewModel
import com.oma.android.dashboard.navhost.DashboardNavHost

@Composable
fun DashboardScreen(viewModel: DashboardSharedViewModel) {
    val navController = rememberNavController()
    val activity = LocalContext.current as Activity

    // Set status bar color using Android API
    SideEffect {
        val window = activity.window
        window.statusBarColor = Primary.toArgb()

        val insetsController = WindowCompat.getInsetsController(window, window.decorView)
        insetsController.isAppearanceLightStatusBars = false
    }
    Scaffold(
        containerColor = Themer.colors.Mercury,
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) { innerPadding ->
        DashboardNavHost(modifier = Modifier.padding(innerPadding), navController, viewModel)
    }
}