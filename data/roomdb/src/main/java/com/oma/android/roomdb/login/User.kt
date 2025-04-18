package com.oma.android.roomdb.login

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "users")
data class User(
    @PrimaryKey val id: String = UUID.randomUUID().toString(), // Secure unique ID
    val name: String,
    val encryptedEmail: String,
    val emailIv: String,
    val hashedPassword: String
)