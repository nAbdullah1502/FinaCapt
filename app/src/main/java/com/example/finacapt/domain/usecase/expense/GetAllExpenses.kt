package com.example.finacapt.domain.usecase.expense

import com.example.finacapt.data.entity.Expense
import com.example.finacapt.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllExpenses @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke():Flow<List<Expense>>  {
        return repository.getAllExpenses()
    }
}
