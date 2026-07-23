package com.example.finacapt.presentation.expenses

import com.example.finacapt.data.entity.Expense

data class ExpenseState (
    val expenseList : List<Expense> = emptyList(),
    val description: String? = "",
    val categoryId : Int = 0,
    val timestamp: String = "",
    val amount: String = ""
)
