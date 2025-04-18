package com.oma.android.login.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.oma.android.base.main.UiEvent
import com.oma.android.login.AuthEvent
import com.oma.android.login.AuthViewModel
import com.oma.android.login.screens.RegisterScreen

@Composable
fun RegisterRoute(
    navController: NavController,
    viewModel: AuthViewModel
) {
    RegisterScreen(
        onBack = { navController.popBackStack() }
    ) { name, email, password ->
        viewModel.onEvent(AuthEvent.RegisterUser(name, email, password))
    }

    // Screen Navigation or other events from VM handled here
    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> {
                    navController.navigate(event.route)
                }

                else -> {}
            }
        }
    }
}