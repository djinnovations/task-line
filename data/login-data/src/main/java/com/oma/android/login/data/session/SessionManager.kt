package com.oma.android.login.data.session

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.oma.android.login.data.UserDTO
import com.oma.android.utils.EncryptionUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore("secure_session")

@Singleton
class SessionManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val encryptionUtils: EncryptionUtils
) {
    companion object {
        private val SESSION_KEY = stringPreferencesKey("session_data")
        private val IV_KEY = stringPreferencesKey("session_iv")
        private const val SESSION_EXPIRY_MILLIS = 7 * 24 * 60 * 60 * 1000L // 7 days
    }

    suspend fun saveSession(user: UserDTO) {
        val sessionInfo = SessionInfo(user, System.currentTimeMillis())
        val json = Json.encodeToString(sessionInfo)

        val (encrypted, iv) = encryptionUtils.encrypt(json)

        context.dataStore.edit { prefs ->
            prefs[SESSION_KEY] = encrypted
            prefs[IV_KEY] = iv
        }
    }

    fun getSession(): Flow<UserDTO?> {
        return context.dataStore.data.map { prefs ->
            val encrypted = prefs[SESSION_KEY]
            val iv = prefs[IV_KEY]

            if (encrypted != null && iv != null) {
                try {
                    val json = encryptionUtils.decrypt(encrypted, iv)
                    val session = Json.decodeFromString<SessionInfo>(json)

                    val now = System.currentTimeMillis()
                    val isValid = (now - session.loginTimestamp) <= SESSION_EXPIRY_MILLIS

                    if (isValid) session.user else null
                } catch (e: Exception) {
                    null
                }
            } else null
        }
    }

    suspend fun clearSession() {
        context.dataStore.edit { prefs ->
            prefs.remove(SESSION_KEY)
            prefs.remove(IV_KEY)
        }
    }
}