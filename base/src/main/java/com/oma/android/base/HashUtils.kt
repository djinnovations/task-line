package com.oma.android.base

import java.security.MessageDigest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HashUtils @Inject constructor() {
    fun hashPassword(password: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(password.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

    fun verifyPassword(inputPassword: String, storedHash: String): Boolean {
        val hashedInput = hashPassword(inputPassword)
        return hashedInput == storedHash
    }
}