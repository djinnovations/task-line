package com.oma.android.projectdetails

import android.annotation.SuppressLint
import android.os.Bundle
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
                    ProjectDetailsNavHost(padding, projectDetailsSharedViewModel.getProjectData()!!)
                }
            }
        }
    }

    private fun collectEvents() {

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