package com.oma.android.taskline

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.asLiveData
import com.oma.android.base.main.UiEvent
import com.oma.android.base.navigation.Destination
import com.oma.android.composeui.theme.TaskLineTheme
import com.oma.android.login.AuthViewModel
import com.oma.android.login.navhost.LoginNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // Shared across all Composables inside this Activity
    private val authViewModel: AuthViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        collectEvents()
        setContent {
            TaskLineTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    LoginNavHost(authViewModel)
                }
            }
        }
    }

    private fun collectEvents() {
        authViewModel.uiEvent.asLiveData().observe(this) { event ->
            when (event) {
                is UiEvent.NotifyMessage -> {
                    Toast.makeText(this@MainActivity, event.message, Toast.LENGTH_SHORT).show()
                }

                is UiEvent.NavigateToActivity -> {
                    val destination = when (event.destination) {
                        Destination.Dashboard -> DashboardActivity::class.java
                        else -> {
                            null
                        }
                    }
                    destination?.also {
                        val intent = Intent(this@MainActivity, it).apply {
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

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        TaskLineTheme {
            Greeting("Android")
        }
    }
}