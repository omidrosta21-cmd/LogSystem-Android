package com.example.logsystem.domain.usecase

import com.example.logsystem.data.model.LogEntry
import com.example.logsystem.domain.repository.LogRepository
import kotlinx.coroutines.flow.Flow

class GetLogsUseCase(private val repository: LogRepository) {
    operator fun invoke(limit: Int = 1000): Flow<List<LogEntry>> {
        return repository.getAllLogs(limit)
    }
}