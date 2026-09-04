package com.example.logsystem.presentation

import android.app.Application
import android.util.Log
import com.example.logsystem.data.repository.LogRepositoryImpl
import com.example.logsystem.presentation.viewmodel.LogViewModel

class LogApplication : Application() {
    lateinit var repository: LogRepositoryImpl
        private set

    lateinit var viewModel: LogViewModel
        private set

    override fun onCreate() {
        super.onCreate()
        setupDependencies()
        addSampleLogs()
    }

    private fun setupDependencies() {
        repository = LogRepositoryImpl(this)
        viewModel = LogViewModel(repository)
    }

    private fun addSampleLogs() {
        try {
            viewModel.addLog("INFO", "App", "Application started")
            viewModel.addLog("DEBUG", "MainActivity", "MainActivity onCreate called")
            viewModel.addLog("INFO", "Network", "Connected to server")
            viewModel.addLog("WARNING", "Memory", "Memory usage at 75%")
            viewModel.addLog("ERROR", "Database", "Failed to fetch user data")
            viewModel.addLog("CRITICAL", "System", "Critical system failure detected")
        } catch (e: Exception) {
            Log.e("LogApplication", "Error adding sample logs", e)
        }
    }
}
