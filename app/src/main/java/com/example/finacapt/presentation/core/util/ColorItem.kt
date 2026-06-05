package com.example.finacapt.presentation.core.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun ColorItem(
    color: androidx.compose.ui.graphics.Color,
    selected: Boolean,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .size(52.dp)
            .clip(CircleShape)
            .clickable(onClick = onClick)
    )
}