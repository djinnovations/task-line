package com.oma.android.base.navigation

sealed class Destination {
    data object Dashboard : Destination()
    data object ProjectDetails : Destination()
    data object ViewTimesheet : Destination()
}