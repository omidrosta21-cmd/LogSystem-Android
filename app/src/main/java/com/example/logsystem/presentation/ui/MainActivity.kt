package com.example.logsystem.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.logsystem.presentation.LogApplication
import com.example.logsystem.presentation.ui.screens.LogsScreen
import com.example.logsystem.presentation.ui.theme.LogSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val application = application as LogApplication
        val viewModel = application.viewModel

        setContent {
            LogSystemTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    LogsScreen(viewModel)
                }
            }
        }
    }
}
