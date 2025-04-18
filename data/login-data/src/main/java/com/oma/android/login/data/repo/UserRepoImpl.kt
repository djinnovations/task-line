package com.oma.android.login.data.repo

import android.content.res.Resources.NotFoundException
import com.oma.android.base.HashUtils
import com.oma.android.login.data.toUserDto
import com.oma.android.roomdb.login.User
import com.oma.android.roomdb.login.UserDao
import com.oma.android.utils.EncryptionUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepoImpl @Inject constructor(
    private val userDao: UserDao,
    private val encryptionUtils: EncryptionUtils,
    private val hashUtils: HashUtils
): UserRepo {
    override suspend fun authenticateUser(
        inputEmail: String,
        inputPassword: String
    ) = withContext(Dispatchers.IO) {
        val allUsers = userDao.getAllUsers()
        for (user in allUsers) {
            val decryptedEmail = encryptionUtils.decrypt(user.encryptedEmail, user.emailIv)
            if (decryptedEmail == inputEmail
                && hashUtils.verifyPassword(inputPassword, user.hashedPassword)
            ) {
                return@withContext Result.success(user.toUserDto())
            }
        }
        return@withContext Result.failure(NotFoundException())
    }

    override suspend fun addUser(
        name: String,
        email: String, password: String
    ) = withContext(Dispatchers.IO) {
        try {
            val hashedPassword = hashUtils.hashPassword(password)
            val (encryptedEmail, iv) = encryptionUtils.encrypt(email)
            val user = User(
                name = name,
                encryptedEmail = encryptedEmail,
                emailIv = iv,
                hashedPassword = hashedPassword
            )
            userDao.insertUser(user)
            Result.success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}