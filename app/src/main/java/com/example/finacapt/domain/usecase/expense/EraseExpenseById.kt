package com.example.finacapt.domain.usecase.expense

import com.example.finacapt.domain.repository.Repository
import javax.inject.Inject

class EraseExpenseById @Inject constructor(
    private val repository: Repository
){
    suspend operator fun invoke(id: Int){
        repository.deleteExpense(id)
    }
}
