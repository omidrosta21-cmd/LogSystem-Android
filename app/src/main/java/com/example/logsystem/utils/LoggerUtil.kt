package com.example.logsystem.utils

import android.util.Log
import com.example.logsystem.presentation.LogApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object LoggerUtil {
    private var app: LogApplication? = null

    fun init(application: LogApplication) {
        app = application
    }

    fun d(tag: String, message: String) {
        Log.d(tag, message)
        addLog("DEBUG", tag, message)
    }

    fun i(tag: String, message: String) {
        Log.i(tag, message)
        addLog("INFO", tag, message)
    }

    fun w(tag: String, message: String) {
        Log.w(tag, message)
        addLog("WARNING", tag, message)
    }

    fun e(tag: String, message: String, throwable: Throwable? = null) {
        Log.e(tag, message, throwable)
        val stackTrace = throwable?.stackTraceToString()
        addLog("ERROR", tag, message, stackTrace)
    }

    fun c(tag: String, message: String, throwable: Throwable? = null) {
        Log.e(tag, "[CRITICAL] $message", throwable)
        val stackTrace = throwable?.stackTraceToString()
        addLog("CRITICAL", tag, message, stackTrace)
    }

    private fun addLog(level: String, tag: String, message: String, stackTrace: String? = null) {
        app?.let { application ->
            CoroutineScope(Dispatchers.Default).launch {
                try {
                    application.viewModel.addLog(level, tag, message, stackTrace)
                } catch (e: Exception) {
                    Log.e("LoggerUtil", "Error adding log", e)
                }
            }
        }
    }
}