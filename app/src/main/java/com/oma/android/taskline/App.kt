package com.oma.android.taskline

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TaskLineApp() : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}