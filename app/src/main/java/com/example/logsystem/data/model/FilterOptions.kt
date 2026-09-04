package com.example.logsystem.data.model

data class FilterOptions(
    val searchQuery: String = "",
    val level: String? = null,
    val tag: String? = null,
    val startTime: Long? = null,
    val endTime: Long? = null
)