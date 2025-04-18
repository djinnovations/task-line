package com.oma.android.login.data.repo

import com.oma.android.login.data.UserDTO

interface UserRepo {
    suspend fun authenticateUser(
        inputEmail: String,
        inputPassword: String
    ): Result<UserDTO>

    suspend fun addUser(
        name: String,
        email: String, password: String
    ): Result<Boolean>
}