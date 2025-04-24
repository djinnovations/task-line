package com.oma.android.roomdb

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

class SampleDataExecutor(private val context: Context) {
    val roomCallback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            runSqlScriptFromAssets(context = context, db = db, assetFileName = "populate_realistic_dummy_data.sql")
        }
    }

    fun runSqlScriptFromAssets(context: Context, db: SupportSQLiteDatabase, assetFileName: String) {
        context.assets.open(assetFileName).bufferedReader().useLines { lines ->
            val statement = StringBuilder()
            lines.forEach { line ->
                val trimmed = line.trim()
                if (trimmed.isNotEmpty() && !trimmed.startsWith("--")) {
                    statement.append(trimmed)
                    if (trimmed.endsWith(";")) {
                        db.execSQL(statement.toString())
                        statement.clear()
                    }
                }
            }
        }
    }
}