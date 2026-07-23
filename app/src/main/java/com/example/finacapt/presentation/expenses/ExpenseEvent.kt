package com.example.finacapt.presentation.expenses

import com.example.finacapt.data.entity.Expense

sealed class ExpenseEvent {
    data class EraseExpense(val eraseExpense: Expense): ExpenseEvent()
    data object AddExpense: ExpenseEvent()
    data class SetExpenseDescription(val setDescription: String?) : ExpenseEvent()
    data class SetExpenseTimeStamp(val setTimeStamp: String): ExpenseEvent()
    data class SetExpenseAmount(val setAmount: String): ExpenseEvent()
    data class SpecifyCategoryId(val specifyCategoryId: Int): ExpenseEvent()
}