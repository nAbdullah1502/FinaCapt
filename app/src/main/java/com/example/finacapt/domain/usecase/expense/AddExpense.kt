package com.example.finacapt.domain.usecase.expense

import com.example.finacapt.data.entity.Expense
import com.example.finacapt.domain.repository.Repository
import com.example.finacapt.domain.util.exception.InvalidExpenseException
import javax.inject.Inject

class AddExpense @Inject constructor(
    private val repository: Repository
) {
    @Throws (InvalidExpenseException::class)
    suspend operator fun invoke(expense: Expense) {
        if (expense.amount.isNaN() ||
            expense.amount < 0 ||
            expense.categoryId == -1
            )
            throw InvalidExpenseException(
                "Invalid expense, please check out the amount and the categoryId"
            )
        repository.upsertExpense(expense)
    }
}
