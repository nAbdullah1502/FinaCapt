package com.example.finacapt.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Category(
    val title: String,
    val limit: Double,
    val colorId: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)