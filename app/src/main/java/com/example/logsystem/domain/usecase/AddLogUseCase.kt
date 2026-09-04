package com.example.logsystem.domain.usecase

import com.example.logsystem.domain.repository.LogRepository

class AddLogUseCase(private val repository: LogRepository) {
    suspend operator fun invoke(
        level: String,
        tag: String,
        message: String,
        stackTrace: String? = null
    ) {
        repository.addLog(level, tag, message, stackTrace)
    }
}