package com.example.logsystem.domain.usecase

import com.example.logsystem.domain.repository.LogRepository

class ClearLogsUseCase(private val repository: LogRepository) {
    suspend operator fun invoke() {
        repository.clearAllLogs()
    }
}