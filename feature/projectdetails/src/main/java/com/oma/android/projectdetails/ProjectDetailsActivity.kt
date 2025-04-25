package com.oma.android.projectdetails

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.asLiveData
import com.oma.android.base.main.UiEvent
import com.oma.android.composeui.theme.TaskLineTheme
import com.oma.android.projectdetails.navhost.ProjectDetailsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProjectDetailsActivity : ComponentActivity() {

    private val projectDetailsSharedViewModel: ProjectDetailsSharedViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        collectEvents()
        setContent {
            TaskLineTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    ProjectDetailsNavHost(
                        padding,
                        projectDetailsSharedViewModel
                    )
                }
            }
        }
    }

    private fun collectEvents() {
        projectDetailsSharedViewModel.uiEvent.asLiveData().observe(this) { event ->
            when (event) {
                is UiEvent.NotifyMessage -> {
                    Toast.makeText(applicationContext, event.message, Toast.LENGTH_SHORT).show()
                }

                else -> {}
            }
        }
    }
}