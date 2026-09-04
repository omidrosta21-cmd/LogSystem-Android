package com.example.logsystem.domain.usecase

import com.example.logsystem.data.model.LogEntry
import com.example.logsystem.domain.repository.LogRepository
import kotlinx.coroutines.flow.Flow

class SearchLogsUseCase(private val repository: LogRepository) {
    operator fun invoke(query: String): Flow<List<LogEntry>> {
        return repository.searchLogs(query)
    }
}