package com.example.finacapt.data

import androidx.room.Embedded
import androidx.room.Relation
import com.example.finacapt.data.entity.Category
import com.example.finacapt.data.entity.Expense

data class CategoryWithExpense (
    @Embedded val category: Category,
    @Relation(
        parentColumn = "id",
        entityColumn = "category_id"
    )
    val expenses: List<Expense>
)