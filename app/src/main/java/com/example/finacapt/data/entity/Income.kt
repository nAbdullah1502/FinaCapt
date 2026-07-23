package com.example.finacapt.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Income(
    val name: String?,
    val amount: Double,
    val timestamp: Long,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
