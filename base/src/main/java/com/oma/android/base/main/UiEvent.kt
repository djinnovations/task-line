package com.oma.android.base.main

import android.os.Bundle
import com.oma.android.base.navigation.Destination

sealed class UiEvent {
    data class NavigateToActivity(
        val destination: Destination,
        val extras: Bundle? = null,
        val flags: Int? = null
    ) : UiEvent()

    data class Navigate(val route: String) : UiEvent()
    data class NotifyMessage(val message: String) : UiEvent()
}