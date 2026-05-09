package com.example.finacapt.domain.usecase

import com.example.finacapt.data.entity.Category
import com.example.finacapt.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCategories @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke():Flow<List<Category>>  {
        return repository.getAllCategories()
    }
}