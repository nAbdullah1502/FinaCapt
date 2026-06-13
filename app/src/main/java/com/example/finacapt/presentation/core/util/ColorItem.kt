package com.example.finacapt.presentation.core.util

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

@Composable
fun ColorItem(
    color: androidx.compose.ui.graphics.Color,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(
                if (selected) 60.dp
                else 50.dp
            )
            .clip(CircleShape)
            .clickable(onClick = onClick)
            .then(if (selected)
                Modifier
                    .border(
                        width=2.dp,
                        color=androidx.compose.ui.graphics.Color.Gray,
                        shape=CircleShape)
                    .shadow(elevation=8.dp, shape=CircleShape)
                else Modifier
        )
    ) {
        Box{
            Canvas(modifier = Modifier.fillMaxSize()){drawCircle(color = color)}
            if (selected) Icon(imageVector=Icons.Default.Check, contentDescription = "check" )
        }
    }
}