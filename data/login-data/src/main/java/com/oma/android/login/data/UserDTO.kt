package com.oma.android.login.data

import com.oma.android.roomdb.login.User
import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
    val name: String,
    val userId: String
)

fun User.toUserDto() = UserDTO(this.name, this.id)