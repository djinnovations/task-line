package com.oma.android.login

import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oma.android.base.main.UiEvent
import com.oma.android.base.navigation.Destination
import com.oma.android.login.data.repo.UserRepo
import com.oma.android.login.data.session.SessionManager
import com.oma.android.login.route.ScreenRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repo: UserRepo,
    private val sessionManager: SessionManager
) : ViewModel() {

    init {
        Log.d("TAG", "init: VM")
        checkLogin()
    }

    // One-time UI events
    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun onEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.RegisterUser -> {
                viewModelScope.launch {
                    val result = repo.addUser(event.name, event.userName, event.password)
                    if (result.isSuccess) {
                        _uiEvent.emit(UiEvent.Navigate(ScreenRoutes.Login.route))
                    } else {
                        _uiEvent.emit(UiEvent.NotifyMessage("Registration failed"))
                    }
                }
            }

            is AuthEvent.AuthenticateUser -> {
                viewModelScope.launch {
                    val result = repo.authenticateUser(event.userName, event.password)
                    if (result.isSuccess) {
                        result.getOrNull()?.let { sessionManager.saveSession(it) }
                        _uiEvent.emit(getDashboardIntentEvent())
                    } else {
                        _uiEvent.emit(UiEvent.NotifyMessage("Invalid Username/Password"))
                    }
                }
            }
        }
    }

    private fun checkLogin() {
        viewModelScope.launch {
            sessionManager.getSession().collect { user ->
                if (user != null) {
                    // Session found go to Dashboard
                    _uiEvent.emit(getDashboardIntentEvent())
                }
            }
        }
    }

    private fun getDashboardIntentEvent() = UiEvent.NavigateToActivity(
        Destination.Dashboard,
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    )
}