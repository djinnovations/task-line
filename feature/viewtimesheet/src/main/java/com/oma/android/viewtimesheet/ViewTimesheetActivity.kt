package com.oma.android.viewtimesheet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.oma.android.composeui.theme.TaskLineTheme
import com.oma.android.viewtimesheet.components.ViewTimesheetScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewTimesheetActivity : ComponentActivity() {

    private val viewTimesheetViewModel: ViewTimesheetViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        collectEvents()
        setContent {
            TaskLineTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    ViewTimesheetScreen(
                        padding,
                        viewTimesheetViewModel
                    ) {
                        finish()
                    }
                }
            }
        }
    }

    private fun collectEvents() {}
}