package com.oma.android.taskline

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.asLiveData
import com.oma.android.base.main.UiEvent
import com.oma.android.base.navigation.Destination
import com.oma.android.composeui.theme.TaskLineTheme
import com.oma.android.dashboard.DashboardSharedViewModel
import com.oma.android.dashboard.screen.DashboardScreen
import com.oma.android.projectdetails.ProjectDetailsActivity
import com.oma.android.viewtimesheet.ViewTimesheetActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : ComponentActivity() {

    private val dashboardSharedViewModel: DashboardSharedViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        collectEvents()
        setContent {
            TaskLineTheme {
                DashboardScreen(dashboardSharedViewModel)
            }
        }
    }

    private fun collectEvents() {
        dashboardSharedViewModel.uiEvent.asLiveData().observe(this@DashboardActivity) { event ->
            when (event) {
                is UiEvent.NotifyMessage -> {
                    Toast.makeText(this@DashboardActivity, event.message, Toast.LENGTH_SHORT).show()
                }
                is UiEvent.NavigateToActivity -> {
                    val destination = when (event.destination) {
                        Destination.ProjectDetails -> ProjectDetailsActivity::class.java
                        Destination.ViewTimesheet -> ViewTimesheetActivity::class.java
                        else -> {
                            null
                        }
                    }
                    destination?.also {
                        val intent = Intent(this@DashboardActivity, it).apply {
                            event.extras?.let { putExtras(it) }
                            event.flags?.let { addFlags(it) }
                        }
                        startActivity(intent)
                    }
                }

                else -> {}
            }
        }
    }
}