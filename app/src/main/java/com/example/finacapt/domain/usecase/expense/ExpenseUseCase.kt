package com.example.finacapt.domain.usecase.expense

import javax.inject.Inject

data class ExpenseUseCase @Inject constructor (
    val addExpense: AddExpense,
    val eraseExpense: EraseExpenseById,
    val getAllExpenses: GetAllExpenses,
)