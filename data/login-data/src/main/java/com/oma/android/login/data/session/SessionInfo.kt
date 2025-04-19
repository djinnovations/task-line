package com.oma.android.login.data.session

import com.oma.android.login.data.UserDTO
import kotlinx.serialization.Serializable

@Serializable
data class SessionInfo(
    val user: UserDTO,
    val loginTimestamp: Long // Epoch millis
)