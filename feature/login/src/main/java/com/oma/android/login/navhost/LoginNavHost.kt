package com.oma.android.login.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oma.android.composeui.navhost.AnimatedNavHost
import com.oma.android.login.AuthViewModel
import com.oma.android.login.route.LoginRoute
import com.oma.android.login.route.RegisterRoute
import com.oma.android.login.route.ScreenRoutes
import com.oma.android.login.screens.AppWelcomeScreen

@Composable
fun LoginNavHost(viewModel: AuthViewModel) {
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
            LoginRoute(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(ScreenRoutes.Register.route) {
            RegisterRoute(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}

