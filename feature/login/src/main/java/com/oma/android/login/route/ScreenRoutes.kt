package com.oma.android.login.route

internal sealed class ScreenRoutes(val route: String) {
    data object Welcome : ScreenRoutes("welcome")
    data object Register : ScreenRoutes("register")
    data object Login : ScreenRoutes("login")
}