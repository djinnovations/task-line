package com.oma.android.projectdetails.route

internal sealed class ScreenRoutes(val route: String) {
    data object ProjectDetails : ScreenRoutes("project-details")
    data object TaskDetails : ScreenRoutes("task-details")
}