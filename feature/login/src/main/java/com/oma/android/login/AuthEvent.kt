package com.oma.android.login

sealed class AuthEvent {
    data class RegisterUser(val name: String, val userName: String, val password: String) : AuthEvent()

    data class AuthenticateUser(val userName: String, val password: String) : AuthEvent()
}