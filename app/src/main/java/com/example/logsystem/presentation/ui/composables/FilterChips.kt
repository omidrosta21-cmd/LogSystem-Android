package com.example.logsystem.presentation.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LogLevelFilters(
    selectedLevel: String?,
    onLevelSelected: (String?) -> Unit,
    modifier: Modifier = Modifier
) {
    val levels = listOf("DEBUG", "INFO", "WARNING", "ERROR", "CRITICAL")

    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        levels.forEach { level ->
            FilterChip(
                selected = selectedLevel == level,
                onClick = {
                    onLevelSelected(if (selectedLevel == level) null else level)
                },
                label = { Text(level) }
            )
        }
    }
}