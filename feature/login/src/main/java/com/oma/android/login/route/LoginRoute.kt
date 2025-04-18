package com.oma.android.login.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.oma.android.login.AuthEvent
import com.oma.android.login.AuthViewModel
import com.oma.android.login.screens.LoginScreen

@Composable
fun LoginRoute(
    navController: NavController,
    viewModel: AuthViewModel
) {
    LoginScreen(
        onBack = { navController.popBackStack() }
    ) { email, password ->
        viewModel.onEvent(AuthEvent.AuthenticateUser(email, password))
    }
}