package com.example.finacapt.data.entity

import androidx.room.Entity


@Entity
data class Income(
    val name: String?,
    val amount: Double,
    val timestamp: Long
)
