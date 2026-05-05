package com.example.finacapt.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("category_id"),
            onUpdate = CASCADE,
            onDelete = CASCADE
        ),
    ],
    indices = [Index("category_id")]
)
data class Expense(
    val name: String?,
    @ColumnInfo(name="category_id")
    val categoryId: Int,
    val timestamp: Long,
    val amount: Double,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
