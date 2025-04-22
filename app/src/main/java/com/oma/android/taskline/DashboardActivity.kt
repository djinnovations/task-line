package com.oma.android.taskline

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.oma.android.base.main.UiEvent
import com.oma.android.base.navigation.Destination
import com.oma.android.composeui.theme.TaskLineTheme
import com.oma.android.dashboard.DashboardSharedViewModel
import com.oma.android.dashboard.screen.DashboardScreen
import com.oma.android.projectdetails.ProjectDetailsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

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
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                dashboardSharedViewModel.uiEvent.onEach { event ->
                    when (event) {
                        is UiEvent.NavigateToActivity -> {
                            val destination = when (event.destination) {
                                Destination.ProjectDetails -> ProjectDetailsActivity::class.java
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
                }.launchIn(lifecycleScope)
            }
        }
    }
}