package com.oma.android.login.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oma.android.composeui.navhost.AnimatedNavHost
import com.oma.android.login.AppWelcomeScreen
import com.oma.android.login.LoginScreen
import com.oma.android.login.RegisterScreen
import com.oma.android.login.route.ScreenRoutes

@Composable
fun LoginNavHost() {
    val navController = rememberNavController()
    AnimatedNavHost(navController = navController, startDestination = ScreenRoutes.Welcome.route) {
        composable(ScreenRoutes.Welcome.route) {
            AppWelcomeScreen(
                onLogin = {
                    navController.navigate(ScreenRoutes.Login.route)
                },
                onCreateAccount = {
                    navController.navigate(ScreenRoutes.Register.route)
                }
            )
        }

        composable(ScreenRoutes.Login.route) {
            LoginScreen(
                onBack = { navController.popBackStack() }
            )
        }

        composable(ScreenRoutes.Register.route) {
            RegisterScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}
