package com.oma.android.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oma.android.roomdb.login.User
import com.oma.android.roomdb.login.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}