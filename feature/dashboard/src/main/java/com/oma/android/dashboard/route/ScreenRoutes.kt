package com.oma.android.dashboard.route

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.AddTask
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

internal sealed class ScreenRoutes(
    val route: String, val icon: ImageVector,
    val iconUnSelected: ImageVector,
    val label: String
) {
    data object Home : ScreenRoutes("home", Icons.Filled.Home, Icons.Outlined.Home, "Home")
    data object Project : ScreenRoutes(
        "project",
        Icons.Filled.Book,
        Icons.Outlined.Book,
        "Project"
    )

    data object Add : ScreenRoutes("add", Icons.Filled.AddTask, Icons.Outlined.AddTask, "Add")
    data object Profile :
        ScreenRoutes("profile", Icons.Filled.Person, Icons.Outlined.Person, "Profile")
}